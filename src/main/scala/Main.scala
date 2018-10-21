import Utils.foldWithActions
import arithmetic.ArithmeticAndLogicParser._
import arithmetic.{ArithmeticAndLogicBaseVisitor, ArithmeticAndLogicLexer, ArithmeticAndLogicParser}
import org.antlr.v4.runtime._

import scala.collection.JavaConverters._
import scala.io.StdIn

object Utils {
  private type Action[T] = ((T, T) => T, T)

  def foldWithActions[T](head: T, operations: Iterable[Action[T]]): T = {
    operations.foldLeft(head) { (acc, data) =>
      val (op, cur) = data
      op(acc, cur)
    }
  }
}

object ArithmeticAndLogicEvalVisitor extends ArithmeticAndLogicBaseVisitor[Any] {
  override def visitLogic(ctx: LogicContext): Boolean =
    ctx.logicExpression().accept(LogicEvalVisitor)

  override def visitArithmetic(ctx: ArithmeticContext): Double =
    ctx.arithmeticExpression().accept(ArithmeticEvalVisitor)
}

object LogicEvalVisitor extends ArithmeticAndLogicBaseVisitor[Boolean] {

  override def visitLogicExpression(ctx: LogicExpressionContext): Boolean = {
    val head = ctx.head.accept(this)
    val rest = ctx.rest.asScala.map(_.accept(this))
    val operations = ctx.ops.asScala.map(parseOperand)

    foldWithActions(head, operations zip rest)
  }

  override def visitBoolTerm(ctx: BoolTermContext): Boolean = {
    val head = ctx.head.accept(this)
    val rest = ctx.rest.asScala.map(_.accept(this))
    val operations = ctx.ops.asScala.map(parseOperand)

    foldWithActions(head, operations zip rest)
  }

  override def visitNegatedBoolAtom(ctx: NegatedBoolAtomContext): Boolean =
    if (ctx.NOT() == null) {
      ctx.boolAtom.accept(this)
    } else {
      !ctx.negatedBoolAtom.accept(this)
    }

  override def visitBoolLiteralAtom(ctx: BoolLiteralAtomContext): Boolean =
    ctx.literal.getType match {
      case TRUE => true
      case FALSE => false
      case _ => throw new IllegalArgumentException(s"Unknown boolean literal ${ctx.literal}")
    }


  private def parseOperand(token: Token): (Boolean, Boolean) => Boolean = {
    token.getType match {
      case AND => _ && _
      case OR => _ || _
      case _ => throw new IllegalArgumentException(s"Illegal operator $token")
    }
  }

  override def visitBoolAtomInParens(ctx: BoolAtomInParensContext): Boolean =
    ctx.logicExpression().accept(this)
}

object ArithmeticEvalVisitor extends ArithmeticAndLogicBaseVisitor[Double] {
  override def visitArithmeticExpression(ctx: ArithmeticExpressionContext): Double = {
    val head = ctx.head.accept(this)
    val operations = ctx.ops.asScala.map(parseOperand)
    val terms = ctx.rest.asScala.map(_.accept(this))

    foldWithActions(head, operations zip terms)
  }

  override def visitMathTerm(ctx: MathTermContext): Double = {
    val head = ctx.head.accept(this)
    val operations = ctx.ops.asScala.map(parseOperand)
    val rest = ctx.rest.asScala.map(_.accept(this))

    foldWithActions(head, operations zip rest)
  }

  override def visitSignedAtom(ctx: SignedAtomContext): Double =
    if (ctx.MINUS == null) {
      ctx.mathAtom.accept(this)
    } else {
      -ctx.signedAtom.accept(this)
    }

  override def visitNumberAtom(ctx: NumberAtomContext): Double =
    ctx.NUMBER().getText.toDouble

  override def visitAtomInParens(ctx: AtomInParensContext): Double =
    ctx.arithmeticExpression().accept(this)

  private def parseOperand(token: Token): (Double, Double) => Double =
    token.getType match {
      case PLUS => _ + _
      case MINUS => _ - _
      case TIMES => _ * _
      case DIV => _ / _
      case _ => throw new IllegalArgumentException(s"Illegal operator $token")
    }
}

object Main {
  def eval(s: String): Any = {
    val lexer = new ArithmeticAndLogicLexer(CharStreams.fromString(s))
    val parser = new ArithmeticAndLogicParser(new CommonTokenStream(lexer))

    parser.equation().accept(ArithmeticAndLogicEvalVisitor)
  }

  def main(args: Array[String]): Unit = {
    println("Math and logic interpreter")
    println("To exit, type in ctrl+D")
    println()

    while (true) {
      val line = StdIn.readLine("> ")
      if (line == null) return

      try {
        println(eval(line))
      } catch {
        case e: RuntimeException => println(s"Error during evaluation: ${e.getMessage}")
      }
    }
  }
}
