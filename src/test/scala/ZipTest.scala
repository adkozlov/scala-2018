import org.scalatest.{FlatSpec, Matchers}

class ZipTest extends FlatSpec with Matchers {

  import HList._

  private val listOne = 3 :: "a" :: HNil
  private val listTwo = 5 :: "b" :: HNil
  private val biggerList = 3 :: "a" :: 88.8 :: HNil
  private val resOne = (3, 5) :: ("a", "b") :: HNil
  private val resTwo = (5, 3) :: ("b", "a") :: HNil


  "Zip" should "return HNil if zip with HNil" in {
    val empty = HNil
    assert(biggerList.zip(empty) === HNil)
    assert(empty.zip(biggerList) === HNil)
    assert(empty.zip(empty) === HNil)
  }

  "Zip" should "zip lists with equal length" in {

    assert(listTwo.zip(listOne) === resOne)
    assert(listOne.zip(listTwo) === resTwo)
  }

  "Zip" should "zip lists with different length" in {

    assert(listTwo.zip(biggerList) === resOne)
    assert(biggerList.zip(listTwo) === resTwo)
  }


}
