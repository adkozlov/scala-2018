import org.scalatest.{FlatSpec, Matchers}

class SplitAtTest extends FlatSpec with Matchers {
  import HList._
  import PositiveNumber._

  private val list = 1::"hi"::88.8::'w'::HNil

  "SplitAt" should "return (HNil, List) if split at Zero" in {
    assert(list.splitAt(Zero) === (HNil, list))
  }

  "SplitAt" should "split correctly at Suc(n)" in {
    assert(list.splitAt(Suc(Zero)) === (1::HNil, "hi"::88.8::'w'::HNil))
    assert(list.splitAt(Suc(Suc(Zero))) === (1::"hi"::HNil, 88.8::'w'::HNil))
    assert(list.splitAt(Suc(Suc(Suc(Zero)))) === (1::"hi"::88.8::HNil, 'w'::HNil))
    assert(list.splitAt(Suc(Suc(Suc(Suc(Zero))))) === (1::"hi"::88.8::'w'::HNil, HNil))
  }


}
