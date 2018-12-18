package ru.spbau.jvm.scala

sealed trait MyNumber

object MyNumber {
    case object Z extends MyNumber
    case class S [T <: MyNumber](x: T) extends MyNumber
}
