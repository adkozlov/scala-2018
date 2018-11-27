package ru.spbau.jvm.scala.mycollection

import scala.reflect.ClassTag

trait Set[A] extends Iterable[A] {
  def contains(key: A): Boolean

  def apply(key: A): Boolean = contains(key)

  def add(elem: A): Boolean

  def +=(elem: A): this.type

  def ++=(elems: Iterable[A]): this.type = {
    elems.foreach(elem => this += elem)
    this
  }


  def -=(elem: A): this.type

  def --=(elems: Iterable[A]): this.type = {
    elems.foreach(elem => this -= elem)
    this
  }

  def remove(elem: A): Boolean

  def empty(): Set[A]

  def size: Int

  def map[B: ClassTag](f: A => B)(implicit ordering: Ordering[B]): Set[B]

  def flatMap[B: ClassTag](f: A => Iterable[B])(implicit ordering: Ordering[B]): Set[B]

  override def isEmpty: Boolean = size == 0

  def toArray: Array[A]

  def clear(): Unit

  def filter(p: A => Boolean): Set[A]
}
