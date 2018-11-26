package ru.hse.jvm

import ru.hse.jvm.util.Treap

class TreeSet[T : Manifest](implicit ord: Ordering[T]) {
  private val treap : Treap[T] = new Treap[T]()

  def isEmpty : Boolean = treap.isEmpty
  def count : Int = treap.getSize
  def contains(value : T) : Boolean = treap.contains(value)
  def add(value : T) : Unit = treap.insert(value)
  def remove(value : T) : Unit = treap.remove(value)

  def iterator : Iterator[T] = treap.iterator
  def toArray : Array[T] = treap.toArray

  def foreach(f : T => Unit) : Unit = {
    val it = iterator
    while (it.hasNext) {
      f(it.next)
    }
  }

  def foldLeft[B](z : B)(op : (B, T) => B) : B = {
    var result = z
    foreach (it => {
      result = op(result, it)
    })
    result
  }

  def foldRight[B](z : B)(op : (T, B) => B) : B = {
    def countOnSuffix(it : Iterator[T]): B =
      if (!it.hasNext) z else op(it.next, countOnSuffix(it))
    countOnSuffix(iterator)
  }

  def fold[A >: T](z : A)(op : (A, A) => A) : A = foldLeft(z)(op)

  def map[V : Manifest](op : T => V)(implicit ord : Ordering[V]) : TreeSet[V] = {
    val result : TreeSet[V] = new TreeSet[V]
    foreach(value => result.add(op(value)))
    result
  }

  def flatMap[V : Manifest](op : T => TreeSet[V])(implicit ord : Ordering[V]) : TreeSet[V] = {
    val result = new TreeSet[V]
    foreach(it => {
      op(it).foreach(element => result.add(element))
    })
    result
  }
}

object TreeSet {
  def apply[T : Manifest](values : T*)(implicit ord : Ordering[T]) : TreeSet[T] = {
    val result = new TreeSet[T]
    values.foreach(value => result.add(value))
    result
  }
}