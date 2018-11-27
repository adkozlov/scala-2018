package ru.hse.spb.bst

import org.scalatest.{FlatSpec, Matchers}

class RBTNodeTest extends FlatSpec with Matchers {
  var node: Option[RBTNode[Integer]] = None
  var nodeCheck: Option[RBTNode[Integer]] = None
  var nodeTree = RedBlackTree[Integer]()

  def checkStructure(rootFirst: Option[RBTNode[Integer]], rootSecond: Option[RBTNode[Integer]]): Boolean = {
    if (rootFirst.isEmpty)
      return rootFirst == rootSecond
    if (rootFirst.get.value != rootSecond.map(_.value).get || rootFirst.get.isBlack != rootSecond.map(_.isBlack).get) {
      false
    } else {
      checkStructure(rootFirst.get.left, rootSecond.get.left) && checkStructure(rootFirst.get.right, rootSecond.get.right)
    }
  }

  "RotationLeft" should "return true" in {
    node = Some(RBTNode(1, None))
    nodeCheck = Some(RBTNode(1, None))
    node.get.rotateLeft()
    assert(checkStructure(node, nodeCheck))
  }

  "RotationRight" should "return true" in {
    node = Some(RBTNode(1, None))
    nodeCheck = Some(RBTNode(1, None))
    node.get.rotateRight()
    assert(checkStructure(node, nodeCheck))
  }

  "RotationLeftLeaf" should "return true" in {
    node = Some(RBTNode(1, None, true))
    node.get.left = Some(RBTNode(-1, node))
    nodeCheck = Some(RBTNode(1, None, true))
    nodeCheck.get.left = Some(RBTNode(-1, node))
    node.get.left.get.rotateLeft()
    assert(checkStructure(node, nodeCheck))
  }

  "RotationRightLeaf" should "return true" in {
    node = Some(RBTNode(1, None, true))
    node.get.left = Some(RBTNode(-1, node))
    nodeCheck = Some(RBTNode(1, None, true))
    nodeCheck.get.left = Some(RBTNode(-1, node))
    node.get.left.get.rotateRight()
    assert(checkStructure(node, nodeCheck))
  }

  "RotationInTree" should "return true" in {
    for (i <- 1 to 100){
      nodeTree.insert(i)
    }

    node = nodeTree.root.get.right
    nodeTree.root.get.rotateLeft()
    assert(nodeTree.root.get.parent == node)
    assert(nodeTree.root == node.get.left)
  }



}
