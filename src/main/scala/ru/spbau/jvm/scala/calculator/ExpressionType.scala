package ru.spbau.jvm.scala.calculator

sealed trait ExpressionType

case class DoubleType(value: Double) extends ExpressionType
case class BooleanType(value: Boolean) extends ExpressionType