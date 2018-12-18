import org.scalatest.FunSuite
import HList.{HNil => nil}

class testZip extends FunSuite {
  private val l1 = 1 :: "hello" :: 1.5 :: nil
  private val l2 = 2 :: "world" :: 3.7 :: nil


  test("zip works with nil") {
    assert(l1.zip(nil) == nil)
    assert(nil.zip(l1) == nil)
  }

  test("zip truncates lists") {
    assert(l1.zip(l2.tail) == ((1, "world") :: ("hello", 3.7) :: nil))
  }
}
