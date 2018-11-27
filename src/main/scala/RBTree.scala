abstract sealed class Color

case object Red extends Color

case object Black extends Color


abstract sealed class RBTree[+A] {
  def color: Color

  def value: A

  def size: Int = 0

  def left: RBTree[A]

  def right: RBTree[A]

}

case object Leaf extends RBTree[Nothing] {
  def color: Color = Black

  def value: Nothing = throw new NoSuchElementException("Leafs in RB-tree don't have values")

  def left: RBTree[Nothing] = throw new NoSuchElementException("Leaf has no subtrees!")

  def right: RBTree[Nothing] = throw new NoSuchElementException("Leaf has no subtrees!")
}


case class RBNode[A](color: Color, value: A, left: RBTree[A], right: RBTree[A]) extends RBTree[A] {
  override def size: Int = left.size + right.size + 1
}

object RBTree {
  def create[A](c: Color, v: A, l: RBTree[A] = Leaf, r: RBTree[A] = Leaf): RBTree[A] = RBNode(c, v, l, r)

  private def makeBlack[A](node: RBTree[A]): RBTree[A] = {
    node match {
      case RBNode(_, v, l, r) => RBNode(Black, v, l, r)
      case l => l
    }
  }

  private def balance[A](color: Color, value: A, left: RBTree[A], right: RBTree[A]): RBTree[A] = (color, left, right)
  match {
    case (Black, RBNode(Red, p, RBNode(Red, x, t1, t2), t3), u) => //left left case
      create(Red, p, RBNode(Black, x, t1, t2), RBNode(Black, value, t3, u))
    case (Black, RBNode(Red, p, t1, RBNode(Red, x, t2, t3)), u) => //left right case
      create(Red, x, RBTree.create(Black, p, t1, t2), RBTree.create(Black, value, t3, u))
    case (Black, u, RBNode(Red, p, t3, RBNode(Red, x, t4, t5))) => //right right case
      create(Red, p, RBTree.create(Black, value, u, t3), RBTree.create(Black, x, t4, t5))
    case (Black, u, RBNode(Red, p, RBNode(Red, x, t3, t4), t5)) => //right left case
      create(Red, x, RBTree.create(Black, value, u, t3), RBTree.create(Black, p, t4, t5))
    case _ => create(color, value, left, right)
  }

  private def balanceTree[A](tree: RBTree[A]): RBTree[A] = balance(tree.color, tree.value, tree.left, tree.right)

  def insert[A](tree: RBTree[A])(element: A)(implicit ord: Ordering[A]): RBTree[A] = makeBlack(insertHelper(tree)(element))

  private def insertHelper[A](tree: RBTree[A])(element: A)(implicit ord: Ordering[A]): RBTree[A] = {
    tree match {
      case Leaf => create(Red, element, Leaf, Leaf)
      case RBNode(color, value, left, right) =>
        ord.compare(element, value) match {
          case -1 => balance(color, value, insertHelper(left)(element), right)
          case 1 => balance(color, value, left, insertHelper(right)(element))
          case _ => tree

        }
    }
  }

  def remove[A](tree: RBTree[A])(element: A)(implicit ord: Ordering[A]): RBTree[A] = makeBlack(removeHelper(tree)(element))

  def removeHelper[A](tree: RBTree[A])(element: A)(implicit ord: Ordering[A]): RBTree[A] = {
    tree match {
      case Leaf => throw new IllegalStateException("Remove from empty tree")
      case RBNode(color, value, left, right) =>
        ord.compare(element, value) match {
          case -1 => deleteLeft(element)(tree)
          case 1 => deleteRight(element)(tree)
          case _ => merge(left)(right)

        }
    }
  }

