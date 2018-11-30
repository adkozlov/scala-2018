import scala.annotation.tailrec
import scala.util.Random

object Treap {
  private val randomizer = new Random()

  protected def merge[T](left: Treap[T], right: Treap[T])(implicit ordering: Ordering[T]): Treap[T] = {
    new Treap(mergeNodes(left.root, right.root))
  }

  protected def mergeNodes[T](left: TreapNode[T], right: TreapNode[T]): TreapNode[T]
  = (left, right) match {
    case (EmptyNode, _) | (_, EmptyNode) => if (left.isInstanceOf[EmptyNode.type]) right else left
    case (left: Node[T], right: Node[T]) =>
      if (left.y > right.y)
        left.updateChildren(newRightChild = mergeNodes(left.getRight, right))
      else
        right.updateChildren(newLeftChild = mergeNodes(left, right.getLeft))

  }

  protected def split[T](treap: Treap[T], key: T)(implicit ordering: Ordering[T]): (Treap[T], Treap[T]) = {
    val (left, right) = splitNode(treap.root, key)
    (new Treap(left), new Treap(right))
  }

  protected def splitNode[T](node: TreapNode[T], key: T)(implicit ordering: Ordering[T]): (TreapNode[T], TreapNode[T])
  = node match {
    case EmptyNode => Tuple2(EmptyNode, EmptyNode)
    case node: Node[T] =>
      ordering.compare(node.x, key) match {
        case x if x <= 0 =>
          val (lesser, greater) = splitNode(node.getRight, key)
          (node.updateChildren(newRightChild = lesser), greater)
        case _ =>
          val (lesser, greater) = splitNode(node.getLeft, key)
          (lesser, node.updateChildren(newLeftChild = greater))
      }
  }
}

class Treap[T] private(private var root: TreapNode[T])(implicit ordering: Ordering[T]) extends Tree[T] {
  def this()(implicit ordering: Ordering[T]) {
    this(EmptyNode)
  }

  override def size(): Int = root.size()

  private def find(t: T): Node[T] = {
    @tailrec
    def findNode(root: TreapNode[T], x: T): Node[T] = root match {
      case EmptyNode => null
      case root: Node[T] => if (ordering.compare(root.x, x) == 0) root else {
        val nextNode = if (ordering.compare(root.x, x) < 0) root.getRight else root.getLeft
        findNode(nextNode, x)
      }
    }

    findNode(root, t)
  }

  override def add(t: T): Unit = find(t) match {
    case null =>
      val newNode = Node(t, Treap.randomizer.nextInt())
      val (left, right) = Treap.split(this, t)
      root = Treap.mergeNodes(Treap.mergeNodes(left.root, newNode), right.root)
    case node: Node[T] =>
      node.inc()
      var parent = node.getParent
      while (parent != null) {
        parent.updateChildren()
        parent = parent.getParent
      }
  }

  override def delete(t: T): Unit = find(t) match {
      case node: Node[T] =>
        if (node.dec() == 0) {
          val (left, right) = Treap.split(this, t)
          root = Treap.merge(Treap.split(left, t)._1, right).root
        } else {
          var parent = node.getParent
          while (parent != null) {
            parent.updateChildren()
            parent = parent.getParent
          }
        }
      case null =>
  }

  override def count(t: T): Int = find(t) match {
    case node: Node[T] => node.getCounter
    case null => 0
  }

  def toList: List[T] = {
    def nodeToList(node: TreapNode[T], list: List[T]): List[T] = node match {
      case EmptyNode => list
      case node: Node[T] => nodeToList(node.getLeft, Tail(node.x, nodeToList(node.getRight, list)))
    }

    nodeToList(root, Nil)
  }

  def map[U](f: T => U)(implicit ordering: Ordering[U]): Treap[U] = {
    val newTreap = new Treap[U]()
    toList.map(el => newTreap.add(f(el)))
    newTreap
  }

  def flatMap[U](f: T => Treap[U])(implicit ordering: Ordering[U]): Treap[U] = {
    val newTreap = new Treap[U]()
    toList.map(el => f(el).toList.map(el => newTreap.add(el)))
    newTreap
  }

  def foreach(f: T => Unit): Unit = {
    toList.map(f)
  }
}

