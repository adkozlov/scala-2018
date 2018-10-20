import arithmetic.{ArithmeticBaseVisitor, ArithmeticLexer, ArithmeticParser}
import org.antlr.v4.runtime._

import scala.collection.JavaConverters._
import scala.io.StdIn

sealed trait EvalResult

case class NumberResult(result: Double) extends EvalResult

case class BooleanResult(result: Boolean) extends EvalResult

object EvalVisitor extends ArithmeticBaseVisitor[EvalResult] {
  override def visitExpression(ctx: ArithmeticParser.ExpressionContext): EvalResult = {
    val operations = ctx.ops.asScala.map(parseOperand)
    val terms = ctx.rest.asScala.map {
      _.accept(this)
    }

    operations
      .zip(terms)
      .foldLeft(ctx.head.accept(this)) { (acc, data) =>
        val (op, cur) = data
        (acc, cur) match {
          case (NumberResult(l), NumberResult(r)) => NumberResult(op(l, r))
          case _ => throw new IllegalArgumentException(s"Cannot perform operation on $acc and $op")
        }
      }
  }

  override def visitTerm(ctx: ArithmeticParser.TermContext): EvalResult = {
    val operations = ctx.ops.asScala.map(parseOperand)
    val terms = ctx.rest.asScala.map {
      _.accept(this)
    }

    operations
      .zip(terms)
      .foldLeft(ctx.head.accept(this)) { (acc, data) =>
        val (op, cur) = data
        (acc, cur) match {
          case (NumberResult(l), NumberResult(r)) => NumberResult(op(l, r))
          case _ => throw new IllegalArgumentException(s"Cannot perform operation on $acc and $op")
        }
      }
  }

  private def parseOperand(token: Token): (Double, Double) => Double =
    token.getType match {
      case ArithmeticParser.PLUS => _ + _
      case ArithmeticParser.MINUS => _ - _
      case ArithmeticParser.TIMES => _ * _
      case ArithmeticParser.DIV => _ / _
      case _ => throw new IllegalArgumentException(s"Illegal operator $token")
    }

  override def visitSignedAtom(ctx: ArithmeticParser.SignedAtomContext): EvalResult =
    if (ctx.MINUS == null) {
      ctx.atom().accept(this)
    } else {
      ctx.atom().accept(this) match {
        case NumberResult(result) => NumberResult(-result)
        case _ => throw new IllegalArgumentException(s"Cannot negate ${ctx.atom()}")
      }
    }

  override def visitNumberAtom(ctx: ArithmeticParser.NumberAtomContext): EvalResult =
    NumberResult(ctx.NUMBER().getText.toDouble)

  override def visitAtomInParens(ctx: ArithmeticParser.AtomInParensContext): EvalResult =
    ctx.expression().accept(this)
}

object Main {
  def eval(s: String): EvalResult = {
    val lexer = new ArithmeticLexer(CharStreams.fromString(s))
    val parser = new ArithmeticParser(new CommonTokenStream(lexer))

    parser.expression().accept(EvalVisitor)
  }

  def main(args: Array[String]): Unit = {
    while (true) {
      val line = StdIn.readLine()
      if (line == null) return

      try {
        println(eval(line))
      } catch {
        case e: RuntimeException => println(s"Error during evaluation: ${e.getMessage}")
      }
    }
  }
}
