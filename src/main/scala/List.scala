sealed trait List[+T] {
  def map[R](f:T => R): List[R]
}

case object Nil extends List[Nothing] {
  override def map[R](f: Nothing => R): List[R] = Nil
}
final case class Tail[T](x: T, tail: List[T]) extends List[T] {
  override def map[R](f: T => R): List[R] = Tail(f(x), tail.map(f))
}
