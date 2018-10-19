package org.ifmo.calculator.stack.elements

sealed trait Value extends StackElement

case class LongValue(value: Long) extends Value

case class BoolValue(value: Boolean) extends Value