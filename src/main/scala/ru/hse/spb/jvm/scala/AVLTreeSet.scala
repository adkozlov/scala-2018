package ru.hse.spb.jvm.scala

class AVLTreeSet[E](implicit val ordering: Ordering[E]) extends MutableCollection[E, AVLTreeSet[E]] {
  if (ordering eq null) throw new NullPointerException("elements must be ordered")

  private var _root: AVLNode = _
  private var _size = 0

  override def size: Int = _size

  override def iterator: MyIterator[E] = new AVLTreeIterator

  override def contains(elem: E): Boolean = findNode(elem).isDefined

  override def -=(key: E): AVLTreeSet.this.type = {
    remove(key)
    this
  }

  override def remove(key: E): Boolean = {
    var node = findNode(key).orNull
    if (node == null) return false

    if (node.left != null) {
      var max = node.left

      while (max.left != null || max.right != null) {
        while (max.right != null) max = max.right

        node._key = max.key
        if (max.left != null) {
          node = max
          max = max.left
        }
      }
      node._key = max.key
      node = max
    }

    if (node.right != null) {
      var min = node.right

      while (min.left != null || min.right != null) {
        while (min.left != null) min = min.left

        node._key = min.key
        if (min.right != null) {
          node = min
          min = min.right
        }
      }
      node._key = min.key
      node = min
    }

    var current = node
    var parent = node.parent
    while (parent != null) {
      parent.balanceFactor += (if (parent.left == current) -1 else 1)

      current = parent.balanceFactor match {
        case x if x < -1 =>
          if (parent.right.balanceFactor == 1) rotateRight(parent.right)
          val newRoot = rotateLeft(parent)
          if (parent == root) _root = newRoot
          newRoot
        case x if x > 1 =>
          if (parent.left.balanceFactor == -1) rotateLeft(parent.left)
          val newRoot = rotateRight(parent)
          if (parent == root) _root = newRoot
          newRoot
        case _ => parent
      }

      parent = current.balanceFactor match {
        case -1 | 1 => null
        case _ => current.parent
      }
    }

    if (node.parent != null) {
      if (node.parent.left == node) {
        node.parent._left = null
      } else {
        node.parent._right = null
      }
    }

    if (node == root) _root = null

    _size -= 1
    true
  }

  private def findNode(key: E): Option[AVLNode] = {
    var node = root
    while (node != null) {
      val cmp = ordering.compare(key, node.key)
      if (cmp == 0) return Some(node)
      node = node.matchNextChild(cmp)
    }
    None
  }

  private def root: AVLNode = _root

  private def rotateRight(node: AVLNode): AVLNode = {
    val leftNode = node.left
    node._left = leftNode.right
    if (node.left != null) node.left._parent = node

    leftNode._parent = node.parent
    if (leftNode.parent != null) {
      if (leftNode.parent.left == node) {
        leftNode.parent._left = leftNode
      } else {
        leftNode.parent._right = leftNode
      }
    }

    node._parent = leftNode
    leftNode._right = node

    node.balanceFactor -= 1
    if (leftNode.balanceFactor > 0) {
      node.balanceFactor -= leftNode.balanceFactor
    }

    leftNode.balanceFactor -= 1
    if (node.balanceFactor < 0) {
      leftNode.balanceFactor += node.balanceFactor
    }
    leftNode
  }

  private def rotateLeft(node: AVLNode): AVLNode = {
    val rightNode = node.right
    node._right = rightNode.left
    if (node.right != null) node.right._parent = node

    rightNode._parent = node.parent
    if (rightNode.parent != null) {
      if (rightNode.parent.left == node) {
        rightNode.parent._left = rightNode
      } else {
        rightNode.parent._right = rightNode
      }
    }

    node._parent = rightNode
    rightNode._left = node

    node.balanceFactor += 1
    if (rightNode.balanceFactor < 0) {
      node.balanceFactor -= rightNode.balanceFactor
    }

    rightNode.balanceFactor += 1
    if (node.balanceFactor > 0) {
      rightNode.balanceFactor += node.balanceFactor
    }
    rightNode
  }

  override def +=(key: E): AVLTreeSet.this.type = {
    add(key)
    this
  }

  override def add(key: E): Boolean = {
    if (root == null) {
      _root = new AVLNode(key)
      _size += 1
      return true
    }

    var node = root
    var parent: AVLNode = null
    var cmp = 0

    while (node != null) {
      parent = node
      cmp = ordering.compare(key, node.key)
      if (cmp == 0) return false
      node = node.matchNextChild(cmp)
    }

    val newNode = new AVLNode(key, parent)
    if (cmp <= 0) parent._left = newNode
    else parent._right = newNode

    while (parent != null) {
      cmp = ordering.compare(parent.key, key)
      if (cmp < 0) parent.balanceFactor -= 1
      else parent.balanceFactor += 1

      parent = parent.balanceFactor match {
        case -1 | 1 => parent.parent
        case x if x < -1 =>
          if (parent.right.balanceFactor == 1) rotateRight(parent.right)
          val newRoot = rotateLeft(parent)
          if (parent == root) _root = newRoot
          null
        case x if x > 1 =>
          if (parent.left.balanceFactor == -1) rotateLeft(parent.left)
          val newRoot = rotateRight(parent)
          if (parent == root) _root = newRoot
          null
        case _ => null
      }
    }

    _size += 1
    true
  }

  private def next(node: AVLNode): Option[AVLNode] = {
    var successor = node
    if (successor != null) {
      if (successor.right != null) {
        successor = successor.right
        while (successor != null && successor.left != null) {
          successor = successor.left
        }
      } else {
        successor = node.parent
        var n = node
        while (successor != null && successor.right == n) {
          n = successor
          successor = successor.parent
        }
      }
    }
    Option(successor)
  }

  def map[B](f: E => B)(implicit ordering: Ordering[B]): AVLTreeSet[B] = {
    val newCollection = new AVLTreeSet[B]
    for (element <- this) {
      newCollection.add(f(element))
    }
    newCollection
  }

  class AVLNode private[AVLTreeSet](k: E, p: AVLNode = null) {
    private[AVLTreeSet] var _key: E = k
    private[AVLTreeSet] var _parent: AVLNode = p
    private[AVLTreeSet] var _left: AVLNode = _
    private[AVLTreeSet] var _right: AVLNode = _
    private[AVLTreeSet] var balanceFactor: Int = 0

    def parent: AVLNode = _parent

    private[AVLTreeSet] def selectNextChild(key: E): AVLNode = matchNextChild(ordering.compare(key, this.key))

    private[AVLTreeSet] def matchNextChild(cmp: Int): AVLNode = cmp match {
      case x if x < 0 => left
      case x if x > 0 => right
      case _ => null
    }

    def left: AVLNode = _left

    def right: AVLNode = _right

    def key: E = _key
  }

  private def minNode(): AVLNode = {
    if (root == null) throw new UnsupportedOperationException("empty tree")
    var node = root
    while (node.left != null) node = node.left
    node
  }

  class AVLTreeIterator extends MyIterator[E] {
    var currentNode: AVLNode = _
    var currentIndex: Int = -1

    override def next: E = {
      if (!hasNext) {
        throw new UnsupportedOperationException("There is no next element")
      }
      currentNode = if (currentNode eq null) minNode() else AVLTreeSet.this.next(currentNode).get
      currentIndex += 1
      currentNode._key
    }

    override def hasNext: Boolean = currentIndex + 1 < size
  }
}