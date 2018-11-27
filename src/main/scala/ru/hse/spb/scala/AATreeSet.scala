package ru.hse.spb.scala

class AATreeSet[T](implicit ordering: Ordering[T]) {

  private[AATreeSet] final case class Node(private[AATreeSet] var value: T, private[AATreeSet] var level: Int = 1, private[AATreeSet] var left: Node = null, private[AATreeSet] var right: Node = null, private[AATreeSet] var parent: Node = null){
    private def skew(): Node = if (left == null || left.level != level) {
      this
    } else {
      var z = Node(value, level, left.right, right)
      var x = Node(left.value, left.level, left.left, z, parent)
      z.parent = x
      x
    }

    private def split(): Node = if (right == null || right.right == null || right.right.level != level) {
      this
    } else {
      var z = Node(value, level, left, right.left)
      var x = Node(right.value, right.level + 1, z, right.right, parent)
      z.parent = x
      x
    }

    def insert(_value: T): Node = if (_value == value) {
      this
    } else if (ordering.lt(_value, value)) {
      Node(value, level, if (left == null) Node(_value) else left.insert(_value), right, parent)
        .skew()
        .split()
    } else {
      Node(value, level, left, right.insert(_value), parent)
        .skew()
        .split()
    }

    private def predecessor(): Node = {
      if (left == null) {
        null
      } else {
        var ans = left
        while (ans.right != null) {
          ans = ans.right
        }
        ans
      }
    }

    def successor(): Node = if (right == null) {
      null
    } else {
      var ans = right
      while (ans.left != null) {
        ans = ans.left
      }
      ans
    }

    private def decreaseLevel(): Node = {
      val newLevel = math.min(if (left != null) left.level else 0, if (right != null) right.level else 0) + 1
      var x = Node(value, newLevel, left, null, parent)
      var z = if (right != null) Node(right.value, math.min(newLevel, right.level), null, null, x) else null
      x.right = z
      x
    }

    private def change(): Node = {
      var t = decreaseLevel()
        .skew()
      if (t.right != null) {
        var x = t.right.skew()
        if (x.right != null) {
          x.right = x.right.skew()
        }
        t.right = x
      }
      t = t.split()
      if (t.right != null) {
        t.right = t.right.split()
      }
      t
    }

    def remove(_value: T): Node = if (ordering.lt(_value, value)) {
      Node(value, level, if (left != null) left.remove(_value) else null, right, parent)
        .change()
    } else if (ordering.gt(_value, value)) {
      Node(value, level, left, if (left != null) right.remove(_value) else null, parent)
        .change()
    } else {
      if (left != null) {
        val t = predecessor()
        Node(t.value, level, left.remove(t.value), right, parent)
          .change()
      } else if (right != null) {
        val t = successor()
        Node(t.value, level, left, right.remove(t.value), parent)
          .change()
      } else {
        null
      }
    }

    def contains(elem: T): Boolean = if (value == elem)
      true
    else if (ordering.gt(value, elem))
      if (left != null) left.contains(elem) else false
    else
      if (right != null) right.contains(elem) else false

    def foldLeft[S](z: S)(op: (S, T) => S): S = {
      var t = z
      if (left != null) {
        t = left.foldLeft(t)(op)
      }
      t = op(t, value)
      if (right != null) {
        t = right.foldLeft(t)(op)
      }
      t
    }

    def foldRight[S](z: S)(op: (T, S) => S): S = {
      var t = z
      if (right != null) {
        t = right.foldRight(t)(op)
      }
      t = op(value, t)
      if (left != null) {
        t = left.foldRight(t)(op)
      }
      t
    }
  }

  class MyIterator extends Iterator[T] {
    var cur: Node = if (root == null) null else {
      var left = root
      while (left.left != null) {
        left = left.left
      }
      left
    }

    val rightmostValue: T = {
      var right = root
      while (right.right != null) {
        right = right.right
      }
      right.value
    }

    override def hasNext: Boolean = {
      cur.value != rightmostValue
    }

    override def next: T = {
      val ans = cur.value
      var next = cur.successor()
      if (next == null) {
        next = cur.parent
        while (next != null && next.right.value == cur.value) {
          cur = next
          next = cur.parent
        }
        cur = next
      }
      ans
    }
  }

  private var root: Node = null

  def map[S](f: T => S)(implicit ordering: Ordering[S]): AATreeSet[S] = {
    var ansSet = new AATreeSet[S]()
    val iterator1 = this.iterator
    while (iterator1.hasNext) {
      ansSet += f(iterator1.next)
    }
    ansSet
  }

  def foldLeft[S](z: S)(op: (S, T) => S): S = if (root == null) z else root.foldLeft(z)(op)

  def foldRight[S](z: S)(op: (T, S) => S): S = if (root == null) z else root.foldRight(z)(op)

  def contains(elem: T): Boolean = if (root == null) false else root.contains(elem)

  def +=(elem: T): AATreeSet[T] = {
    if (root == null) {
      root = Node(elem)
    } else {
      root.insert(elem)
    }
    this
  }

  def -=(elem: T): AATreeSet[T] = {
    if (root != null) {
      root.remove(elem)
    }
    this
  }

  def iterator: Iterator[T] = new MyIterator()
}

object AATreeSet {
  def apply[T](implicit ordering: Ordering[T]): AATreeSet[T] = new AATreeSet[T]()

  def apply[T](args: T*)(implicit ordering: Ordering[T]): AATreeSet[T] = if (args.isEmpty) {
    apply(ordering)
  } else {
    val set = apply[T](args.tail: _*)(ordering)
    set += args.head
  }
}

