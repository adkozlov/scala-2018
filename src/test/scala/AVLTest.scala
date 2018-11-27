import org.scalatest.FunSuite
import ru.spbau.jvm.scala.avltree.{AvlNil, AvlNode, AvlTree}

import scala.util.Random

class AVLTest extends FunSuite {

  test("height test") {
    assert(AvlNode(3, AvlNode(2, AvlNode(1, AvlNil, AvlNil), AvlNil), AvlNode(1, AvlNil, AvlNil)).height == 3)
  }

  test("balance test") {
    assert(!AvlNode(3, AvlNode(2, AvlNode(1, AvlNil, AvlNil), AvlNil), AvlNil).balanced())
  }


  test("simple left rotation test") {
    assert(AvlTree.rotate(AvlNode(1, AvlNode(2, AvlNil, AvlNil), AvlNode(3, AvlNode(4, AvlNil, AvlNil), AvlNode(5, AvlNil, AvlNode(6, AvlNil, AvlNil)))))
      == AvlNode(3, AvlNode(1, AvlNode(2, AvlNil, AvlNil), AvlNode(4, AvlNil, AvlNil)), AvlNode(5, AvlNil, AvlNode(6, AvlNil, AvlNil))))
  }

  test("simple right rotation test") {
    assert(AvlTree.rotate(AvlNode(1, AvlNode(2, AvlNode(3, AvlNode(5, AvlNil, AvlNil), AvlNode(7, AvlNil, AvlNil)), AvlNode(4, AvlNil, AvlNil)), AvlNode(6, AvlNil, AvlNil)))
      == AvlNode(2, AvlNode(3, AvlNode(5, AvlNil, AvlNil), AvlNode(7, AvlNil, AvlNil)), AvlNode(1, AvlNode(4, AvlNil, AvlNil), AvlNode(6, AvlNil, AvlNil))))
  }

  test("double left rotation test") {
    assert(AvlTree.rotate(AvlNode(1, AvlNil, AvlNode(2, AvlNode(4, AvlNode(5, AvlNil, AvlNil), AvlNil), AvlNode(3, AvlNil, AvlNil))))
      == AvlNode(4, AvlNode(1, AvlNil, AvlNode(5, AvlNil, AvlNil)), AvlNode(2, AvlNil, AvlNode(3, AvlNil, AvlNil))))
  }

  test("double right rotation test") {
    assert(AvlTree.rotate(AvlNode(1, AvlNode(2, AvlNode(3, AvlNil, AvlNil), AvlNode(4, AvlNode(5, AvlNil, AvlNil), AvlNil)), AvlNil))
      == AvlNode(4, AvlNode(2, AvlNode(3, AvlNil, AvlNil), AvlNode(5, AvlNil, AvlNil)), AvlNode(1, AvlNil, AvlNil)))
  }

  test("test fold left") {
    assert(AvlTree.foldl[Int, Int]((x, y) => x + y, 0, AvlTree(1, 2, 3, 4, 5, 6, 7)) == 28)
  }

  test("simple insert test") {
    assert(AvlTree(1, 2, 3, 4, 5, 6, 7) == AvlNode(4, AvlNode(2, AvlNode(1, AvlNil, AvlNil), AvlNode(3, AvlNil, AvlNil)), AvlNode(6, AvlNode(5, AvlNil, AvlNil), AvlNode(7, AvlNil, AvlNil))))
  }

  test("complex insert test") {
    assert(nodeFoldl[Int]((ini, node) => ini && node.balanced(), true, AvlTree(Random.shuffle((1 to 1000).toList).toArray: _*)))
  }

  test("contains test") {
    assert(AvlTree.contains(3, AvlTree(1, 2, 3, 4, 5, 6, 7)))
    assert(!AvlTree.contains(3, AvlTree(1, 2, 4, 5, 6, 7)))
  }

  test("min test") {
    assert(AvlTree(1, 2, 3, 4, 5, 6, 7).min() == 1)
  }

  test("max test") {
    assert(AvlTree(1, 2, 3, 4, 5, 6, 7).max() == 7)
  }

  test("remove min test ") {
    assert(AvlTree.removeMin(AvlTree(1, 2, 3, 4, 5, 6, 7)) == AvlNode(4, AvlNode(2, AvlNil, AvlNode(3, AvlNil, AvlNil)), AvlNode(6, AvlNode(5, AvlNil, AvlNil), AvlNode(7, AvlNil, AvlNil))))
  }

  test("simple remove test") {
    assert(AvlTree.remove(5, AvlTree.remove(6, AvlTree(1, 2, 3, 4, 5, 6)))
      == AvlNode(2, AvlNode(1, AvlNil, AvlNil), AvlNode(4, AvlNode(3, AvlNil, AvlNil), AvlNil)))
  }

  test("complex remove test") {
    var tree = AvlTree(Random.shuffle((1 to 1000).toList).toArray: _*)
    val removeValues = Random.shuffle((1 to 500).toList).toArray
    for (value <- removeValues) {
      tree = AvlTree.remove(value, tree)
    }
    assert(nodeFoldl[Int]((ini, node) => ini && node.balanced(), true, tree))
  }

  test("foreach test") {
    var x = 0
    val f = (v: Int) => x = x + v
    AvlTree(1, 2, 3, 4, 5, 6, 7).foreach(f)
    assert(x == 28)
  }

  test("for comprehension test") {
    val tree = AvlTree(5, 7, 2, 1, 6, 3, 4)
    var expected = 1
    for (symb <- tree) {
      assert(symb == expected)
      expected += 1
    }
  }

  test("map test") {
    val tree = AvlTree(1, 2, 3, 4, 5, 6, 7)
    val actual = for (n <- tree) yield n.toString
    assert(actual == AvlTree("1", "2", "3", "4", "5", "6", "7"))
  }

  test("flatMap test") {
    val tree1 = AvlTree(1, 2)
    val tree2 = AvlTree(1, 2, 3)

    val result = for {
      x <- tree1
      y <- tree2
    } yield x * y
    assert(nodeFoldl[Int]((ini, node) => ini && node.balanced(), true, result))
    assert(AvlTree.foldl[Int, Int]((x, y) => x + y, 0, result) == 18)
  }

  def nodeFoldl[A](f: (Boolean, AvlTree[A]) => Boolean, ini: Boolean, tree: AvlTree[A]): Boolean = tree match {
    case AvlNil => true
    case node@AvlNode(v, l, r) => val lres = nodeFoldl(f, f(ini, node), l)
      nodeFoldl(f, lres, r)
  }
}
