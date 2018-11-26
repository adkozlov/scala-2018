package ru.hse.jvm.scala.set

class AVLIterator[K](tree: AVLTree[K]) {
  private var stack: Stack[AVLTree[K]] = StackNil

  {
    walkToLeftestNode(tree)
  }

  def walkToLeftestNode(tree: AVLTree[K]): Unit = {
    var node = tree
    while (node != AVLNil) {
      stack = stack.add(node)
      val AVLNode(left, _ , _) = node
      node = left
    }
  }

  def hasNext: Boolean = stack.isNotEmpty

  def next(): K = {
    val topNode = stack.top
    stack = stack.pop()
    val AVLNode(_, result, right) = topNode
    walkToLeftestNode(right)
    result
  }
}
