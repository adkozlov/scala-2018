package AVLTree

import org.scalatest.{FlatSpec, Matchers}

import scala.util.Random

class AVLTreeTest extends FlatSpec with Matchers {

  val n = 517

  "AVLLeaf" should "have correct size and height" in {
    assert(AVLLeaf.size === 0)
    assert(AVLLeaf.height === 0)
  }

  "AVLTree" should "have correct size and height" in {
    val tree: AVLTree[Int] = AVLNode(
      AVLNode(AVLLeaf, 0, AVLNode(AVLLeaf, 0, AVLLeaf)),
      0,
      AVLNode(AVLLeaf, 0, AVLLeaf)
    )
    assert(tree.size === 4)
    assert(tree.height === 3)
  }

  "AVLTree" should "have correct size and be balanced after adding elements" in {
    var tree: AVLTree[Int] = buildTree()

    assert(tree.size == n)
    assert(tree.isBalanced)
  }

  "AVLTree" should "contain elements after adding" in {
    var tree: AVLTree[Int] = buildTree(true)

    for (i <- 1 to n) {
      assert(AVLTree.contains(i, tree))
    }
  }

  "AVLIterator" should "work fine" in {
    val tree: AVLTree[Int] = AVLNode(
      AVLNode(AVLLeaf, 1, AVLLeaf),
      2,
      AVLNode(
        AVLNode(AVLLeaf, 3, AVLLeaf),
        4,
        AVLNode(AVLLeaf, 5, AVLLeaf)
      )
    )

    val it: AVLIterator[Int] = tree.iterator
    for (i <- 1 to 5) {
      assert(it.hasNext)
      assert(it.next() === i)
    }
    assert(!it.hasNext)
    assertThrows[NoSuchElementException](it.next())
  }

  "AVLTree" should "have correct order after adding elements" in {
    var tree: AVLTree[Int] = buildTree(true)

    checkTreeContent(tree, (1 to n).toList)
  }

  "AVLTree" should "have correct size and be balanced after removing elements" in {
    var tree: AVLTree[Int] = buildTree(true)

    for (i <- 1 to n) {
      tree = AVLTree.remove(i, tree)
      assert(tree.isBalanced)
      assert(!AVLTree.contains(i, tree))
    }

    assert(tree.size == 0)
  }

  "AVLTree" should "have correct map execution" in {
    var tree: AVLTree[Int] = buildTree()

    tree = tree.map(i => i * 2)

    checkTreeContent(tree, (1 to n).map { i => i * 2 }.toList)
  }

  "AVLTree" should "have correct flatMap execution" in {
    var tree: AVLTree[Int] = buildTree()
    tree = tree.flatMap(i => AVLNode(AVLLeaf, i * 2, AVLNode(AVLLeaf, i - 1, AVLLeaf)))
    val correctContent : List[Int] = (1 to n).map { i => i * 2 }.toList ::: (1 to n).map { i => i - 1 }.toList
    checkTreeContent(tree, correctContent)
  }

  private def buildTree(shuffle: Boolean = false): AVLTree[Int] = {
    var tree: AVLTree[Int] = AVLLeaf
    var numbers = (1 to n).toList
    if (shuffle) {
      numbers = Random.shuffle(numbers)
    }
    for (i <- numbers) {
      tree = AVLTree.add(i, tree)
      assert(tree.isBalanced)
    }
    tree
  }

  private def checkTreeContent(tree: AVLTree[Int], content: List[Int]): Unit = {
    val it: AVLIterator[Int] = tree.iterator
    assert(tree.size == content.length)
    for (i <- content.sorted) {
      assert(it.hasNext)
      assert(it.next() === i)
    }
    assert(!it.hasNext)
  }
}
