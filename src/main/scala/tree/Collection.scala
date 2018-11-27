package tree

trait Collection[E] {

  def size: Int

  def isEmpty: Boolean = size != 0

  def add(element: E): Collection[E]

  def contains(element: E): Boolean = {
    this.exists(e => e.equals(element))
  }

  def remove(element: E): Collection[E]

  def iterator: Iterator[E]

  def foreach(f: E => Unit): Unit = {
    val it: Iterator[E] = iterator
    while (it.hasNext) {
      f(it.next)
    }
  }

  def forall(p: E => Boolean): Boolean = {
    val it: Iterator[E] = iterator
    while (it.hasNext) {
      if (!p(it.next)) return false
    }
    true
  }

  def exists(p: E => Boolean): Boolean = {
    !forall(!p(_))
  }

  def foldl[S](z: S)(f: (S, E) => S): S = iterator.foldl(z)(f)

  def foldr[S](z: S)(f: (E, S) => S): S = iterator.foldr(z)(f)

  def flatMap[S](f: E => S)(implicit ordering: Ordering[S]): Collection[S]
}