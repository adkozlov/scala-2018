package ru.spbau.jvm.scala.calculator

object Operation {
  sealed trait Type
  case object UNARY extends Operation.Type
  case object BINARY extends Operation.Type
  case object ARITHMETIC extends Operation.Type
  case object LOGICAL extends Operation.Type
}