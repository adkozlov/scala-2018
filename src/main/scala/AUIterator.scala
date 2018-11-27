trait AUIterator[A] {
  def hasNext(): Boolean

  def next(): A
}
