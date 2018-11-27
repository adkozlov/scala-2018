import scala.annotation.tailrec

object AVLTree {
  def apply[A](values: A*)(implicit ordering: Ordering[_ >: A]): AVLTree[A] = {
    val tree = new AVLTree[A]()
    tree.addAll(values: _*)
    tree
  }
}

class AVLTree[A](implicit ordering: Ordering[_ >: A]) {
  private var _root: AVLNode = _
  private var _size: Int = 0

  import ordering._


  // common operations

  def size: Int = _size

  def isEmpty: Boolean = size == 0

  def nonEmpty: Boolean = !isEmpty

  def clear(): Unit = {
    _root = null
    _size = 0
  }

  def contains(elem: A): Boolean = contains(_root, elem)

  def containsAll(tree: AVLTree[A]): Boolean
  = tree.forall(contains)

  def containsAll(values: A*): Boolean
  = AVLTree[A](values: _*).forall(contains)

  def add(elem: A): Unit = {
    _root = add(_root, elem)
    _size += 1
  }

  def addAll(tree: AVLTree[A]): Unit =
    tree.foreach(add)

  def addAll(values: A*): Unit =
    values.foreach(add)

  def remove(elem: A): Unit =
    _root = remove(_root, elem)

  def removeAll(tree: AVLTree[A]): Unit =
    tree.foreach(remove)

  def removeAll(values: A*): Unit =
    values.foreach(remove)

  def minOrDefault(default: A): A =
    min(_root, default)

  def maxOrDefault(default: A): A =
    max(_root, default)

  override def equals(any: Any): Boolean = {
    if (any == null || !any.isInstanceOf[AVLTree[A]]) {
      return false
    }

    val tree = any.asInstanceOf[AVLTree[A]]
    size == tree.size && containsAll(tree) && tree.containsAll(this)
  }

  override def hashCode(): Int = {
    var hashCode = 1
    for (e: A <- this) {
      hashCode = 31 * hashCode + (if (e == null) 0 else e.hashCode)
    }
    hashCode
  }


  // higher-order functions

  def withFilter(predicate: A => Boolean): AVLTree[A] =
    filter(predicate)

  def filter(test: A => Boolean): AVLTree[A] = {
    val result = new AVLTree[A]
    foreach(elem => if (test(elem)) result.add(elem))
    result
  }

  def map[B](f: A => B)(implicit ordering: Ordering[B]): AVLTree[B] = {
    val result = new AVLTree[B]
    foreach(elem => result.add(f(elem)))
    result
  }

  def flatMap[B](f: A => AVLTree[B])(implicit ordering: Ordering[B]): AVLTree[B] = {
    val result = new AVLTree[B]
    foreach(elem => f(elem).foreach(result.add))
    result
  }

  def foreach(f: A => Unit): Unit =
    traverseWhileTrue(_root, elem => {f(elem); true})

  def forall(test: A => Boolean): Boolean =
    traverseWhileTrue(_root, test)

  def exists(test: A => Boolean): Boolean = {
    var testHolds = false

    traverseWhileTrue(_root, elem => {
      testHolds = test(elem)
      !testHolds // when the test holds, traverse is stopped
    })

    testHolds
  }


  // structural helpers

  private final class AVLNode(val key: A, var left: AVLNode = null, var right: AVLNode = null) {
    var _height = 1

    def balanceFactor: Int = height(right) - height(left)

    // re-evaluate the height
    def fixHeight(): Unit =
      _height = Math.max(height(left), height(right)) + 1
  }

  @tailrec
  private def min(node: AVLNode, default: A): A =
    if (node == null)
      default
    else if (node.left == null)
      node.key
    else
      min(node.left, default)

  @tailrec
  private def max(node: AVLNode, default: A): A =
    if (node == null)
      default
    else if (node.right == null)
      node.key
    else
      max(node.right, default)

  // wrapper for AVLNode.height, which works with null nodes
  private def height(node: AVLNode): Int =
    if (node == null) 0 else node._height

  // a rotation, used when balance factor == 1
  private def rotateRight(node: AVLNode): AVLNode = {
    val newRoot = node.left
    node.left = newRoot.right
    newRoot.right = node

    node.fixHeight()
    newRoot.fixHeight()

    newRoot
  }

  // a rotation, used when balance factor == 1
  private def rotateLeft(node: AVLNode): AVLNode = {
    val newRoot = node.right
    node.right = newRoot.left
    newRoot.left = node

    node.fixHeight()
    newRoot.fixHeight()

    newRoot
  }

  // big rotations, for |balance factor| == 2
  private def balance(node: AVLNode): AVLNode = {
    node.fixHeight()

    if (node.balanceFactor == 2) {
      if (node.right.balanceFactor >= 0)
        return rotateLeft(node)
      else
        node.right = rotateRight(node.right)
    }

    if (node.balanceFactor == -2) {
      if (node.left.balanceFactor <= 0)
        return rotateRight(node)
      else
        node.left = rotateLeft(node.left)
    }

    node // there is no need in balancing
  }

  private def add(node: AVLNode, elem: A): AVLNode = {
    if (node == null)
      return new AVLNode(elem)

    if (elem < node.key)
      node.left = add(node.left, elem)
    else
      node.right = add(node.right, elem)

    balance(node)
  }

  @tailrec
  private def getMinNode(node: AVLNode): AVLNode = {
    assert(node != null, "Unusual behaviour: parameter must not be null")
    if (node.left == null) node else getMinNode(node.left)
  }

  private def deleteMinNode(node: AVLNode): AVLNode =
    if (node.left == null) {
      node.right // one or zero nodes, as we are in AVL tree
    } else {
      node.left = deleteMinNode(node.left)
      balance(node)
    }

  private def remove(node: AVLNode, elem: A): AVLNode = {
    if (node == null)
      return null

    if (elem < node.key) {
      node.left = remove(node.left, elem)
      return balance(node)
    }

    if (elem > node.key) {
      node.right = remove(node.right, elem)
      return balance(node)
    }

    // elem == node.key
    val left = node.left
    val right = node.right
    _size -= 1

    if (right == null) {
      left
    } else {
      val min = getMinNode(right)
      min.right = deleteMinNode(right)
      min.left = left
      balance(min)
    }
  }

  @tailrec
  private def contains(node: AVLNode, elem: A): Boolean =
    if (node == null || elem == node.key)
      node != null // if true, then elem == node.key
    else
      contains(if (elem < node.key) node.left else node.right, elem)

  /**
    * @return true if the test holds on the node, else false
    */
  private def traverseWhileTrue(node: AVLNode, test: A => Boolean): Boolean =
    if (node == null)
      true
    else
      traverseWhileTrue(node.left, test) && test(node.key) && traverseWhileTrue(node.right, test)
}

object Main {
  def main(args: Array[String]): Unit = {

  }
}
