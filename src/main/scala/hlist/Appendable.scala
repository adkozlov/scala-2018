package hlist

trait Appendable[X <: HList, Y <: HList, R <: HList] {
  def apply(xs: X, ys: Y): R
}

object Appendable {

  import HList._

  // HNil ::: Y = Y
  implicit def nilAppendable[Y <: HList]: Appendable[HNil.type, Y, Y] =
    (_: HNil.type, ys: Y) => ys

  // X ::: Y = R
  // (H :: X) ::: Y = (H :: R)
  implicit def appendable[X <: HList, Y <: HList, H, R <: HList]
      (implicit appendable: Appendable[X, Y, R]): Appendable[HCons[H, X], Y, HCons[H, R]] =
      (xs: HCons[H, X], ys: Y) => HCons(xs.head, appendable(xs.tail, ys))
}