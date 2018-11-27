package ru.hse.spb.bst

case class RBTNode[K <: Comparable[K]](var value: K,
                                       var parent: Option[RBTNode[K]] = None,
                                       var isBlack: Boolean = false) {
  var left: Option[RBTNode[K]] = None
  var right: Option[RBTNode[K]] = None

  def ifLeaf(): Boolean = (this.left == null) && (this.right == null)

  def brother(): Option[RBTNode[K]] = {
    if (this.parent == None) {
      None
    }

    if (this == this.parent.get.left.getOrElse(None)) {
      this.parent.get.right.map(i => i)
    } else {
      this.parent.get.left.map(i => i)
    }
  }

  def rotateLeft(): Unit = {
    if (this.right.isEmpty) {
      return
    }
    val rightChild = this.right
    val father = this.parent

    this.swapColors(rightChild)
    rightChild.map(i => i).get.left.map(i => i).get.parent = Some(this)
    this.right = rightChild.get.left
    rightChild.get.left = Some(this)

    if (father.isDefined) {
      if (this == father.get.left.getOrElse(None)) {
        father.get.left = rightChild
      } else if (this == father.get.right.getOrElse(None)) {
        father.get.right = rightChild
      }
    }

    this.parent = rightChild
    rightChild.map(i => i).get.parent = father

  }

  def rotateRight(): Unit = {
    if (this.left.isEmpty) {
      return
    }
    val leftChild = this.right.map(i => i)
    val father = this.parent

    this.swapColors(leftChild)
    leftChild.get.right.get.parent = Some(this)
    this.left = leftChild.get.left
    leftChild.get.left = Some(this)

    if (father.isDefined) {
      if (this == father.get.left.getOrElse(None)) {
        father.get.left = leftChild
      } else if (this == father.get.right.getOrElse(None)) {
        father.get.right = leftChild
      }
    }

    this.parent = leftChild
    leftChild.get.parent = father
  }

  private def swapColors(other: Option[RBTNode[K]]): Unit = {
    val color1 = this.isBlack

    if (other.isDefined) {
      this.isBlack = other.get.isBlack
      other.get.isBlack = color1
    }
  }
}