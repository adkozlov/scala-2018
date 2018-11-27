import scala.annotation.tailrec
import scala.util.Random

object Treap {
  private val randomizer = new Random()

  protected def merge[T <: Comparable[T]](left: Treap[T], right: Treap[T]): Treap[T] = {
    new Treap(mergeNodes(left.root, right.root))
  }

  protected def mergeNodes[T <: Comparable[T]](left: TreapNode[T], right: TreapNode[T]): TreapNode[T]
  = (left, right) match {
    case (EmptyNode, _) | (_, EmptyNode) => _
    case (left: Node[T], right: Node[T]) =>
      if (left.y > right.y) {
        left.updateChildren(newRightChild = mergeNodes(left.getRight, right))
        left.getRight
      } else {
        right.updateChildren(newLeftChild = mergeNodes(left, right.getLeft))
        right.getLeft
      }
  }

  protected def split[T <: Comparable[T]](treap: Treap[T], key: T): (Treap[T], Treap[T]) = {
    val (left, right) = splitNode(treap.root, key)
    (new Treap(left), new Treap(right))
  }

  protected def splitNode[T <: Comparable[T]](node: TreapNode[T], key: T): (TreapNode[T], TreapNode[T]) = {
    case _: EmptyNode.type => Tuple2(EmptyNode(), EmptyNode())
    case node: Node[T] =>
      node.x.compareTo(key) match {
        case -1 | 0 =>
          val (lesser, greater) = splitNode(node.getRight, key)
          node.updateChildren(newRightChild = lesser)
          (node, greater)
        case 1 =>
          val (lesser, greater) = splitNode(node.getLeft, key)
          node.updateChildren(newLeftChild = greater)
          (lesser, node)
      }
  }
}

class Treap[T <: Comparable[T]] private(private var root: TreapNode[T]) extends Tree[T] {
  override def size(): Int = root.size()

  private def find(t: T): Node[T] = {
    @tailrec
    def findNode(root: TreapNode[T], x: T): Node[T] = root match {
      case EmptyNode => null
      case root: Node[T] => if (root.x.equals(x)) root else {
        val nextNode = if (root.x.compareTo(x) < 0) root.getRight else root.getLeft
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
    case n: Node[T] => n.counter += 1
  }

  override def delete(t: T): Unit = find(t) match {
      case node: Node[T] =>
        node.counter -= 1
        if (node.counter > 0)
          return
        if (node.getParent != null) {
          val parent = node.getParent
          val newSubtree = Treap.mergeNodes(node.getLeft, node.getRight)
          if (parent.getLeft eq node)
            parent.updateChildren(newLeftChild = newSubtree)
          else
            parent.updateChildren(newRightChild = newSubtree)
        } else {
          root = Treap.mergeNodes(node.getLeft, node.getRight)
        }
  }

  override def count(t: T): Int = find(t) match {
    case node: Node[T] => node.counter
    case null => 0
  }

  override def map[U <: Comparable[U]](f: T => U): Tree[U] = ???

  override def flatMap[U <: Comparable[U]](f: T => Tree[U]): Tree[U] = ???

  override def filter(f: T => Boolean): Tree[T] = ???
}

