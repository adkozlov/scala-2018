sealed trait TreapNode[+T] {
  def size(): Int
}

case object EmptyNode extends TreapNode[Nothing] {
  override def size(): Int = 0
}

final case class Node[T](x: T, y: Int) extends TreapNode[T] {

  private var counter = 1
  private var parent: Node[T] = _
  private var left: TreapNode[T] = EmptyNode
  private var right: TreapNode[T] = EmptyNode
  private var subtreeSize = 1

  def getCounter: Int = counter
  def getParent: Node[T] = parent
  def getLeft: TreapNode[T] = left
  def getRight: TreapNode[T] = right

  def inc(): Int = {
    counter += 1
    updateSize()
    counter
  }

  def dec(): Int = {
    counter -= 1
    updateSize()
    counter
  }

  private def updateSize(): Unit = subtreeSize = left.size() + right.size() + counter

  override def size(): Int = subtreeSize
  def updateChildren(newLeftChild: TreapNode[T] = left, newRightChild: TreapNode[T] = right): Node[T] = {
    left = newLeftChild
    right = newRightChild

    updateSize()
    left match {
      case value: Node[T] => value.parent = this
      case _ =>
    }
    right match {
      case value: Node[T] => value.parent = this
      case _ =>
    }
    this
  }
}