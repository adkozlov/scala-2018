package heterogeneous

import org.scalatest.{FlatSpec, Matchers}
import nat._

class TestList extends FlatSpec with Matchers {

  type One = Succ[Zero]
  type Two = Succ[One]
  type Three = Succ[Two]
  type Four = Succ[Three]
  type Five = Succ[Four]
  type Six = Succ[Five]

  "List" should "contains different types" in {
    val list = 1 :: false :: -12 :: Some(17) :: "kek" :: Nil
    assert(list.head === 1)
    assert(list.tail.head === false)
    assert(list.tail.tail.tail.tail.head === "kek")
  }


  "Index" should "return correct element" in {
    val list : HList = 1 :: false :: -12 :: Some(17) :: "kek" :: HNil
//    assert(list.apply[Zero] === 1)
//    assert(list.apply[One] === false)
//    assert(list.apply[Four] === "kek")
  }

}
