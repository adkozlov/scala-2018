import arithmetic.ArithmeticAndLogicParser._
import arithmetic.{ArithmeticAndLogicBaseVisitor, ArithmeticAndLogicLexer, ArithmeticAndLogicParser}
import org.antlr.v4.runtime._
import org.antlr.v4.runtime.tree.ParseTreeVisitor

import scala.collection.JavaConverters._
import scala.io.StdIn

trait BinaryOperationFoldingVisitor[T] {
  this: ParseTreeVisitor[T] =>

  protected def parseOperation(token: Token): (T, T) => T

  protected def foldOperations(head: ParserRuleContext, ops: Iterable[Token], rest: Iterable[ParserRuleContext]): T = {
    val headValue: T = head.accept(this) // idea goes crazy without explicit type
    val restValues = rest.map(_.accept(this))
    val operations = ops.map(parseOperation)

    BinaryOperationFoldingVisitor.foldWithActions(headValue, operations.zip(restValues))
  }
}

object BinaryOperationFoldingVisitor {
  def foldWithActions[T](head: T, operations: Iterable[((T, T) => T, T)]): T =
    operations.foldLeft(head) { case (acc, (op, cur)) => op(acc, cur) }
}

object ArithmeticAndLogicEvalVisitor extends ArithmeticAndLogicBaseVisitor[AnyVal] {
  override def visitLogic(ctx: LogicContext): Boolean =
    ctx.logicExpression().accept(LogicEvalVisitor)

  override def visitArithmetic(ctx: ArithmeticContext): Double =
    ctx.arithmeticExpression().accept(ArithmeticEvalVisitor)
}

object LogicEvalVisitor extends ArithmeticAndLogicBaseVisitor[Boolean] with BinaryOperationFoldingVisitor[Boolean] {

  override def visitLogicExpression(ctx: LogicExpressionContext): Boolean =
    foldOperations(ctx.head, ctx.ops.asScala, ctx.rest.asScala)

  override def visitBoolTerm(ctx: BoolTermContext): Boolean =
    foldOperations(ctx.head, ctx.ops.asScala, ctx.rest.asScala)

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

  protected override def parseOperation(token: Token): (Boolean, Boolean) => Boolean = {
    token.getType match {
      case AND => _ && _
      case OR => _ || _
      case _ => throw new IllegalArgumentException(s"Illegal operator $token")
    }
  }

  override def visitBoolAtomInParens(ctx: BoolAtomInParensContext): Boolean =
    ctx.logicExpression().accept(this)
}

object ArithmeticEvalVisitor extends ArithmeticAndLogicBaseVisitor[Double] with BinaryOperationFoldingVisitor[Double] {
  override def visitArithmeticExpression(ctx: ArithmeticExpressionContext): Double =
    foldOperations(ctx.head, ctx.ops.asScala, ctx.rest.asScala)

  override def visitMathTerm(ctx: MathTermContext): Double =
    foldOperations(ctx.head, ctx.ops.asScala, ctx.rest.asScala)

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

  protected override def parseOperation(token: Token): (Double, Double) => Double =
    token.getType match {
      case PLUS => _ + _
      case MINUS => _ - _
      case TIMES => _ * _
      case DIV => _ / _
      case _ => throw new IllegalArgumentException(s"Illegal operator $token")
    }
}

object Main {
  def eval(equation: String): AnyVal = parse(equation).accept(ArithmeticAndLogicEvalVisitor)

  private def parse(equation: String) = {
    val lexer = new ArithmeticAndLogicLexer(CharStreams.fromString(equation))
    val parser = new ArithmeticAndLogicParser(new CommonTokenStream(lexer))

    parser.equation
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
