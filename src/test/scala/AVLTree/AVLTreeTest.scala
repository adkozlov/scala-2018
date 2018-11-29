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

  "AVLTree" should "have correct order after adding elements" in {
    var tree: AVLTree[Int] = AVLLeaf
    val numbers = (1 to 5).toList
    for (i <- numbers) {
      tree = AVLTree.add(i, tree)
      assert(tree.isBalanced)
    }

    assert(tree.size == 5)
    assert(tree.isBalanced)
    val correctTree: AVLTree[Int] = AVLNode(
      AVLNode(AVLLeaf, 1, AVLLeaf),
      2,
      AVLNode(
        AVLNode(AVLLeaf, 3, AVLLeaf),
        4,
        AVLNode(AVLLeaf, 5, AVLLeaf)
      )
    )

    assert(tree === correctTree)
  }

  "AVLTree" should "have correct size and be balanced after adding elements" in {
    var tree: AVLTree[Int] = AVLLeaf
    val numbers = Random.shuffle((1 to n).toList)
    for (i <- numbers) {
      tree = AVLTree.add(i, tree)
      assert(tree.isBalanced)
    }

    assert(tree.size == n)
    assert(tree.isBalanced)
  }

  "AVLTree" should "contain elements after adding" in {
    var tree: AVLTree[Int] = AVLLeaf
    val numbers = Random.shuffle((1 to n).toList)
    for (i <- numbers) {
      tree = AVLTree.add(i, tree)
      assert(tree.isBalanced)
    }

    for (i <- numbers) {
      assert(AVLTree.contains(i, tree))
    }

    assert(tree.size == n)
    assert(tree.isBalanced)
  }

  "AVLTree" should "have correct size and be balanced after removing elements" in {
    var tree: AVLTree[Int] = AVLLeaf
    val numbers = Random.shuffle((1 to n).toList)

    for (i <- 1 to n) {
      tree = AVLTree.remove(i, tree)
      assert(tree.isBalanced)
    }

    assert(tree.size == 0)
  }

  "AVLTree" should "have correct map execution" in {
    var tree: AVLTree[Int] = AVLNode(
      AVLNode(AVLLeaf, 1, AVLLeaf),
      2,
      AVLNode(
        AVLNode(AVLLeaf, 3, AVLLeaf),
        4,
        AVLNode(AVLLeaf, 5, AVLLeaf)
      )
    )

    tree = tree.map(i => i * 2)

    val correctTree: AVLTree[Int] = AVLNode(
      AVLNode(AVLLeaf, 2, AVLLeaf),
      4,
      AVLNode(
        AVLNode(AVLLeaf, 6, AVLLeaf),
        8,
        AVLNode(AVLLeaf, 10, AVLLeaf)
      )
    )

    assert(tree === correctTree)
  }

  "AVLTree" should "have correct flatMap execution" in {
    var tree: AVLTree[Int] =
      AVLNode(
        AVLNode(AVLLeaf, 1, AVLLeaf),
        2,
        AVLNode(
          AVLNode(AVLLeaf, 3, AVLLeaf),
          4,
          AVLNode(AVLLeaf, 5, AVLLeaf)
        )
      )

    tree = tree.flatMap(i => AVLNode(AVLLeaf, i * i, AVLNode(AVLLeaf, i - 1, AVLLeaf)))

    val correctTree: AVLTree[Int] =
      AVLNode(
        AVLNode(
          AVLLeaf,
          0,
          AVLNode(
            AVLLeaf,
            1,
            AVLLeaf
          )
        ),
        1,
        AVLNode(
          AVLNode(
            AVLNode(AVLLeaf, 2, AVLLeaf),
            3,
            AVLNode(AVLLeaf, 4, AVLLeaf)
          ),
          4,
          AVLNode(
            AVLNode(AVLLeaf, 9, AVLLeaf),
            16,
            AVLNode(AVLLeaf, 25, AVLLeaf)
          )
        )
      )

    assert(tree === correctTree)
  }

}
