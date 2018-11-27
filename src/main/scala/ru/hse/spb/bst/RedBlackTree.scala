package ru.hse.spb.bst

case class RedBlackTree[K <: Comparable[K]]() extends BSTree[K] {
  var root: Option[RBTNode[K]] = None


  override def insert(value: K): Unit = {
    var father: Option[RBTNode[K]] = None
    var current: Option[RBTNode[K]] = root

    while (current.isDefined) {
      father = current
      value compareTo current.get.value match {
        case -1 => current = current.get.left
        case 1 => current = current.get.right
        case 0 =>
          current.get.value = value
          return
      }
    }

    if (father.isEmpty) {
      root = Some(RBTNode(value, father, isBlack = true))
      return
    }

    value compareTo father.get.value match {
      case -1 =>
        father.get.left = Some(RBTNode(value, father))
        insertFixup(father.get.left)
      case 1 =>
        father.get.right = Some(RBTNode(value, father))
        insertFixup(father.get.right)
    }
  }

  override def delete(value: K): Unit = {
    val node = search(value)
    if (node.isDefined) {
      return
    }
    deleteNode(node)
  }

  private def deleteNode(node: Option[RBTNode[K]]): Unit = {

    val prev = maxInSubTree(node.get.left)

    if (node.get.right.isDefined && node.get.left.isDefined) {
      node.get.value = prev.get.value
      deleteNode(prev)
    } else if (node == root && node.get.left.isEmpty && node.get.right.isEmpty) {
      root = None
    } else if (!node.get.isBlack && node.get.left.isEmpty && node.get.right.isEmpty) {
      if (node == node.get.parent.get.left) {
        node.get.parent.get.left = None
      } else {
        node.get.parent.get.right = None
      }
    } else if (node.get.isBlack && node.get.left.isDefined && !node.get.left.get.isBlack) {
      node.get.value = node.get.left.get.value
      node.get.left = None
    } else if (node.get.isBlack && node.get.right.isDefined && !node.get.right.get.isBlack) {
      node.get.value = node.get.right.get.value
      node.get.right = None
    } else {
      deleteCase1(node.get)
    }

  }

  private def deleteCase1(node: RBTNode[K]): Unit = {
    if (node.parent.isDefined) {
      deleteCase2(node)
    }
  }

  private def deleteCase2(node: RBTNode[K]): Unit = {
    val brother = node.brother()

    if (!brother.get.isBlack) {
      if (node == node.parent.get.left.get) {
        node.parent.get.rotateLeft()
      } else if (node == node.parent.get.right.get) {
        node.parent.get.rotateRight()
      }

      if (root == node.parent) {
        root = node.parent.get.parent
      }
    }
    deleteCase3(node)
  }

  private def deleteCase3(node: RBTNode[K]): Unit = {
    val brother = node.brother()

    val a = brother.get.left.isEmpty || brother.get.left.get.isBlack
    val b = brother.map(i => i).get.right.isEmpty || brother.get.right.get.isBlack

    if (a && b && brother.get.isBlack && node.parent.get.isBlack) {
      brother.get.isBlack = false
      deleteCase1(node.parent.get)
    } else {
      deleteCase4(node)
    }

  }

  private def deleteCase4(node: RBTNode[K]): Unit = {
    val brother = node.brother()

    val a = brother.get.left.isEmpty || brother.get.left.get.isBlack
    val b = brother.map(i => i).get.right.isEmpty || brother.get.right.get.isBlack

    if (a && b && brother.get.isBlack && !node.parent.get.isBlack) {
      brother.get.isBlack = false
      node.parent.get.isBlack = true
    } else {
      deleteCase5(node)
    }
  }

  private def deleteCase5(node: RBTNode[K]): Unit = {
    val brother = node.brother()

    val a = brother.get.left.isEmpty || brother.get.left.get.isBlack
    val b = brother.map(i => i).get.right.isEmpty || brother.get.right.get.isBlack

    if (brother.get.isBlack) {
      if (!brother.get.left.map(i => i).get.isBlack && b && node == node.parent.map(i => i).get.left.get) {
        brother.get.rotateRight()
      } else if (!brother.get.left.map(i => i).get.isBlack && a && node == node.parent.map(i => i).get.left.get) {
        brother.get.rotateLeft()
      }

    }
    deleteCase6(node)

  }

  private def deleteCase6(node: RBTNode[K]): Unit = {
    val brother = node.brother()
    if (node == node.parent.get.left.get) {
      brother.map(i => i).get.left.map(i => i).get.isBlack = true
      node.parent.map(i => i).get.rotateLeft()
    } else {
      brother.map(i => i).get.left.map(i => i).get.isBlack = true
      node.parent.map(i => i).get.rotateRight()
    }

    if (root == node.parent) {
      root = node.parent.get.parent
    }
  }


  override def search(value: K): Option[RBTNode[K]] = {
    var current = root

    while (current.isDefined) {
      value compareTo current.get.value match {
        case -1 => current = current.get.left
        case 1 => current = current.get.right
        case 0 => current
      }
    }
    None
  }

  private def insertFixup(otherNode: Option[RBTNode[K]]): Unit = {
    var uncle: Option[RBTNode[K]] = None
    var current: Option[RBTNode[K]] = otherNode

    while (!current.map(_.parent).get.map(_.isBlack).get) {
      if (current.get.parent == current.get.parent.map(_.parent).get.map(_.left).get) {
        uncle = current.get.parent.get.parent.get.right

        if (uncle.isDefined && !uncle.map(_.isBlack).get) {
          current.get.parent.map(i => i).get.isBlack = true
          uncle.get.isBlack = true
          current.get.parent.get.parent.get.isBlack = false
          current = current.get.parent.get.parent
        } else if (current == current.get.parent.get.right) {
          current = current.get.parent
          if (current.get.parent.get.parent.isEmpty) {
            root = current.get.parent
          }
          current.get.rotateLeft()
        }
        else if (current == current.get.parent.get.left) {
          current = current.get.parent
          if (current.get.parent.get.parent.get.parent.isEmpty) {
            root = current.get.parent
          }
          current.get.parent.get.parent.get.rotateRight()
        }

      } else {
        uncle = current.get.parent.get.parent.get.left

        if (uncle.isDefined && !uncle.map(_.isBlack).get) {
          current.get.parent.map(i => i).get.isBlack = true
          uncle.get.isBlack = true
          current.get.parent.get.parent.get.isBlack = false
          current = current.get.parent.get.parent
        } else if (current == current.get.parent.get.left) {
          current = current.get.parent
          if (current.get.parent.get.parent.isEmpty) {
            root = current.get.parent
          }
          current.get.rotateRight()
        }
        else if (current == current.get.parent.get.right) {
          if (current.get.parent.get.parent.get.parent.isEmpty) {
            root = current.get.parent
          }
          current.map(i => i).get.parent.map(i => i).get.parent.map(i => i).get.rotateLeft()
        }
      }
    }

    if (root.isDefined) {
      root.get.isBlack = true
    }

  }

  private def minInSubTree(node: Option[RBTNode[K]]): Option[RBTNode[K]] = {
    if (node.map(i => i).get.left.isEmpty) {
      node
    } else {
      minInSubTree(node.get.left)
    }
  }

  private def maxInSubTree(node: Option[RBTNode[K]]): Option[RBTNode[K]] = {
    if (node.map(i => i).get.right.isEmpty) {
      node
    } else {
      maxInSubTree(node.get.right)
    }
  }

  private def nextSmaller(node: Option[RBTNode[K]]): Option[RBTNode[K]] = {
    if (node.isEmpty) {
      None
    }
    var smaller = node
    if (smaller.get.left.isDefined) {
      maxInSubTree(smaller.get.left)
    } else if (smaller == smaller.get.parent.map(i => i).get.left) {
      while (smaller == smaller.get.parent.map(i => i).get.left) {
        smaller = smaller.get.parent
      }
    }
    smaller.get.parent
  }

}