package ru.spbau.jvm.scala

object SetTreeRB {
  def apply[A : Manifest](args : A*)(implicit ord : Ordering[A]) : SetTreeRB[A] = {
    val tree = new SetTreeRB[A]
    for (i <- args)
      tree.insert(i)
    tree
  }
}

class SetTreeRB[A : Manifest](implicit val ord: Ordering[A]) {

  private val tree: TreeRB[A] = new TreeRB[A]()

  def isEmpty: Boolean = tree.isEmpty

  def size: Int = tree.size

  def contains(key: A): Boolean = tree.contains(key)

  def min(): A = tree.min()

  def max(): A = tree.max()

  def insert(key: A): Unit = tree.insert(key)

  def remove(key: A): Unit = tree.remove(key)

  def foreach(function: A => Unit): Unit = {
    val it = new tree.MyIterator()
    while (it.hasNext()) {
      val value = it.next()
      function(value)
    }
  }

  def map[B : Manifest](function: A => B)(implicit ord: Ordering[B]): SetTreeRB[B] = {
    val newTree = new SetTreeRB[B]
    for (i <- this) {
      newTree.insert(function(i))
    }
    newTree
  }

  def flatMap[B : Manifest](function: A => SetTreeRB[B])(implicit ord: Ordering[B]): SetTreeRB[B] = {
    val newTree = new SetTreeRB[B]
    for (i <- this) {
      for (j <- function(i)) {
        newTree.insert(j)
      }
    }
    newTree
  }

  def filter(predicate: A => Boolean): SetTreeRB[A] = {
    val newTree = new SetTreeRB[A]
    for (i <- this) {
      if (predicate(i))
        newTree.insert(i)
    }
    newTree
  }

  def foldLeft[B](acc: B)(op: (B, A) => B) : B = {
    var value = acc
    foreach(x => { value = op(value, x) })
    value
  }
}