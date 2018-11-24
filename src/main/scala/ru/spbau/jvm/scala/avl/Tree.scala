package ru.spbau.jvm.scala.avl

private sealed abstract class Tree[+A]

private case object AvlNil extends Tree[Nothing] {}

private case class AvlNode[+A](key: A, left: Tree[A], right: Tree[A]) extends Tree[A] {
  def this(key: A) = this(key, AvlNil, AvlNil)
}

private object AvlNode {

  def key[A](tree: Tree[A])(implicit ordering: Ordering[A]): Option[A] = tree match {
    case AvlNil => None
    case AvlNode(key, _, _) => Some(key)
  }

  def find[A](element: A)(tree: Tree[A])(implicit ordering: Ordering[A]): Option[Tree[A]] = tree match {
    case AvlNil => None
    case AvlNode(key, left, right) =>
      ordering.compare(element, key) match {
        case 0 => Some(tree)
        case r if r < 0 => find(element)(left)
        case _ => find(element)(right)
      }
  }

  def insert[A](element: A)(tree: Tree[A])(implicit ordering: Ordering[A]): Either[Tree[A], String] = tree match {
    case AvlNil => Left(new AvlNode(element))
    case AvlNode(key, left, right) =>
      ordering.compare(element, key) match {
        case 0 => Right("Such key already is in tree")
        case r if r < 0 => insert(element)(left) match {
          case Left(newLeft) => Left(AvlUtils.rebalanceIfNeeded(new AvlNode(key, newLeft, right)))
          case Right(message) => Right(message)
        }
        case _ => insert(element)(right) match {
          case Left(newRight) => Left(AvlUtils.rebalanceIfNeeded(new AvlNode(key, left, newRight)))
          case Right(message) => Right(message)
        }
      }
  }

  def removeKey[A](element: A)(tree: Tree[A])(implicit ordering: Ordering[A]): Either[Tree[A], String] = tree match {
    case AvlNil => Right("Such element does not exist")
    case node@AvlNode(key, left, right) =>
      ordering.compare(element, key) match {
        case 0 => Left(removeNode[A](node))
        case r if r < 0 => removeKey(element)(left) match {
          case Left(newLeft) => Left(AvlUtils.rebalanceIfNeeded(new AvlNode(key, newLeft, right)))
          case Right(message) => Right(message)
        }
        case _ => removeKey(element)(right) match {
          case Left(newRight) => Left(AvlUtils.rebalanceIfNeeded(new AvlNode(key, left, newRight)))
          case Right(message) => Right(message)
        }
      }
  }

  def size[A](tree: Tree[A]): Int = tree match {
    case AvlNil => 0
    case AvlNode(_, left, right) => size(left) + size(right) + 1
  }

  def height[A](tree: Tree[A]): Int = tree match {
    case AvlNil => 0
    case AvlNode(_, left, right) => 1 + Math.max(height(left), height(right))
  }

  def min[A](tree: Tree[A]): Option[A] = tree match {
    case AvlNil => None
    case AvlNode(key, AvlNil, _) => Some(key)
    case AvlNode(_, left, _) => min(left)
  }

  def max[A](tree: Tree[A]): Option[A] = tree match {
    case AvlNil => None
    case AvlNode(key, _, AvlNil) => Some(key)
    case AvlNode(_, _, right) => max(right)
  }

  def predecessor[A](tree: Tree[A]): Option[A] = tree match {
    case AvlNil => None
    case AvlNode(_, left, _) => max(left)
  }

  def successor[A](tree: Tree[A]): Option[A] = tree match {
    case AvlNil => None
    case AvlNode(_, _, right) => min(right)
  }

  def empty[A]: Tree[A] = AvlNil

  def map[A, B](function: A => B)(tree: Tree[A]): Tree[B] = tree match {
    case AvlNil => AvlNil
    case AvlNode(key, left, right) => new AvlNode[B](function(key), map(function)(left), map(function)(right))
  }

  def foreach[A](action: A => Unit)(tree: Tree[A]): Unit = tree match {
    case AvlNil =>
    case AvlNode(key, left, right) =>
      foreach(action)(left)
      action(key)
      foreach(action)(right)
  }

