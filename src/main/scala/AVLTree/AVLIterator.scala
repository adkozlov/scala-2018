package AVLTree

trait AVLIterator[+V] {

  def hasElements : Boolean

  def hasNext : Boolean

  def next() : V
}

