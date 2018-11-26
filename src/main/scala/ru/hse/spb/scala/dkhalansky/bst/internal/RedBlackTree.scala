package ru.hse.spb.scala.dkhalansky.bst.internal

sealed abstract class RedBlackTree[+A] {
  def makeBlack: RedBlackTree[A]
}

sealed trait Color

final case object Red extends Color
final case object Black extends Color

final case class Node[+A](color: Color,
                          leftTree: RedBlackTree[A],
                          value: A,
                          rightTree: RedBlackTree[A])
    extends RedBlackTree[A] {
  override def makeBlack = copy(color = Black)
}

final case object Leaf extends RedBlackTree[Nothing] {
  override def makeBlack: RedBlackTree[Nothing] = this
}

object RedBlackTree {

  def elem[A](a: A, tree: RedBlackTree[A])(
      implicit ordering: Ordering[A]): Option[A] = tree match {
    case Leaf => None
    case Node(_, leftTree, value, rightTree) =>
      import ordering._
      if (a == value)
        Some(a)
      else if (a < value)
        elem(a, leftTree)
      else
        elem(a, rightTree)
  }

  def insert[A](a: A, tree: RedBlackTree[A])(
      implicit ordering: Ordering[A]): RedBlackTree[A] = tree match {
    case Leaf => Node(Red, Leaf, a, Leaf)
    case node @ Node(color, leftTree, value, rightTree) =>
      import ordering._
      if (a == value)
        node.copy(value = a)
      else
        rebalance(
          if (a < value)
            node.copy(leftTree = insert(a, leftTree))
          else
            node.copy(rightTree = insert(a, rightTree)))
  }

  def delete[A](a: A, tree: RedBlackTree[A])(
      implicit ordering: Ordering[A]): RedBlackTree[A] = tree match {
    case Leaf => Leaf
    case node @ Node(color, leftTree, value, rightTree) =>
      import ordering._
      if (a < value) {
        val newTree = node.copy(leftTree = delete(a, leftTree))
        color match {
          case Black => leftBalance(newTree)
          case Red => newTree
        }
      } else if (a > value) {
        val newTree = node.copy(rightTree = delete(a, rightTree))
        color match {
          case Black => rightBalance(newTree)
          case Red => newTree
        }
      } else fuse(leftTree, rightTree)
  }

  def fuse[A](tree1: RedBlackTree[A],
              tree2: RedBlackTree[A]): RedBlackTree[A] = (tree1, tree2) match {
    case (Leaf, t) => t
    case (t, Leaf) => t
    case (t1 @ Node(Black, _, _, _), Node(Red, t3, y, t4)) =>
      Node(Red, fuse(t1, t3), y, t4)
    case (Node(Red, t1, x, t2), t3 @ Node(Black, _, _, _)) =>
      Node(Red, t1, x, fuse(t2, t3))
    case (Node(Red, t1, x, t2), Node(Red, t3, y, t4)) =>
      fuse(t2, t3) match {
        case Node(Red, s1, z, s2) =>
          Node(Red, Node(Red, t1, x, s1), z, Node(Red, s2, y, t4))
        case s @ Node(Black, _, _, _) =>
          Node(Red, t1, x, Node(Red, s, y, t4))
        case Leaf =>
          Node(Red, t1, x, Node(Red, Leaf, y, t4))
      }
    case (Node(Black, t1, x, t2), Node(Black, t3, y, t4)) =>
      fuse(t2, t3) match {
        case Node(Red, s1, z, s2) =>
          Node(Red, Node(Black, t1, x, s1), z, Node(Black, s2, y, t4))
        case s @ Node(Black, _, _, _) =>
          leftBalance(Node(Black, t1, x, Node(Black, s, y, t4)))
        case Leaf =>
          leftBalance(Node(Black, t1, x, Node(Black, Leaf, y, t4)))
      }
  }

  private def leftBalance[A](tree: Node[A]): Node[A] = tree match {
    case Node(_, Node(Red, t1, x, t2), y, t3) => Node(Red, Node(Black, t1, x, t2), y, t3)
    case Node(_, t1, y, Node(Black, t2, z, t3)) => rebalance(Node(Black, t1, y, Node(Red, t2, z, t3)))
    case Node(_, t1, y, Node(Red, Node(Black, t2, u, t3), z, t4@Node(Black, l, value, r))) =>
      Node(Red, Node(Black, t1, y, t2), u, rebalance(Node(Black, t3, z, Node(Red, l, value, r))))
    case _ => tree
  }

  private def rightBalance[A](tree: Node[A]): Node[A] = tree match {
    case Node(_, t1, y, Node(Red, t2, x, t3)) =>
        Node(Red, t1, y, Node(Black, t2, x, t3))
    case Node(_, Node(Black, t1, z, t2), y, t3) =>
        rebalance(Node(Black, Node(Red, t1, z, t2), y, t3))
    case Node(_, Node(Red, t1@Node(Black, l, value, r), z, Node(Black, t2, u, t3)), y, t4) =>
        Node(Red, rebalance(Node(Black, Node(Red, l, value, r), z, t2)), u, Node(Black, t3, y, t4))
    case _ => tree
  }

  private def rebalance[A](tree: Node[A]): Node[A] = {
    val build_tree = (a: RedBlackTree[A],
                      b: RedBlackTree[A],
                      c: RedBlackTree[A],
                      d: RedBlackTree[A],
                      x: A,
                      y: A,
                      z: A) => {
      Node(Red, Node(Black, a, x, b), y, Node(Black, c, z, d))
    }
    tree match {
      case Node(Black, Node(Red, Node(Red, a, x, b), y, c), z, d) =>
        build_tree(a, b, c, d, x, y, z)
      case Node(Black, Node(Red, a, x, Node(Red, b, y, c)), z, d) =>
        build_tree(a, b, c, d, x, y, z)
      case Node(Black, a, x, Node(Red, Node(Red, b, y, c), z, d)) =>
        build_tree(a, b, c, d, x, y, z)
      case Node(Black, a, x, Node(Red, b, y, Node(Red, c, z, d))) =>
        build_tree(a, b, c, d, x, y, z)
      case _ => tree
    }
  }

}
