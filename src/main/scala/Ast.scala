package ru.hse.spb.ast

sealed trait Expr

case class Const(value: Int) extends Expr
case class BinOp(operation: String, left_operand: Expr, right_operand: Expr) extends Expr