  def withFilter[A](predicate: A => Boolean)(tree: Tree[A])(implicit ordering: Ordering[A]): Tree[A] = tree match {
    case AvlNil => AvlNil
    case node@AvlNode(key, left, right) =>
      if (predicate(key)) {
        new AvlNode(key, withFilter(predicate)(left), withFilter(predicate)(right))
      } else {
        withFilter(predicate)(removeNode(node))
      }
  }

  def inorder[A](tree: Tree[A]): Seq[A] = tree match {
    case AvlNil => Seq.empty[A]
    case AvlNode(key, left, right) => inorder(left) ++ Seq(key) ++ inorder(right)
  }

  private def removeNode[A](node: AvlNode[A])(implicit ordering: Ordering[A]): Tree[A] = {
    val lower: Option[A] = predecessor[A](node)
    lower match {
      case Some(newKey) =>
        var newNode: AvlNode[A] = removeKey(newKey)(node) match {
          case Left(newTree: AvlNode[A]) => newTree
          case _ => node
        }
        replaceKey(newNode)(node.key)(newKey)
      case _ => node.right
    }
  }

  private def replaceKey[A](tree: Tree[A])(oldElement: A)(newElement: A)(implicit ordering: Ordering[A]): Tree[A] = tree match {
    case AvlNil => AvlNil
    case AvlNode(key, left, right) => ordering.compare(oldElement, key) match {
      case 0 => new AvlNode[A](newElement, left, right)
      case r if r < 0 => new AvlNode[A](key, replaceKey(left)(oldElement)(newElement), right)
      case _ => new AvlNode[A](key, left, replaceKey(right)(oldElement)(newElement))
    }
  }

  private def getLeft[A, B](either: Either[A, B]): A = either match {
    case Left(a) => a
    case _ => throw new IllegalArgumentException()
  }

  object AvlUtils {
    def balance[A](tree: Tree[A]): Int = tree match {
      case AvlNil => 0
      case AvlNode(key, left, right) => height(left) - height(right)
    }

    private def rotateLeft[A](tree: Tree[A]): Tree[A] = tree match {
      case AvlNode(parentKey, parentLeft, AvlNode(childKey, childLeft, childRight)) =>
        new AvlNode(childKey, new AvlNode(parentKey, parentLeft, childLeft), childRight)
      case _ => throw new AvlRotationException("left rotation", tree)
    }

    private def rotateRight[A](tree: Tree[A]): Tree[A] = tree match {
      case AvlNode(parentKey, AvlNode(childKey, childLeft, childRight), parentRight) =>
        new AvlNode(childKey, childLeft, new AvlNode(parentKey, childRight, parentRight))
      case _ => throw new AvlRotationException("right rotation", tree)
    }

    def rebalanceIfNeeded[A](tree: Tree[A]): Tree[A] = balance(tree) match {
      case 2 => rebalanceToRight(tree)
      case -2 => rebalanceToLeft(tree)
      case _ => tree
    }

    private def rebalanceToRight[A](tree: Tree[A]): Tree[A] = tree match {
      case node@AvlNode(key, left, right) => balance(left) match {
        case r if r >= 0 => rotateRight(tree)
        case _ => rotateRight(new AvlNode[A](key, rotateLeft(left), right))
      }
      case _ => throw new AvlRotationException("left rotation", tree)
    }

    private def rebalanceToLeft[A](tree: Tree[A]): Tree[A] = tree match {
      case node@AvlNode(key, left, right) => balance(right) match {
        case r if r <= 0 => rotateLeft(tree)
        case _ => rotateLeft(new AvlNode[A](key, left, rotateRight(right)))
      }
      case _ => throw new AvlRotationException("right rotation", tree)
    }
  }

  private class AvlRotationException(val rotationType: String, val node: Tree[Any])
    extends Exception(node match {
      case AvlNil => "Trying to rotate TreeNil subtree"
      case AvlNode(key, _, _) => s"Tree structure is illegal for $rotationType in node with key $key"
    })
}