package ru.spbau.jvm.scala

trait Splitable[R <: HList, N <: MyNumber, ResultL <: HList, ResultR <: HList] {
  def apply(list: R, index: N): (ResultL, ResultR)
}

object Splitable {

  import HList._
  import MyNumber._

  implicit def zeroSplitable[A <: HList]: Splitable[A, Z.type, HNil.type, A] =
    (list: A, _: Z.type) => (HNil, list)

  implicit def splitable[H, T <: HList, N <: Number, ResultL <: HList, ResultR <: HList](implicit splitable: Splitable[T, N, ResultL, ResultR]):
  Splitable[HCons[H, T], S[N], HCons[H, ResultL], ResultR] = (list: HCons[H, T], number: S[N]) => {
    val (left, right) = splitable(list.tail, number.x)
    (HCons(list.head, left), right)
  }
}
