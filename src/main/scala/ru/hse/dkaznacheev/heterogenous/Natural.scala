package ru.hse.dkaznacheev.heterogenous

sealed trait Natural

object Natural {
  case object Zero extends Natural

  case class Succ[T <: Natural](pred: T) extends Natural
}