package ru.hse.spb

import ru.hse.spb.ast._
import scala.collection.mutable.Stack

object Evaluator {

  private class Traverser(stack: Stack[Int]) extends ExprTraverser {
    override def traverse(expression: Expr): Unit = expression match {
      case Const(value) => stack.push(value)
      case BinOp(operator, leftOperand, rightOperand) =>
        super.traverse(expression)
        val y = stack.pop()
        val x = stack.pop()
        val toInt = (b: Boolean) => if (b) 1 else 0
        val toBool = (i: Int) => i != 0
        val result = operator match {
          case "*" => x * y
          case "/" => x / y
          case "%" => x % y
          case "+" => x + y
          case "-" => x - y
          case "<=" => toInt(x <= y)
          case ">=" => toInt(x >= y)
          case "<" => toInt(x < y)
          case ">" => toInt(x > y)
          case "==" => toInt(x == y)
          case "!=" => toInt(x != y)
          case "&&" => toInt(toBool(x) && toBool(y))
          case "||" => toInt(toBool(x) || toBool(y))
        }
        stack.push(result)
    }
  }

  def eval(expression: Expr): Int = {
    val stack = Stack[Int]()
    val traverser = new Traverser(stack)
    traverser.traverse(expression)
    stack.pop()
  }
}
