trait Splitable[I <: PositiveNumber, A <: HList, L <: HList, R <: HList] {
  def apply(list: A, index: I): (L, R)
}

object Splitable {

  import HList._
  import PositiveNumber._

  // splitAt(A, Zero) = (HNil, A)
  implicit def zeroSplitable[A <: HList, I <: PositiveNumber]: Splitable[Zero.type, A, HNil.type, A] =
    (list: A, index: Zero.type) => (HNil, list)

  //splitAt(A, I) = (L, R)
  //splitAt(HA :: A, Suc(I)) = (HA :: L, R)
  implicit def splitable[I <: PositiveNumber, A <: HList, L <: HList, R <: HList, HA]
  (implicit splitable: Splitable[I, A, L, R]):
  Splitable[Suc[I], HCons[HA, A], HCons[HA, L], R] =
    (list: HCons[HA, A], index: Suc[I]) => {
      val (l, r) = splitable(list.tail, index.prev)
      (HCons(list.head, l), r)
    }

}
