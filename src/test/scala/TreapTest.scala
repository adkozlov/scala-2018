import org.scalatest._

class TreapTest extends FlatSpec with Matchers {
  "An empty treap" should "be created successfully" in {
    val treap = new Treap[Int]()
    treap.size() should be (0)
  }

  "Add" should "add one element" in {
    val treap = new Treap[Int]()
    treap.add(0)
    treap.size() should be (1)
    treap.count(0) should be (1)
  }

  "Add" should "add element twice" in {
    val treap = new Treap[Int]()
    treap.addAll(5, 5)
    treap.size() should be (2)
    treap.count(5) should be (2)
  }

  "Add" should "add two different elements" in {
    val treap = new Treap[Int]()
    treap.addAll(1, 2)
    treap.size() should be (2)
    treap.count(1) should be (1)
    treap.count(2) should be (1)
  }

  "Add" should "add three elements" in {
    val treap = new Treap[Int]()
    treap.addAll(1, 2, 3)
    treap.size() should be (3)
    treap.count(1) should be (1)
    treap.count(2) should be (1)
    treap.count(3) should be (1)
  }

  "Delete" should "ignore attempt to remove not existing element" in {
    val treap = new Treap[Int]()
    treap.add(1)
    treap.delete(5)
    treap.size() should be (1)
    treap.count(1) should be (1)
  }

  "Delete" should "remove the only element" in {
    val treap = new Treap[Int]()
    treap.add(1)
    treap.delete(1)
    treap.size() should be (0)
    treap.count(1) should be (0)
  }

  "Delete" should "remove one of the elements" in {
    val treap = new Treap[Int]()
    treap.addAll(1, 2, 4, 10)
    treap.delete(4)
    treap.size() should be (3)
    treap.count(1) should be (1)
    treap.count(2) should be (1)
    treap.count(4) should be (0)
    treap.count(10) should be (1)
  }

  "Delete" should "decrease counter for repeating element" in {
    val treap = new Treap[Int]()
    treap.addAll(1, 2, 4, 1, 10)
    treap.delete(1)
    treap.size() should be (4)
    treap.count(1) should be (1)
    treap.count(2) should be (1)
    treap.count(4) should be (1)
    treap.count(10) should be (1)
  }

  "Add" should "add many elements" in {
    val treap = new Treap[Int]()
    for (i <- -1000 to 1000)
      treap.add(i)
    treap.size() should be (2001)
    for (i <- -1000 to 1000)
      treap.count(i) should be (1)
  }

  "Delete" should "remove many elements" in {
    val treap = new Treap[Int]()
    for (i <- -1000 to 1000)
      treap.add(i)
    for (i <- -1000 to 1000)
      treap.delete(i)
    treap.size() should be (0)
    for (i <- -1000 to 1000)
      treap.contains(i) should be (false)
  }

  "Map" should "create new treap with mapped values" in {
    val treap = new Treap[Int]()
    treap.addAll(7, 1, 2, 5, -4)
    var newTreap = treap.map({ i => if (i >= 0) 1 else -1 })
    newTreap.size() should be (5)
    newTreap.count(1) should be (4)
    newTreap.count(-1) should be (1)
  }

  "FlatMap" should "create new treap with flatMapped values" in {
    val treap = new Treap[Int]()
    treap.addAll(1, 2)
    var newTreap = treap.flatMap({
      i =>
        val t = new Treap[Int]()
        t.addAll(i, i + 1)
        t
    })
    newTreap.size() should be (4)
    newTreap.count(1) should be (1)
    newTreap.count(2) should be (2)
    newTreap.count(3) should be (1)
  }

  "For-comprehension" should "iterate through treap" in {
    val treap = new Treap[Int]()
    treap.addAll(0, -1, -2)
    var inversedElements: List[Int] = Nil
    for (i <- treap){
      inversedElements = Tail(i, inversedElements)
    }
    inversedElements should be (Tail(0, Tail(-1, Tail(-2, Nil))))
  }

  "For-comprehension" should "create new treap with yield" in {
    val treap = new Treap[Int]()
    treap.addAll(0, -1, -2)
    var newTreap = for (i <- treap) yield i * 3
    newTreap.toList should be (Tail(-6, Tail(-3, Tail(0, Nil))))
  }
}