class RBTreeSet[A](private val tree: RBTree[A] = Leaf) {

  private val sizeTree = tree.size

  def contains(key: A)(implicit ordA: Ordering[A]): Boolean = {
    RBTree.contains(tree)(key)
  }

  def +(elem: A)(implicit ordA: Ordering[A]): RBTreeSet[A] = {
    add(elem)
  }

  def add(elem: A)(implicit ordA: Ordering[A]): RBTreeSet[A] = {
    if (contains(elem)) this
    else new RBTreeSet[A](RBTree.insert(tree)(elem))
  }


  def -(elem: A)(implicit ordA: Ordering[A]): RBTreeSet[A] = {
    remove(elem)
  }

  def remove(elem: A)(implicit ordA: Ordering[A]): RBTreeSet[A] = {
    if (contains(elem)) new RBTreeSet[A](RBTree.remove(tree)(elem))
    else this
  }

  def iterator: RBIterator[A] = new RBIterator(toCustomList)

  def isEmpty: Boolean = sizeTree == 0

  def size: Int = {
    sizeTree
  }

  def foreach[B](f: A ⇒ B): Unit = {
    val it = iterator
    while (it.hasNext()) {
      f.apply(it.next())
    }
  }

  def toCustomList: CustomList[A] = {
    def inorder(node: RBTree[A]): CustomList[A] = {
      node match {
        case Leaf => Nil
        case RBNode(_, v, l, r) => append(inorder(l))(append(Cons(v, Nil))(inorder(r)))
      }

    }

    def append(xs: CustomList[A])(ys: CustomList[A]): CustomList[A] = {
      xs match {
        case Nil => ys
        case Cons(v, t) => Cons[A](v, append(t)(ys))
      }
    }

    inorder(tree)
  }

  def addAll(from: RBTreeSet[_ <: A])(implicit ordA: Ordering[A]): RBTreeSet[A] = {
    var result = this
    from.foreach(a => result = result.add(a))
    result
  }

  def containsAll(from: RBTreeSet[_ <: A])(implicit ordA: Ordering[A]): Boolean = {
    var res = true
    from.foreach(a => res &= contains(a))
    res
  }

  def removeAll(from: RBTreeSet[_ <: A])(implicit ordA: Ordering[A]): RBTreeSet[A] = {
    var result = this
    from.foreach(a => result = result.remove(a))
    result
  }

  def clear(implicit ordA: Ordering[A]): RBTreeSet[A] = {
    removeAll(this)
  }

  def flatMap[B](f: A => B)(implicit ord: Ordering[B]): RBTreeSet[B] = {
    var res = new RBTreeSet[B]()
    val it = iterator
    while (it.hasNext()) {
      res = res.add(f(it.next()))
    }
    res
  }

}
