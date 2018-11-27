package ru.spbau.jvm.scala

class TreeRB[A : Manifest](implicit val ordering: Ordering[A]) {

  private var root: RBNode = _
  private var _size = 0

  def size: Int = _size

  def isEmpty: Boolean = root == null

  def contains(key: A): Boolean = findNode(key).isDefined

  def max() : A = {
    if (root == null)
      throw new  NoSuchElementException("empty tree")
    maxFromNode(root).key
  }

  def min() : A = {
    if (root == null)
      throw new  NoSuchElementException("empty tree")
    minFromNode(root).key
  }

  def insert(key: A): Boolean = {
    if (key == null)
      throw new IllegalArgumentException("argument to insert is null")

    var wasInserted = false

    def insert (x : RBNode, key : A) : RBNode = {
      var node = x
      if (node == null) {
        wasInserted = true
        return new RBNode(key)
      }

      val cmp = ordering.compare(key, node.key)
      if (cmp < 0)
        node.left = insert(node.left, key)
      if (cmp > 0)
        node.right = insert(node.right, key)

      if (isRed(node.right) && !isRed(node.left))
        node = rotateLeft(node)
      if (isRed(node.left) && isRed(node.left.left))
        node = rotateRight(node)
      if (isRed(node.left) && isRed(node.right))
        inverseColor(node)
      node
    }

    root = insert(root, key)
    root.makeBlack()

    if (wasInserted)
      _size += 1
    wasInserted
  }

  def remove(key: A): Boolean = {

    if (key == null)
      throw new IllegalArgumentException("argument to delete is null")

    val node = findNode(key).orNull
    if (node == null)
      return false

    def remove(x : RBNode, key : A) : RBNode = {
      var node = x

      if (ordering.compare(key, node.key) < 0)  {
        if (!isRed(node.left) && !isRed(node.left.left)) {
          inverseColor(node)
          if (isRed(node.right.left)) {
            node.right = rotateRight(node.right)
            node = rotateLeft(node)
            inverseColor(node)
          }
        }
        node.left = remove(node.left, key)
      }
      else {
        if (isRed(node.left))
          node = rotateRight(node)
        if (ordering.compare(key, node.key) == 0 && (node.right == null))
          return null
        if (!isRed(node.right) && !isRed(node.right.left)) {
          inverseColor(node)
          if (isRed(node.left.left)) {
            node = rotateRight(node)
            inverseColor(node)
          }
        }
        if (ordering.compare(key, node.key) == 0) {
          val x = minFromNode(node.right)
          node.key = x.key
          node.right = remove(node.right, x.key)
        }
        else
          node.right = remove(node.right, key)
      }
      if (isRed(node.right))
        node = rotateLeft(node)
      if (isRed(node.left) && isRed(node.left.left))
        node = rotateRight(node)
      if (isRed(node.left) && isRed(node.right))
        inverseColor(node)
      node
    }


    if (!isRed(root.left) && !isRed(root.right))
      root.makeRed()

    root = remove(root, key)

    if (!isEmpty)
      root.makeBlack()

    _size -= 1
    true
  }

  private def rotateRight(node: RBNode): RBNode = {
    val newRoot = node.left
    node.left = newRoot.right
    newRoot.right = node
    newRoot.color = newRoot.right.color
    newRoot.right.makeRed()
    newRoot
  }

  private def rotateLeft(node: RBNode): RBNode = {
    val newRoot = node.right
    node.right = newRoot.left
    newRoot.left = node
    newRoot.color = newRoot.left.color
    newRoot.left.makeRed()
    newRoot
  }

  private def inverseColor(node : RBNode) {
    node.color = !node.color
    if (node.left != null)
      node.left.color = !node.left.color
    if (node.right != null)
      node.right.color = !node.right.color
  }

  private def findNode(key: A): Option[RBNode] = {
    if (key == null)
      throw new IllegalArgumentException("argument to find is null")
    var node = root
    while (node != null) {
      val cmp = ordering.compare(key, node.key)
      if (cmp == 0)
        return Some(node)
      if (cmp < 0)
        node = node.left
      else
        node = node.right
    }
    None
  }

  private def minFromNode(node : RBNode): RBNode = {
    var cur = node
    while (cur.left != null)
      cur = cur.left
    cur
  }

  private def maxFromNode(node : RBNode): RBNode = {
    var cur = node
    while (cur.right != null)
      cur = cur.right
    cur
  }

  private def isRed(node: RBNode): Boolean = {
    if (node == null)
      return false
    node.color
  }

  class RBNode private[TreeRB](k: A) {

    private[TreeRB] var key: A = k
    private[TreeRB] var left: RBNode = _
    private[TreeRB] var right: RBNode = _
    private[TreeRB] var color: Boolean = true

    def makeRed(): Unit = color = true
    def makeBlack(): Unit = color = false
  }

  class MyIterator {
    private var _ind: Int = 0
    private val _size: Int = size
    private val _keys: Array[A] = infixTraversal()

    private def infixTraversal(): Array[A] = {
      val keys : Array[A] = new Array[A](_size)
      var j = 0

      def infixTraversalHelper(node : RBNode): Unit = {
        if (node == null)
          return
        if (node.left != null)
          infixTraversalHelper(node.left)
        keys(j) = node.key
        j += 1
        if (node.right != null)
          infixTraversalHelper(node.right)
      }

      infixTraversalHelper(root)
      keys
    }

    def hasNext() : Boolean = _ind != _size

    def next(): A = {
      if (_ind == _size)
        throw new NoSuchElementException("iteration has no more elements")
      val answer = _keys(_ind)
      _ind += 1
      answer
    }

  }

}