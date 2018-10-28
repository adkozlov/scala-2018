package ru.hse.spb

import ru.hse.spb.ExpParser.ExpressionContext

import scala.collection.JavaConverters._

object MyVisitor extends ExpBaseVisitor[Int] {

  private def toInt(x: Boolean) = if (x) 1 else 0
  private def toBoolean(x: Int) = x != 0

  override def visitExpression(ctx: ExpressionContext): Int = {
    val left = ctx.left.accept(this)
    val rights = ctx.right.asScala.map(_.accept(this)).map(x => toBoolean(x))
    if (rights.isEmpty)
      left
    else {
      val boolLeft = toBoolean(left)
      toInt(rights.foldLeft(boolLeft) {(x, y) => x || y})
    }
  }


  override def visitAndExp(ctx: ExpParser.AndExpContext): Int = {
    val left = ctx.left.accept(this)
    val rights = ctx.right.asScala.map(_.accept(this)).map(x => toBoolean(x))
    if (rights.isEmpty)
      left
    else {
      val boolLeft = toBoolean(left)
      toInt(rights.foldLeft(boolLeft) {(x, y) => x && y})
    }
  }


  override def visitEqualsExp(ctx: ExpParser.EqualsExpContext): Int = {
    val left = ctx.left.accept(this)
    if (ctx.right == null)
      left
    else {
      val right = ctx.right.accept(this)
      val op : (Int, Int) => Boolean = ctx.op.getText  match {
        case "==" => _ == _
        case "!=" => _ != _
      }

      toInt(op(left, right))
    }
  }


  override def visitCompareExp(ctx: ExpParser.CompareExpContext): Int = {
    val left = ctx.left.accept(this)
    if (ctx.right == null)
      left
    else {
      val right = ctx.right.accept(this)
      val op: (Int, Int) => Boolean = ctx.op.getText match {
        case ">" => _ > _
        case "<" => _ < _
        case ">=" => _ >= _
        case "<=" => _ <= _
      }

      toInt(op(left, right))
    }
  }


  override def visitPlusExp(ctx: ExpParser.PlusExpContext): Int = {
    val left = ctx.left.accept(this)
    val rights = ctx.right.asScala.map(_.accept(this))

    ctx.op.asScala.map ( { x => x.getText match {
      case "+" => (a : Int, b : Int) => a + b
      case "-" => (a : Int, b : Int) => a - b
    }})
      .zip(rights).foldLeft(left) { (left, op_right) => op_right._1(left, op_right._2) }
  }


  override def visitMultExp(ctx: ExpParser.MultExpContext): Int = {
    val left = ctx.left.accept(this)
    val rights = ctx.right.asScala.map(_.accept(this))

    ctx.op.asScala.map ( { x => x.getText match {
      case "*" => (a : Int, b : Int) => a * b
      case "/" => (a : Int, b : Int) => a / b
      case "%" => (a : Int, b : Int) => a % b
    }})
      .zip(rights).foldLeft(left) { (left, op_right) => op_right._1(left, op_right._2) }
  }


  override def visitLiteral(ctx: ExpParser.LiteralContext): Int = {
    if (ctx.expression() != null)
      ctx.expression().accept(this)
    else
      ctx.Literal().getSymbol.getText.toInt
  }
}
