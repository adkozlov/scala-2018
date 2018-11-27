package ru.hse.jvm.scala.set

class TreeSet[K](private val tree: AVLTree[K] = AVLNil)(implicit keyOrdering: Ordering[K]) {
  def contains(elem: K): Boolean = tree.contains(elem)

  def +(elem: K): TreeSet[K] = if (contains(elem)) this else new TreeSet(tree.add(elem))

  def -(elem: K): TreeSet[K] = if (!contains(elem)) this else new TreeSet(tree.erase(elem))

  def iterator: AVLIterator[K] = new AVLIterator(tree)

  def size: Int = tree.size

  def isEmpty: Boolean = size == 0

  def isNotEmpty: Boolean = !isEmpty

  def foreach(function: K => Unit): Unit = {
    val it = iterator
    while (it.hasNext) {
      function(it.next())
    }
  }

  def foldLeft[V](initial: V)(function: (V, K) => V): V = {
    var result = initial
    foreach(key => result = function(result, key))
    result
  }

  def foldRight[V](initial: V)(function: (K, V) => V): V = {
    var result = initial
    var stack: Stack[K] = StackNil
    foreach(key => stack = stack.add(key))
    while (stack.isNotEmpty) {
      result = function(stack.top, result)
      stack = stack.pop()
    }
    result
  }

  def map[V](function: K => V)(implicit keyOrdering: Ordering[V]): TreeSet[V] =
    foldLeft(TreeSet.emptySet[V])(_ + function(_))

  def flatMap[V](function: K => TreeSet[V])(implicit keyOrdering: Ordering[V]): TreeSet[V] =
    foldLeft(TreeSet.emptySet[V])(_ ++ function(_))

  def filter(predicate: K => Boolean): TreeSet[K] =
    flatMap(key => if (predicate(key)) TreeSet.setOf(key) else TreeSet.emptySet[K])

  def filterNot(predicate: K => Boolean): TreeSet[K] = filter(key => !predicate(key))

  def withFilter(predicate: K => Boolean): WithFilter = new WithFilter(predicate)

  def ++(other: TreeSet[K]): TreeSet[K] = foldLeft(other)(_ + _)

  def --(other: TreeSet[K]): TreeSet[K] = other.foldLeft(this)(_ - _)

  def &(other: TreeSet[K]): TreeSet[K] = filter(other.contains)

  def &~(other: TreeSet[K]): TreeSet[K] = this -- other

  def |(other: TreeSet[K]): TreeSet[K] = this ++ other

  def elementsEquals(that: TreeSet[K]): Boolean = {
    if (size != that.size)
      return false

    val thisIterator = iterator
    val thatIterator = that.iterator

    while (thisIterator.hasNext) {
      if (thisIterator.next() != thatIterator.next())
        return false
    }

    true
  }

  override def equals(that: Any): Boolean = that match {
    case that: TreeSet[K] => elementsEquals(that)
    case _ => false
  }

  class WithFilter(predicate: K => Boolean) {
    def map[V](function: K => V)(implicit keyOrdering: Ordering[V]): TreeSet[V] = filter(predicate).map(function)

    def withFilter(otherPredicate: K => Boolean): WithFilter = new WithFilter(x => predicate(x) && otherPredicate(x))

    def foreach[V](function: K => Unit): Unit = filter(predicate).foreach(function)
  }
}

object TreeSet {
  def emptySet[K](implicit keyOrdering: Ordering[K]): TreeSet[K] = new TreeSet[K]()

  def setOf[K](values: K*)(implicit keyOrdering: Ordering[K]): TreeSet[K] = {
    if (values.isEmpty)
      emptySet[K]
    else
      setOf[K](values.tail: _*) + values.head
  }
}
