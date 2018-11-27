sealed trait TreapNode[T <: Comparable[T]] {
  def size(): Int
  protected def updateParent(node: Node[T]): Unit = {}
}

case object EmptyNode extends TreapNode[Nothing] {
  override def size(): Int = 0
}
final case class Node[T](x: T, y: Int) extends TreapNode[T] {
  var counter = 0
  private var parent: Node[T] = _
  private var left: TreapNode[T] = EmptyNode()
  private var right: TreapNode[T] = EmptyNode()
  private var subtreeSize = 1

  def getParent: Node[T] = parent
  def getLeft: TreapNode[T] = left
  def getRight: TreapNode[T] = right

  override def size(): Int = subtreeSize
  def updateChildren(newLeftChild: TreapNode[T] = left, newRightChild: TreapNode[T] = right): Unit = {
    left = newLeftChild
    right = newRightChild

    subtreeSize = left.size() + right.size()
    left.updateParent(this)
    right.updateParent(this)
  }

  override protected def updateParent(node: Node[T]): Unit = parent = node
}