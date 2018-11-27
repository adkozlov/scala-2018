import org.scalatest.{FlatSpec, Matchers}

class RBTreeSetTest extends FlatSpec with Matchers {

  private def fromArrayToSet(array: Array[Int]) : RBTreeSet[Int] ={
    var set = new RBTreeSet[Int]()
    for (a <- array) {
      set = set.add(a)
    }
    set
  }

  "RBTreeSet" should "add elements" in {
    var set = new RBTreeSet[Int]()
    assert(set.size == 0)
    set = set.add(1)
    assert(set.size == 1)
    assert(set.contains(1))
    set = set.add(5)
    set = set.add(3)
    assert(set.size == 3)
    assert(set.contains(5))
    assert(set.contains(3))
    set = set.add(4)
    assert(set.size == 4)
    assert(set.contains(4))
    set = set.add(8)
    assert(set.size == 5)
    assert(set.contains(8))
    set = set.add(8)
    assert(set.size == 5)
    assert(set.toCustomList.listToString == "1 3 4 5 8 ")
  }

  "RBTreeSet" should "remove elements" in {
    var set = new RBTreeSet[Int]()
    assert(set.size == 0)
    set = set.add(1)
    assert(set.contains(1))
    set = set.remove(5)
    set = set.remove(1)
    assert(!set.contains(1))
    assert(set.size == 0)
    set = set.add(6)
    set = set.add(4)
    set = set.add(12)
    set = set.add(5)
    set = set.add(16)
    set = set.add(2)
    set = set.add(18)
    set = set.add(7)
    assert(set.size == 8)
    set = set.remove(6)
    assert(set.size == 7)
    assert(!set.contains(6))
    assert(set.toCustomList.listToString == "2 4 5 7 12 16 18 ")
    set = set.remove(16)
    assert(set.size == 6)
    assert(set.toCustomList.listToString == "2 4 5 7 12 18 ")
  }

  "RBTreeSet" should "add all elements from another set" in {
    val numbersOne = Array(1, 3, 5, 7, 11)
    val numbersTwo = Array(2, 4, 6, 8, 10, 11)
    val setA = fromArrayToSet(numbersOne)
    val setB = fromArrayToSet(numbersTwo)
    val set = setA.addAll(setB)
    assert(set.size == 10)
    assert(set.toCustomList.listToString == "1 2 3 4 5 6 7 8 10 11 ")
  }

  "RBTreeSet" should "remove all elements from another set" in {
    val numbersOne = Array(3, 6, 9)
    val numbersTwo = Array(1, 4, 2, 3, 5, 6, 8, 7, 9)
    val setA = fromArrayToSet(numbersOne)
    val setB = fromArrayToSet(numbersTwo)
    val set = setB.removeAll(setA)
    assert(set.size == 6)
    assert(set.toCustomList.listToString == "1 2 4 5 7 8 ")
    val setTwo = setA.removeAll(setB)
    assert(setTwo.size == 0)
  }

  "RBTreeSet" should "contain all elements from another set" in {
    val numbersOne = Array(3, 6, 9)
    val numbersTwo = Array(1, 4, 2, 3, 5, 6, 8, 7, 9)
    val numbersThree = Array(3, 6, 4)
    val setA = fromArrayToSet(numbersOne)
    val setB = fromArrayToSet(numbersTwo)
    val setC = fromArrayToSet(numbersThree)
    assert(setB.containsAll(setA))
    assert(!setA.containsAll(setC))
  }

  "RBTreeSet" should "clear properly" in {
    val numbers = Array(3, 6, 9)
    val setA = fromArrayToSet(numbers)
    assert(setA.clear.size == 0)
  }


  "RBTreeSet" should "support for-comprehension" in {
    val numbers = Array(2, 4, 5, 6, 1, 3, 7)
    var set = fromArrayToSet(numbers)
    var sum = 0
    set.foreach(x => sum += x)
    assert(sum == 28)
    set = set.flatMap(x => x*x)
    assert(set.toCustomList.listToString == "1 4 9 16 25 36 49 ")
  }

}