  private def deleteLeft[A](element: A)(tree: RBTree[A])(implicit ord: Ordering[A]): RBTree[A] = {
    tree match {
      case RBNode(Red, v, l, r) => balanceLeft(create(Black, v, removeHelper(l)(element), r))
      case RBNode(Black, v, l, r) => create(Red, v, removeHelper(l)(element), r)
      case Leaf => throw new NoSuchElementException("You can't delete from Leaf")
    }
  }

  private def deleteRight[A](element: A)(tree: RBTree[A])(implicit ord: Ordering[A]): RBTree[A] = {
    tree match {
      case RBNode(Red, v, l, r) => balanceRight(create(Black, v, l, removeHelper(r)(element)))
      case RBNode(Black, v, l, r) => create(Red, v, l, removeHelper(r)(element))
      case Leaf => throw new NoSuchElementException("You can't delete from Leaf")
    }
  }

  private def balanceRight[A](tree: RBTree[A]): RBTree[A] = {
    tree match {
      case RBNode(Black, y, t1, RBNode(Red, x, t2, t3)) => create(Red, y, t1, RBNode(Black, x, t2, t3))
      case RBNode(Black, y, RBNode(Black, z, t1, t2), t3) => balanceTree(create(Black, y, RBNode(Red, z, t1, t2), t3))
      case RBNode(Black, y, RBNode(Red, z, RBNode(Black, v, t1, t2), RBNode(Black, u, t3, t4)), t5)
      => create(Red, u, balanceTree(RBNode(Black, z, RBNode(Red, v, t1, t2), t3)), RBNode(Black, y, t4, t5))
      case _ => tree
    }
  }

  private def balanceLeft[A](tree: RBTree[A]): RBTree[A] = {
    tree match {
      case RBNode(Black, y, RBNode(Red, x, t1, t2), t3) => create(Red, y, RBNode(Black, x, t1, t2), t3)
      case RBNode(Black, y, t1, RBNode(Black, z, t2, t3)) => balanceTree(create(Black, y, t1, RBNode(Red, z, t2, t3)))
      case RBNode(Black, y, t1, RBNode(Red, z, RBNode(Black, u, t2, t3), RBNode(Black, v, t4, t5)))
      => create(Red, u, RBNode(Black, y, t1, t2), balanceTree(create(Black, z, t3, RBNode(Red, v, t4, t5))))
      case _ => tree
    }
  }


  private def merge[A](t1: RBTree[A])(t2: RBTree[A]): RBTree[A] = {
    (t1, t2) match {
      case (Leaf, t) => t
      case (t, Leaf) => t
      case (RBNode(Black, _, _, _), RBNode(Red, x, t3, t4)) => create(Red, x, merge(t1)(t3), t4)
      case (RBNode(Red, x, t3, t4), RBNode(Black, v, l, r)) => create(Red, x, t1, merge(t4)(t2))
      case (RBNode(Red, x, t1, t2), RBNode(Red, y, t3, t4)) =>
        merge(t2)(t3) match {
          case RBNode(Red, z, s1, s2) => create(Red, z, RBNode(Red, x, t1, s1), RBNode(Red, y, s2, t4))
          case RBNode(Black, z, s1, s2) => create(Red, x, t1, RBNode(Red, y, merge(t2)(t3), t4))
          case l => l
        }

      case (RBNode(Black, x, t1, t2), RBNode(Black, y, t3, t4)) =>
        merge(t2)(t3) match {
          case RBNode(Red, z, s1, s2) => create(Red, z, RBNode(Black, x, t1, s1), RBNode(Black, y, s2, t4))
          case RBNode(Black, z, s1, s2) => balanceLeft(create(Black, x, t1, RBNode(Black, y, merge(t2)(t3), t4)))
          case l => l
        }
    }
  }

  def contains[A](tree: RBTree[A])(element: A)(implicit ord: Ordering[A]): Boolean = {
    tree match {
      case Leaf => false
      case RBNode(c, v, l, r) => ord.compare(element, v) match {
        case -1 => contains(l)(element)
        case 0 => true
        case 1 => contains(r)(element)
      }
    }
  }

}