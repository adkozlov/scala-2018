package tree

sealed abstract class List[E] extends Collection[E] {
  protected var _size = 0

  override def size: Int = _size

  /**
    * Adds element ot the front of the list
    *
    * @param element element to add
    * @return new version of list
    */
  override def add(element: E): List[E] = {
    val l = Cons(element, this)
    l
  }

  override def remove(element: E): List[E] = this match {
    case Nil() => Nil()
    case Cons(v, l) =>
      if (!v.equals(element)) {
        return Cons(v, l.remove(element))
      }
      l
  }

  override def iterator: Iterator[E] = new ListIterator(this)

  private class ListIterator(var list : List[E]) extends Iterator[E] {
    override def hasNext: Boolean = list match {
      case Nil() => false
      case Cons(_, _) => true
    }

    override def next: E = list match {
      case Nil() => throw OutOfElementsException
      case Cons(v, l) =>
        list = l
        v
    }
  }

}

final case class Nil[E]() extends List[E] {
  this._size = 0
}

final case class Cons[E](value: E, list: List[E] = Nil()) extends List[E] {
  this._size = list.size + 1
}

object Main {

  def main(args: Array[String]): Unit = {
    var list: List[Int] = new Nil[Int]

    list = list.add(1)
    list.contains(1)
  }
}


