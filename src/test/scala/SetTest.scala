import homework.scala.set.{Leaf, Node, Tree, Set}
import org.junit.Test

class SetTest {
  @Test
  def createEmptySet(): Unit = {
    val treeInt = Set.apply[Int]()
    val treeString = Set.apply[String]()

    assert(treeInt.isInstanceOf[Tree[Int]])
    assert(treeString.isInstanceOf[Tree[String]])
  }

  @Test
  def createSet(): Unit = {
    val tree = Set.apply(1,2,3,4,5,6)
    val expectedTree = Node(4, Node(2, Node(1, Leaf(), Leaf()), Node(3, Leaf(), Leaf())), Node(5, Leaf(), Node(6, Leaf(), Leaf())))
    assert(tree.equals(expectedTree))
  }

  @Test
  def containsElements(): Unit = {
    val tree = Set.apply(1,2,3,4,5,6,7,8,9,10)
    assert(tree.contains(1))
    assert(tree.contains(4))
    assert(tree.contains(7))
    assert(tree.contains(10))
  }

  @Test
  def andSets(): Unit = {
    val tree1 = Set.apply(1,2,3,4)
    val tree2 = Set.apply(3,4,5,6)
    val tree3 = tree1 & tree2
    assert(tree3.contains(3))
    assert(tree3.contains(4))
    assert(!tree3.contains(5))
  }

  @Test
  def orSets(): Unit = {
    val tree1 = Set.apply(1,2,3,4)
    val tree2 = Set.apply(3,4,5,6)
    val tree3 = tree1 | tree2
    assert(tree3.contains(3))
    assert(tree3.contains(4))
    assert(tree3.contains(5))
    assert(tree3.contains(1))
    assert(tree3.contains(2))
    assert(!tree3.contains(10))
    assert(tree3.size == 6)
  }
}
