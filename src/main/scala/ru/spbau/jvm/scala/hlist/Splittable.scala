package ru.spbau.jvm.scala.hlist

trait Splittable[A <: HList, N <: Nat, L <: HList, R <: HList] {
  def apply(list: A, index: N): (L, R)
}

object Splittable {

  import HList._

  // splitBy(A, Z) = (HNil, A)
  implicit def zeroSplittable[A <: HList]: Splittable[A, Z.type, HNil.type, A] =
    (list: A, _) => (HNil, list)

  // splitBy (A, N) = (L, R)
  // splitBy (H :: A, S(N)) = (H :: L, R)
  implicit def splittable[H, A <: HList, N <: Nat, L <: HList, R <: HList](implicit splittable: Splittable[A, N, L, R]): Splittable[HCons[H, A], S[N], HCons[H, L], R] =
    (list: HCons[H, A], index: S[N]) => index match {
      case S(n: N) =>
        val (left, right) = splittable(list.tail, n)
        (HCons(list.head, left), right)
    }
}