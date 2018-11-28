package ru.hse.spb.scala

class AATreeSet[T](implicit ordering: Ordering[T]) {

  private[AATreeSet] final case class Node(private[AATreeSet] var value: T, private[AATreeSet] var level: Int = 1, private[AATreeSet] var left: Node = null, private[AATreeSet] var right: Node = null, private[AATreeSet] var parent: Node = null) {

    private[AATreeSet] def predecessor(): Node = if (left == null) {
        null
    } else {
      var ans = left
      while (ans.right != null) {
        ans = ans.right
      }
      ans
    }

    private[AATreeSet] def successor(): Node = if (right == null) {
      null
    } else {
      var ans = right
      while (ans.left != null) {
        ans = ans.left
      }
      ans
    }

    def contains(elem: T): Boolean = if (value == elem)
      true
    else {
      if (ordering.gt(value, elem))
        if (left != null) left.contains(elem) else false
      else
      if (right != null) right.contains(elem) else false
    }

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

  private def skew(a: Node): Node =
    if (a == null || a.left == null || a.left.level != a.level) {
      a
    } else {
      var z = a.left
      a.left = z.right
      if (a.left != null) {
        a.left.parent = a
      }
      z.right = a
      z.parent = a.parent
      a.parent = z
      z
    }

  private def split(a: Node): Node =
    if (a == null || a.right == null || a.right.right == null || a.right.right.level != a.level) {
      a
    } else {
      var z = a.right
      a.right = z.left
      if (a.right != null) {
        a.right.parent = a
      }
      z.left = a
      z.parent = a.parent
      a.parent = z
      z.level = a.level + 1
      z
    }

  private def insert(_value: T, a: Node = root): Node = {
    var t = if (a == null) {
      Node(_value)
    } else if (ordering.equiv(_value, a.value)) {
      a
    } else if (ordering.lt(_value, a.value)) {
      a.left = insert(_value, a.left)
      a.left.parent = a
      split(skew(a))
    } else {
      a.right = insert(_value, a.right)
      a.right.parent = a
      split(skew(a))
    }
    t.parent = null
    t
  }

  private def decreaseLevel(t: Node): Node =
    if (t == null) {
      null
    } else {
      val newLevel = math.min(if (t.left != null) t.left.level else 0, if (t.right != null) t.right.level else 0) + 1
      t.level = newLevel
      if (t.right != null) {
        t.right.level = math.min(t.right.level, newLevel)
      }
      t.parent = null
      t
    }

  private def change(a: Node): Node =
    if (a == null) {
      null
    } else {
      var t = skew(decreaseLevel(a))
      if (t.right != null) {
        var x = skew(t.right)
        if (x.right != null) {
          x.right = skew(x.right)
        }
        t.right = x
      }
      t = split(t)
      if (t.right != null) {
        t.right = split(t.right)
      }
      t.parent = null
      t
    }

  def remove(_value: T, a: Node): Node = {
    var t = if (a == null) {
      null
    } else if (ordering.lt(_value, a.value)) {
      a.left = remove(_value, a.left)
      if (a.left != null) {
        a.left.parent = a
      }
      change(a)
    } else if (ordering.gt(_value, a.value)) {
      a.right = remove(_value, a.right)
      if (a.right != null) {
        a.right.parent = a
      }
      change(a)
    } else if (a.left != null) {
      val t = a.predecessor()
      a.left = remove(t.value, a.left)
      if (a.left != null) {
        a.left.parent = a
      }
      a.value = t.value
      change(a)
    } else if (a.right != null) {
      val t = a.successor()
      a.right = remove(t.value, a.right)
      if (a.right != null) {
        a.right.parent = a
      }
      a.value = t.value
      change(a)
    } else {
      null
    }
    if (t != null) {
      t.parent = null
    }
    t
  }

  private var root: Node = null

  class MyIterator extends Iterator[T] {
    private var cur: Node = if (root == null) null else {
      var left = root
      while (left.left != null) {
        left = left.left
      }
      left
    }

    override def hasNext: Boolean = cur != null

    override def next: T = {
      val ans = cur.value
      var n = cur.successor()
      if (n == null) {
        n = cur.parent
        while (n != null && n.right.value == cur.value) {
          cur = n
          n = cur.parent
        }
      }
      cur = n
      ans
    }
  }

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
    root = insert(elem, root)
    this
  }

  def -=(elem: T): AATreeSet[T] = {
    root = remove(elem, root)
    this
  }

  def forEach(op: T => Unit): Unit = {
    val iterator1 = iterator
    while (iterator1.hasNext) {
      op(iterator1.next)
    }
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

