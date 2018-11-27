package tree

abstract sealed class Tree[E](implicit ordering: Ordering[E]) extends Collection[E] {
  def height: Int

  def correct: Boolean

  override def add(element: E): Tree[E] = {
    val tree = this match {
      case Leaf() => Branch(Leaf(), element, Leaf())
      case Branch(l, v, r) => ordering.compare(v, element) match {
        case -1 => Branch(l, v, r.add(element))
        case _ => Branch(l.add(element), v, r)
      }
    }
    tree.normalize
  }

  override def remove(element: E): Tree[E] = {
    val tree = this match {
      case Leaf() => Leaf()
      case Branch(l, v, r) => ordering.compare(v, element) match {
        case -1 => Branch(l, v, r.remove(element))
        case 0 => r match {
          case Leaf() => l
          case _ => Branch(l, r.min(), r.extractMin())
        }
        case 1 => Branch(l.remove(element), v, r)
      }
    }
    tree.normalize
  }

  override def iterator: Iterator[E] = this match {
    case Leaf() => new EmptyIterator[E]
    case Branch(l, v, r) => l.iterator.concat(new SingleIterator[E](v)).concat(r.iterator)
  }

  def min(): E = this match {
    case Leaf() => throw OutOfElementsException
    case Branch(l, v, r) => l match {
      case Leaf() => v
      case Branch(_, _, _) => l.min()
    }
  }

  def max(): E = this match {
    case Leaf() => throw OutOfElementsException
    case Branch(l, v, r) => r match {
      case Leaf() => v
      case Branch(_, _, _) => r.max()
    }
  }

  private def extractMin(): Tree[E] = {
    val tree = this match {
      case Leaf() => throw OutOfElementsException
      case Branch(l, v, r) => l match {
        case Leaf() => r
        case Branch(_, _, _) => l.extractMin()
      }
    }
    tree.normalize
  }

  protected def normalize: Tree[E] = this match {
    case Leaf() => Leaf()
    case Branch(l, v, r) if !l.correct => Branch(l.normalize, v, r)
    case Branch(l, v, r) if !r.correct => Branch(l, v, r.normalize)

    case Branch(l, a, bp@Branch(cp@Branch(m, c, n), b, r))
      if bp.height - l.height == 2 && cp.height > r.height
    => Branch(Branch(l, a, m), c, Branch(n, b, r)) //big left rotation

    case Branch(bp@Branch(l, b, c), a, r)
      if bp.height - r.height == 2 && c.height <= l.height
    => Branch(l, b, Branch(c, a, r)) //small right rotation

    case Branch(bp@Branch(l, b, cp@Branch(m, c, n)), a, r)
      if bp.height - r.height == 2 && cp.height > l.height
    => Branch(Branch(l, b, m), c, Branch(n, a, r)) //big right rotation

    case Branch(l, a, bp@Branch(c, b, r))
      if bp.height - l.height == 2 && c.height > r.height
    => Branch(Branch(l, a, c), b, r) //small left rotation

    case _ => this
  }

}

final case class Leaf[E]()(implicit ordering: Ordering[E]) extends Tree[E]() {
  override def height: Int = 0

  override def correct: Boolean = true

  override def size: Int = 0
}

private final case class Branch[E]
(
  left: Tree[E],
  value: E,
  right: Tree[E]
)(implicit ordering: Ordering[E]) extends Tree[E]() {
  override def height: Int = math.max(left.height, right.height) + 1

  override def correct: Boolean = {
    left.correct && right.correct && math.abs(left.height - right.height) < 2
  }

  override def size: Int = left.size + right.size + 1
}

object TreeExample {

  def main(args: Array[String]): Unit = {
  }
}