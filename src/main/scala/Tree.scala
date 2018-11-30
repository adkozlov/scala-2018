trait Tree[T] {
  def size(): Int

  def add(t: T):Unit
  def addAll(tArray: T*):Unit = {
    for (t <- tArray)
      add(t)
  }

  def delete(t: T)

  def contains(t: T):Boolean = count(t) != 0
  def count(t: T):Int
}