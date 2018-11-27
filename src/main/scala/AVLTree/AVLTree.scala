package AVLTree

sealed abstract class AVLTree[+V]() {

  def size: Int

  def height: Int

  def foreach(f: V => Unit): Unit

  def map[W](f: V => W)(implicit ordering: Ordering[W]): AVLTree[W]

  def flatMap[W](f: V => AVLTree[W])(implicit ordering: Ordering[W]): AVLTree[W]

  def min(): AVLTree[V]

  def max(): AVLTree[V]
}

case object AVLLeaf extends AVLTree[Nothing] {

  override def height: Int = 0

  override def size: Int = 0

  override def foreach(f: Nothing => Unit): Unit = {}

  override def map[W](f: Nothing => W)(implicit ord: Ordering[W]): AVLTree[W] = AVLLeaf

  override def flatMap[W](f: Nothing => AVLTree[W])(implicit ord: Ordering[W]): AVLTree[W] = AVLLeaf

  def min(): AVLTree[Nothing] = this

  def max(): AVLTree[Nothing] = this
}

final case class AVLNode[+V](left: AVLTree[V], value: V, right: AVLTree[V]) extends AVLTree[V] {

  override def height: Int = math.max(left.height, right.height) + 1

  override def size: Int = left.size + 1 + right.size

  override def foreach(f: V => Unit): Unit = {
    left.foreach(f)
    f(value)
    right.foreach(f)
  }

  override def map[W](f: V => W)(implicit ordering: Ordering[W]): AVLTree[W] = {
    var result: AVLTree[W] = AVLLeaf
    foreach((v: V) => result = AVLTree.add(f(v), result))
    result
  }

  override def flatMap[W](f: V => AVLTree[W])(implicit ordering: Ordering[W]): AVLTree[W] = {
    var result: AVLTree[W] = AVLLeaf
    foreach((v: V) => f(v).foreach(x => result = AVLTree.add(x, result)))
    result
  }

  override def min(): AVLTree[V] = left match {
    case AVLLeaf => this
    case _ => left.min()
  }

  override def max(): AVLTree[V] = right match {
    case AVLLeaf => this
    case _ => right.min()
  }
}

object AVLTree {

  def apply[V](values: V*)(implicit ord: Ordering[V]): AVLTree[V] = {
    var result: AVLTree[V] = AVLLeaf
    for (e <- values) {
      result = AVLTree.add(e, result)
    }
    result
  }

  def add[V](e: V, tree: AVLTree[V])(implicit ordering: Ordering[V]): AVLTree[V] = tree match {
    case AVLLeaf => AVLNode(AVLLeaf, e, AVLLeaf)
    case AVLNode(l, v, r) => balance(ordering.compare(v, e) match {
      case -1 => AVLNode[V](l, v, add(e, r))
      case _ => AVLNode[V](add(e, l), v, r)
    })
  }

  def isBalanced[V](t: AVLTree[V]): Boolean = t match {
    case AVLLeaf => true
    case AVLNode(l, _, r) => math.abs(l.height - r.height) <= 1 && isBalanced(l) && isBalanced(r)
  }

  def diff[V](l: AVLTree[V], r: AVLTree[V]): Int = l.height - r.height

  def balance[V](tree: AVLTree[V]): AVLTree[V] = {
    if (isBalanced(tree)) return tree

    tree match {
      // small left rotation
      case AVLNode(l, a, b@AVLNode(c, v, r))
        if diff(b, l) == 2 && c.height <= r.height => AVLNode(AVLNode(l, a, c), v, r)

      // small right rotation
      case AVLNode(b@AVLNode(l, v, c), a, r)
        if diff(b, r) == 2 && c.height <= l.height => AVLNode(l, v, AVLNode(c, a, r))

      // big left rotation
      case AVLNode(l, a, b@AVLNode(c@AVLNode(m, x, n), v, r))
        if diff(b, l) == 2 && c.height > r.height => AVLNode(AVLNode(l, a, m), x, AVLNode(n, v, r))

      // big right rotation
      case AVLNode(b@AVLNode(l, v, c@AVLNode(m, x, n)), a, r)
        if diff(b, r) == 2 && c.height > l.height => AVLNode(AVLNode(l, v, m), x, AVLNode(n, a, r))

    }
  }

  def contains[V](e: V, tree: AVLTree[V])(implicit ord: Ordering[V]): Boolean = tree match {
    case AVLLeaf => false
    case AVLNode(l, v, r) => ord.compare(v, e) match {
      case -1 => contains(e, r)
      case 0 => true
      case 1 => contains(e, l)
    }
  }

  def remove[V](e: V, tree: AVLTree[V])(implicit ord: Ordering[V]): AVLTree[V] = balance(tree match {
    case AVLLeaf => AVLLeaf
    case AVLNode(l, v, r) => ord.compare(v, e) match {
      case -1 => AVLNode(l, v, remove(e, r))
      case 1 => AVLNode(remove(e, l), v, r)
      case 0 if l.height < r.height =>
        r.min() match {
          case AVLLeaf => l
          case AVLNode(_, c, _) => AVLNode(l, c, remove(c, r))
        }
      case 0 if l.height >= r.height =>
        r.max() match {
          case AVLLeaf => r
          case AVLNode(_, c, _) => AVLNode(remove(c, l), c, r)
        }
    }
  })
}