package ru.hse.stack

import ru.hse.iterable

class Stack[A] extends iterable.Iterable[A] {

  import Stack.{Entry, Element, Nil}

  private var root: Entry[A] = Nil

  def push(elem: A): Unit = {
    root = Element(elem, root)
  }

  def pop(): A = {
    root match {
      case Nil => throw new NoSuchElementException("pop from empty stack")
      case Element(elem, prev) =>
        root = prev
        elem
    }
  }

  /** The behavior of this method is undefined in case of modification during iteration. */
  override def iterator: iterable.Iterator[A] = new iterable.Iterator[A] {
    private var current = root

    override def hasNext: Boolean = current match {
      case Nil => false
      case Element(_, _) => true
    }

    override def next(): A = current match {
      case Nil => Iterator.empty.next()
      case Element(elem, prev) =>
        current = prev
        elem
    }
  }
}

object Stack {

  private abstract sealed class Entry[+A]

  private case class Element[+A](elem: A, prev: Entry[A]) extends Entry[A]

  private object Nil extends Entry[Nothing]

}