package ru.hse.spb.kazakov

class Treap[A](implicit ordering: Ordering[A]) extends Collection[A] {
  private var _size = 0
  private var root: Node = _

  def size: Int = _size

  override def clear(): Unit = {
    root = null
    _size = 0
  }

  override def contains(value: A): Boolean = {
    val (left, equal, right) = split(root, value)
    root = mergeAll(left, equal, right)
    equal != null
  }

  override def add(value: A): Boolean = {
    val (less, equal, greaterOrEq) = split(root, value)
    root = mergeAll(less, equal, new Node(value), greaterOrEq)
    _size += 1
    true
  }

  override def remove(value: A): Boolean = {
    val (less, equal, greaterOrEq) = split(root, value)
    root = merge(less, greaterOrEq)

    if (equal != null) {
      _size -= 1
      true
    } else {
      false
    }
  }

  private def split(node: Node, value: A): (Node, Node, Node) = {
    if (node == null) {
      return (null, null, null)
    }

    val compareResult = ordering.compare(value, node.value)
    if (compareResult > 0) {
      val (less, equal, greaterOrEq) = split(node.right, value)
      node.right = less
      (node, equal, greaterOrEq)
    } else if (compareResult < 0) {
      val (less, equal, greaterOrEq) = split(node.left, value)
      node.left = greaterOrEq
      (less, equal, node)
    } else {
      val less = node.left
      val greaterOrEq = node.right
      node.left = null
      node.right = null
      (less, node, greaterOrEq)
    }
  }

  private def mergeAll(nodes: Node*): Node = nodes.foldRight[Node](null) {
    merge
  }

  private def merge(less: Node, greater: Node): Node = (less, greater) match {
    case (null, _) => greater
    case (_, null) => less
    case _ =>
      if (less.priority <= greater.priority) {
        less.right = merge(less.right, greater)
        less
      } else {
        greater.left = merge(less, greater.left)
        greater
      }
  }

  override def foreach[B](fun: Function[_ >: A, B]): Unit = {
    def dfs(node: Node): Unit = {
      if (node == null) {
        return
      }
      dfs(node.left)
      fun.apply(node.value)
      dfs(node.right)
    }

    dfs(root)
  }

  def map[B](fun: Function[_ >: A, B])(
      implicit ordering: Ordering[B]): Treap[B] = {
    val result = new Treap[B]()(ordering)
    foreach(e => result.add(fun.apply(e)))
    result
  }

  def flatMap[B](fun: Function[_ >: A, Treap[B]])(
      implicit ordering: Ordering[B]): Treap[B] = {
    val result = new Treap[B]()(ordering)
    foreach(e => result.addAll(fun.apply(e)))
    result
  }

  def filter(predicate: Function[_ >: A, Boolean]): Treap[A] = {
    val result = new Treap[A]
    foreach(e => if (predicate.apply(e)) result.add(e))
    result
  }

  override def equals(any: Any): Boolean = {
    if (any == null || !any.isInstanceOf[Treap[A]]) {
      return false
    }

    val treap = any.asInstanceOf[Treap[A]]
    if (_size != treap.size) {
      return false
    }
    var result = true
    treap.foreach(result &= contains(_))
    result
  }

  override def hashCode(): Int = {
    var hash = 0
    var index = 0
    foreach { e =>
      hash += scala.math.pow(e.hashCode(), index + 1).toInt
      index += 1
    }
    hash
  }

  private final class Node(val value: A) {
    val priority: Int = scala.util.Random.nextInt
    var left: Node = _
    var right: Node = _
  }

}
