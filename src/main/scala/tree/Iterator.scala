package tree

trait Iterator[E] {

  def hasNext: Boolean

  def next: E

  def concat(iterator: Iterator[E]): Iterator[E] = {
    class ConcatIterator(first: Iterator[E], second: Iterator[E]) extends Iterator[E] {
      override def hasNext: Boolean = first.hasNext || second.hasNext

      override def next: E = if (first.hasNext) first.next else second.next
    }

    new ConcatIterator(this, iterator)
  }

  def foldl[S](z: S)(f: (S, E) => S): S = {
    var result: S = z
    while (this.hasNext) {
      result = f(result, this.next)
    }
    result
  }

  def foldr[S](z: S)(f: (E, S) => S): S = if (this.hasNext) f(this.next, foldr(this)) else z
}

class EmptyIterator[E] extends Iterator[E] {

  override def hasNext: Boolean = false

  override def next: E = throw OutOfElementsException
}

class SingleIterator[E](element: E) extends Iterator[E] {

  var used = false

  override def hasNext: Boolean = !used

  override def next: E = if (used) throw OutOfElementsException else {
    used = true
    element
  }
}