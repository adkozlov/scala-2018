package heterogeneous

import nat._

sealed trait HList {
  type Size <: Nat
  type Head
  type Tail <: HList
  type Append[L <: HList] <: HList

  def head: Head
  def tail: Tail

  def ::[V](value: V) = HCons(value, this)

//  def apply[I <: Size]: Head
}

case object HNil extends HList {
  type Size = Zero
  type Head = Nothing
  type Tail = Nothing
  type Append[L <: HList] = L

  def head: Head = throw new NoSuchElementException()
  def tail: Tail = throw new NoSuchElementException()

  override def ::[V](value: V) = HCons(value, this)

//  override def apply[I <: Size]: Option[Head] = None
}

final case class HCons[H, T <: HList, S <: Nat](head: H, tail: T) extends HList {
  type Size = S
  type Head = H
  type Tail = T
  type Append[L <: HList] = HCons[Head, Tail#Append[L], Succ[Size]]

  override def ::[V](value: V) = HCons(value, this)

}
