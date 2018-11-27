package ru.hse.spb.bst

trait BSTree[K <: Comparable[K]] {
  def insert(value: K)

  def delete(value: K)

  def search(value: K): Option[RBTNode[K]]

}
