package mit

import hlist.Nat
import hlist.Nat.{Succ, Zero}
import org.scalatest.{FlatSpec, Matchers}

class TestHList extends FlatSpec with Matchers {

  import hlist.HList._

  "zip" should "return HNil" in {
    HNil zip HNil should be(HNil)
    HNil zip 1 :: HNil should be(HNil)
    1 :: HNil zip HNil should be(HNil)
  }

  "zip" should "return zipped values" in {
    (1 :: HNil) zip (2 :: HNil) should be((1, 2) :: HNil)
    (1 :: 3 :: HNil) zip (2 :: HNil) should be((1, 2) :: HNil)
    (1 :: HNil) zip (2 :: 4 :: HNil) should be((1, 2) :: HNil)
    (1 :: 3 :: HNil) zip (2 :: 4 :: HNil) should be((1, 2) :: (3, 4) :: HNil)
  }

  "split" should "split lists" in {
    HNil.split(Zero) should be((HNil, HNil))
    (1 :: HNil).split(Zero) should be((HNil, 1 :: HNil))
    (1 :: HNil).split(Succ(Zero)) should be(1 :: HNil, HNil)
    (1 :: 2 :: HNil).split(Succ(Zero)) should be(1 :: HNil, 2 :: HNil)
    (1 :: 2 :: HNil).split(Succ(Succ(Zero))) should be(1 :: 2 :: HNil, HNil)
  }
}