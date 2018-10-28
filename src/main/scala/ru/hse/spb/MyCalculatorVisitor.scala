package ru.hse.spb

import ru.hse.spb.parser.{CalculatorBaseVisitor, CalculatorParser}

class MyCalculatorVisitor extends CalculatorBaseVisitor[Any] {

  /**
    * @inheritdoc
    */
  override def visitLexpression(ctx: CalculatorParser.LexpressionContext): Boolean = {
    ctx match {
      case _ if ctx.latom != null => return visit(ctx.latom).asInstanceOf[Boolean]
      case _ if ctx.TRUE != null => return true
      case _ if ctx.FALSE != null => return false
      case _ =>
    }
    if (ctx.NOT != null) {
      return !visit(ctx.lexpression(0)).asInstanceOf[Boolean]
    }
    if (ctx.relop != null) {
      val leftOperand = visit(ctx.expression(0)).asInstanceOf[Double]
      val rightOperand = visit(ctx.expression(1)).asInstanceOf[Double]
      ctx match {
        case _ if ctx.relop.EQ != null => return leftOperand == rightOperand
        case _ if ctx.relop.GT != null => return leftOperand > rightOperand
        case _ if ctx.relop.GEQ != null => return leftOperand >= rightOperand
        case _ if ctx.relop.LT != null => return leftOperand < rightOperand
        case _ if ctx.relop.LEQ != null => return leftOperand <= rightOperand
        case _ =>
      }
    }
    val leftOperand = visit(ctx.lexpression(0)).asInstanceOf[Boolean]
    val rightOperand = visit(ctx.lexpression(1)).asInstanceOf[Boolean]
    ctx match {
      case _ if ctx.AND != null => leftOperand && rightOperand
      case _ if ctx.OR != null => leftOperand || rightOperand
    }
  }

  /**
    * @inheritdoc
    */
  override def visitExpression(ctx: CalculatorParser.ExpressionContext): Double = {
    val term = visit(ctx.term).asInstanceOf[Double]
    ctx match {
      case _ if ctx.PLUS != null => visit(ctx.expression).asInstanceOf[Double] + term
      case _ if ctx.MINUS != null => visit(ctx.expression).asInstanceOf[Double] - term
      case _ => term
    }
  }

  /**
    * @inheritdoc
    */
  override def visitTerm(ctx: CalculatorParser.TermContext): Double = {
    val factor = visit(ctx.factor).asInstanceOf[Double]
    ctx match {
      case _ if ctx.TIMES != null => visit(ctx.term).asInstanceOf[Double] * factor
      case _ if ctx.DIV != null => visit(ctx.term).asInstanceOf[Double] / factor
      case _ => factor
    }
  }

  /**
    * @inheritdoc
    */
  override def visitFactor(ctx: CalculatorParser.FactorContext): Double = {
    val signedAtom = visit(ctx.signedAtom).asInstanceOf[Double]
    ctx match {
      case _ if ctx.POW != null => math.pow(visit(ctx.factor).asInstanceOf[Double], signedAtom)
      case _ => signedAtom
    }
  }

  /**
    * @inheritdoc
    */
  override def visitSignedAtom(ctx: CalculatorParser.SignedAtomContext): Double = {
    ctx match {
      case _ if ctx.MINUS != null => -visit(ctx.atom).asInstanceOf[Double]
      case _ => visit(ctx.atom).asInstanceOf[Double]
    }
  }

  /**
    * @inheritdoc
    */
  override def visitAtom(ctx: CalculatorParser.AtomContext): Any = {
    ctx match {
      case _ if ctx.expression != null => visit(ctx.expression)
      case _ => ctx.NUMBER.toString.toDouble
    }
  }

  /**
    * @inheritdoc
    */
  override def visitLatom(ctx: CalculatorParser.LatomContext): Boolean = {
    visit(ctx.lexpression).asInstanceOf[Boolean]
  }

  /**
    * @inheritdoc
    */
  override def visitInput(ctx: CalculatorParser.InputContext): String = {
    ctx match {
      case _ if ctx.expression != null => visit(ctx.expression).toString
      case _ => visit(ctx.lexpression).toString
    }
  }
}
