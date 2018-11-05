package ru.hse.spb.ast

sealed trait Expr

case class Const(value: Int) extends Expr
case class BinOp(operation: String, leftOperand: Expr, rightOperand: Expr)
    extends Expr
