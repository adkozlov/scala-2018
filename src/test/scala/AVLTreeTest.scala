import org.scalatest.FlatSpec

import scala.collection.mutable.ListBuffer

class AVLTreeTest extends FlatSpec {
  "An empty AVLTree" should "have size 0" in {
    assert(new AVLTree[Int].size == 0)
  }

  "A zero size AVLTree" should "be empty" in {
    assert(new AVLTree[Int].isEmpty)
    assert(!new AVLTree[Int].nonEmpty)
  }

  "AVLTree" should "be non-empty after add" in {
    val tree = new AVLTree[Int]
    tree.add(5)
    assert(!tree.isEmpty)
    assert(tree.nonEmpty)
  }

  it should "have correct size after adds" in {
    val tree = new AVLTree[Int]
    tree.add(5)
    assert(tree.size == 1)
    tree.add(1)
    tree.add(2)
    assert(tree.size == 3)
  }

  it should "contain added element" in {
    val tree = new AVLTree[Int]
    tree.add(5)
    assert(tree.contains(5))
  }

  it should "not contain not added element" in {
    val tree = new AVLTree[Int]
    tree.add(5)
    assert(!tree.contains(4))
  }

  it should "be able to contain multiple copies of the same element" in {
    val tree = new AVLTree[Int]
    tree.add(5)
    tree.add(5)
    assert(tree.contains(5))
    assert(tree.size == 2)
  }

  "A cleared AVLTree" should "be empty" in {
    val tree = new AVLTree[Int]
    tree.add(42342)
    tree.add(-214)
    tree.clear()
    assert(tree.isEmpty)
  }

  it should "not contain elements" in {
    val tree = new AVLTree[Int]
    tree.add(42342)
    tree.add(-214)
    tree.clear()
    assert(!tree.contains(42342))
    assert(!tree.contains(-214))
    assert(!tree.contains(0))
  }

  "AVLTree" should "have non-negative size after remove" in {
    val tree = new AVLTree[Int]
    tree.remove(-5)
    assert(tree.size == 0)
  }

  it should "not remove not existing element" in {
    val tree = new AVLTree[Int]
    tree.add(5)
    tree.remove(-1)
    assert(tree.size == 1)
  }

  it should "be able to remove added element" in {
    val tree = new AVLTree[Int]
    tree.add(5)
    tree.remove(5)
    assert(tree.size == 0)
  }

  it should "remove only one copy of an element" in {
    val tree = new AVLTree[Int]
    tree.add(5)
    tree.add(5)
    tree.remove(5)
    assert(tree.contains(5))
    assert(tree.size == 1)
  }

  it should "be iterable in sorted order using for comprehension" in {
    val tree = new AVLTree[String]()(Ordering.by[String, Int](_.length))

    tree.addAll("max value", "min", "mean2", "mean")

    var foreach = new ListBuffer[String]
    for (element <- tree) {
      foreach += element
    }
    assert(foreach.toList == List("min", "mean", "mean2", "max value"))
  }

  it should "be iterable in sorted order using for comprehension with a condition" in {
    val tree = new AVLTree[String]()(Ordering.by[String, Int](_.length))
    tree.add("max value")
    tree.add("min")
    tree.add("mean2")
    tree.add("mean")
    var foreach = new ListBuffer[String]
    for (e: String <- tree if e.length == 4 || e.length == 5) {
      foreach += e
    }
    assert(foreach.toList == List("mean", "mean2"))
  }

  "Yield" should "build correct tree" in {
    val tree = fromList(List("azqwe", "xanm", "bcfgre", "xzdc"))
    val mapped = for (e: String <- tree) yield {
      e.codePointAt(1)
    }
    assert(toList(mapped) == List(97, 99, 122, 122))
  }

  "AVLTree" should "print foreach correctly" in {
    val tree = new AVLTree[Int]
    tree.addAll(3, 4, 1, 2)
    tree.add(6)
    tree.add(0)
    tree.add(5)
    tree.addAll(7, 8)

    var counter = 0
    tree.foreach(i => {
      assert(counter == i)
      counter += 1
    })
  }

  "AVLTree" should "have correct min / max values" in {
    val tree = new AVLTree[Int]
    tree.addAll(3, 4, 1, 2)
    tree.add(6)
    tree.add(0)
    tree.add(5)
    tree.addAll(7, 8)

    assert(tree.minOrDefault(9) == 0)
    assert(tree.maxOrDefault(9) == 8)

    val emptyTree = new AVLTree[Int]

    assert(emptyTree.minOrDefault(9) == 9)
    assert(emptyTree.maxOrDefault(9) == 9)
  }

