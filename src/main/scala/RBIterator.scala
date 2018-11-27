class RBIterator[A](private var aggregator: CustomList[A]) extends AUIterator[A] {

  override def hasNext(): Boolean = {
    aggregator match {
      case Nil => false
      case Cons(v, tail) => true
    }
  }

  override def next(): A = {
    aggregator match {
      case Nil => throw new NoSuchElementException()
      case Cons(v, tail) =>
        aggregator = tail
        v
    }
  }
}
