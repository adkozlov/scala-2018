package ru.hse.spb.kazakov

trait Collection[A] {
  def size: Int

  def isEmpty: Boolean = size == 0

  def isNotEmpty: Boolean = size != 0

  def contains(value: A): Boolean

  def add(value: A): Boolean

  def remove(value: A): Boolean

  def clear(): Unit

  def containsAll(collection: Collection[_ <: A]): Boolean = {
    var result = true
    collection.foreach(e => result &= contains(e))
    result
  }

  def addAll(collection: Collection[_ <: A]): Boolean = {
    var result = true
    collection.foreach(e => result &= add(e))
    result
  }

  def removeAll(collection: Collection[_ <: A]): Boolean = {
    var result = true
    collection.foreach(e => result &= remove(e))
    result
  }

  def foreach[B](fun: (_ >: A) => B): Unit
}
