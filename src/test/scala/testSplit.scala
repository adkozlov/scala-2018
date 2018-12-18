import HList.{HNil => nil}
import Nat.{Suc, Zero}
import org.scalatest.FunSuite

class testSplit extends FunSuite {
  private val l1 = 1 :: "hello" :: 1.5 :: nil
  private val l2 = 2 :: "world" :: 3.7 :: nil


  test("split works well") {
    assert(l1.split(Zero) == (nil, l1))
    assert(l1.split(Suc(Zero)) == (1 :: nil, "hello" :: 1.5 :: nil))
  }
}
