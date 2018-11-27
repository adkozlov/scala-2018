trait Tree[T <: Ordering[T]] {
  def size(): Int

  def add(t: T):Unit
  def addAll(tArray: T*):Unit = {
    for (t <- tArray)
      add(t)
  }

  def delete(t: T)

  def contains(t: T):Boolean = count(t) != 0
  def count(t: T):Int

  def map[U <: Ordering[U]](f:T => U): Tree[U]
  def flatMap[U <: Ordering[U]](f:T => Tree[U]): Tree[U]
  def filter(f:T => Boolean): Tree[T]
}