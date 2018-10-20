import arithmetic.{ArithmeticBaseVisitor, ArithmeticLexer, ArithmeticParser}
import org.antlr.v4.runtime._

import scala.collection.JavaConverters._
import scala.io.StdIn

sealed trait EvalResult

case class NumberResult(result: Double) extends EvalResult

object ArithmeticEvalVisitor extends ArithmeticBaseVisitor[NumberResult] {
  private type DoubleOperator = (Double, Double) => Double

  override def visitExpression(ctx: ArithmeticParser.ExpressionContext): NumberResult = {
    val operations = ctx.ops.asScala.map(parseOperand)
    val terms = ctx.rest.asScala.map {
      _.accept(this)
    }

    foldEquations(ctx.head.accept(this), operations, terms)
  }

  override def visitTerm(ctx: ArithmeticParser.TermContext): NumberResult = {
    val operations = ctx.ops.asScala.map(parseOperand)
    val terms = ctx.rest.asScala.map {
      _.accept(this)
    }

    foldEquations(ctx.head.accept(this), operations, terms)
  }

  override def visitSignedAtom(ctx: ArithmeticParser.SignedAtomContext): NumberResult =
    if (ctx.MINUS == null) {
      ctx.atom().accept(this)
    } else {
      NumberResult(ctx.atom().accept(this).result)
    }

  override def visitNumberAtom(ctx: ArithmeticParser.NumberAtomContext): NumberResult =
    NumberResult(ctx.NUMBER().getText.toDouble)

  override def visitAtomInParens(ctx: ArithmeticParser.AtomInParensContext): NumberResult =
    ctx.expression().accept(this)

  private def parseOperand(token: Token): DoubleOperator =
    token.getType match {
      case ArithmeticParser.PLUS => _ + _
      case ArithmeticParser.MINUS => _ - _
      case ArithmeticParser.TIMES => _ * _
      case ArithmeticParser.DIV => _ / _
      case _ => throw new IllegalArgumentException(s"Illegal operator $token")
    }

  private def foldEquations(head: NumberResult,
                            operations: Iterable[DoubleOperator],
                            rest: Iterable[NumberResult]): NumberResult = {
    operations.zip(rest).foldLeft(head) { (acc, data) =>
      val (op, cur) = data
      NumberResult(op(acc.result, cur.result))
    }
  }
}

object Main {
  def eval(s: String): EvalResult = {
    val lexer = new ArithmeticLexer(CharStreams.fromString(s))
    val parser = new ArithmeticParser(new CommonTokenStream(lexer))

    parser.expression().accept(ArithmeticEvalVisitor)
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