  "AVLTree" should "work exists method" in {
    val tree = new AVLTree[Int]
    tree.addAll(3, 4, 1, 2)
    tree.add(6)
    tree.add(0)
    tree.add(5)
    tree.addAll(7, 8)

    assert(tree.exists(4 == _))
    assert(!tree.exists(14 == _))
  }

  "AVLTree" should "work forall method" in {
    val tree = new AVLTree[Int]
    tree.addAll(3, 4, 1, 2)
    tree.add(6)
    tree.add(0)
    tree.add(5)
    tree.addAll(7, 8)

    assert(tree.forall(i => (0 <= i) && (i <= 8)))
    assert(!tree.forall(_ == 1))
  }

  "AVLTree" should "build correct tree using map" in {
    val tree = fromList(List("azqwe", "xanm", "bcfgre", "xzdc"))
    val mapped = tree.map(_.codePointAt(1))
    assert(toList(mapped) == List(97, 99, 122, 122))
  }

  it should "not be modified by map" in {
    val tree = fromList(List("az", "xa", "bc", "xz"))
    tree.map(_.codePointAt(0))
    assert(toList(tree) == List("az", "bc", "xa", "xz"))
  }

  it should "build correct tree using flatMap" in {
    val tree = fromList(List("az", "xa", "bc"))
    val mapped = tree.flatMap[Char]((s: String) => fromList(s.seq.toList))
    assert(toList(mapped) == List('a', 'a', 'b', 'c', 'x', 'z'))
  }

  it should "not be modified by flatMap" in {
    val tree = fromList(List("b", "tr", "aa"))
    tree.flatMap[Char]((s: String) => fromList(s.seq.toList))
    assert(toList(tree) == List("aa", "b", "tr"))
  }

  it should "build correct tree using filter" in {
    val tree = fromList(List(0, -100, 55, -1011))
    val filtered = tree.filter((n: Int) => n % 2 == 0)
    assert(toList(filtered) == List(-100, 0))
  }

  it should "not be modified by filter" in {
    val tree = fromList(List(0, -100, 5, -101))
    tree.filter((n: Int) => n < 0)
    assert(toList(tree) == List(-101, -100, 0, 5))
  }

  it should "have the same hashcode with identical tree" in {
    val tree1 = fromList(List(0, -100, 5, -101))
    val tree2 = fromList(List(-100, -101, 0, 5))
    assert(tree1.hashCode() == tree2.hashCode())
  }

  it should "be equal to identical tree" in {
    val tree1 = fromList(List("s", "a", "v", "e"))
    val tree2 = fromList(List("e", "a", "s", "v"))
    assert(tree1 == tree2)
  }

  it should "not be equal to not identical tree" in {
    val tree1 = fromList(List("s", "a", "v", "e"))
    val tree2 = fromList(List("e", "q", "s", "v"))
    assert(!(tree1 == tree2))
  }

  it should "not be equal to tree with identical set of elements but different size" in {
    val tree1 = fromList(List(1, 2, 3, 4, 5))
    val tree2 = fromList(List(1, 1, 2, 3, 4, 5))
    assert(!(tree1 == tree2))
  }

  it should "not be equal to object of another class" in {
    val tree1 = fromList(List(1, 2, 3, 4, 5))
    val list = List(1, 2, 3, 4, 5)
    //noinspection ComparingUnrelatedTypes
    assert(!(tree1 == list))
  }

  it should "remove collection of elements correctly" in {
    val tree = fromList(List(1.0, -2.1, -23, 43.03, 5))
    val toRemove = fromList(List(5, -2.1, -1))
    tree.removeAll(toRemove)
    assert(toList(tree) == List(-23, 1.0, 43.03))
  }

  it should "add collection of elements correctly" in {
    val tree = fromList(List('a', 'e'))
    val toAdd = fromList(List('a', 'q'))
    tree.addAll(toAdd)
    assert(toList(tree) == List('a', 'a', 'e', 'q'))
  }

  it should "contain all elements from collection with added elements" in {
    val tree = fromList(List('a', 'e', 'z'))
    val added = fromList(List('a', 'z'))
    assert(tree.containsAll(added))
  }

  it should "not contain all elements from collection that has unique element" in {
    val tree = fromList(List('a', 'e', 'z'))
    val unique = fromList(List('a', 'e', 'x'))
    assert(!tree.containsAll(unique))
  }

  private def fromList[A](list: List[A])(implicit ordering: Ordering[A]): AVLTree[A] = {
    val tree = new AVLTree[A]()(ordering)
    list.foreach(tree.add)
    tree
  }

  private def toList[A](tree: AVLTree[A]): List[A] = {
    var result = new ListBuffer[A]
    tree.foreach(elem => result += elem)
    result.toList
  }
}
