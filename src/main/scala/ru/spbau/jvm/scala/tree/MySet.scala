package ru.spbau.jvm.scala.tree

trait MyBaseSet[A] extends MyIterable[A] {
  def contains(value: A): Boolean
  def apply(value: A): Boolean = contains(value)
}

trait MySet[A, +Repr <: MySet[A, Repr]] extends MyBaseSet[A] {
  def repr: Repr = this.asInstanceOf[Repr]

  def containsAll(from: MyIterable[A]): Boolean = from.forall(contains)
  def containsAll(from: Iterable[A]): Boolean = from.forall(contains)

  def contentEquals(from: Set[A]): Boolean = from.forall(contains) && forall(from.contains)

  def add(value: A): Repr
  def +(value: A): Repr = add(value)
  def + (value1: A, value2: A, values: A*): Repr = this + value1 + value2 ++ values

  def addAll(from: Iterable[A]): Repr = from.foldLeft(this)(_ + _).repr
  def ++(from: Iterable[A]): Repr = addAll(from)

  def addAll(from: MyIterable[A]): Repr = from.foldLeft(this)(_ + _).repr
  def ++(from: MyIterable[A]): Repr = addAll(from)

  def remove(value: A): Repr
  def -(value: A): Repr = remove(value)
  def - (value1: A, value2: A, values: A*): Repr = this - value1 - value2 -- values

  def removeAll(from: Iterable[A]): Repr = from.foldLeft(this)(_ - _).repr
  def --(from: Iterable[A]): Repr = removeAll(from)

  def removeAll(from: MyIterable[A]): Repr = from.foldLeft(this)(_ - _).repr
  def --(from: MyIterable[A]): Repr = removeAll(from)

  def empty: Repr

  def intersect(other: MyBaseSet[A]): Repr
  def &(other: MyBaseSet[A]): Repr = intersect(other)

  def union(other: MyBaseSet[A]): Repr
  def |(other: MyBaseSet[A]): Repr = union(other)

  def diff(other: MyBaseSet[A]): Repr
  def &~(other: MyBaseSet[A]): Repr = diff(other)

  def filter(p: A => Boolean): Repr
  // не повторяя сложную иерархию типов из scala.collection объявить map и flatMap в trait'е у меня не получилось
//  def map[B, That](f: A => B)(implicit ordB: Ordering[B], bf: CanBuildFrom[Repr, B, That]): That
//  def flatMap[B, That](f: A => That)(implicit ordB: Ordering[B], bf: CanBuildFrom[Repr, B, That]): That
}