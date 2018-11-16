package ru.hse.mit

import org.antlr.v4.runtime.tree.TerminalNode
import org.antlr.v4.runtime.{BufferedTokenStream, CharStreams, ParserRuleContext}

import scala.collection.convert.Wrappers.JListWrapper

object Calculator extends CalcBaseVisitor[CalcOperand] {
  val PLUS: String = "+"
  val MINUS: String = "-"
  val MULT: String = "*"
  val DIV: String = "/"
  val MOD: String = "%"
  val EQ: String = "=="
  val NEQ: String = "!="
  val LESS: String = "<"
  val GREATER: String = ">"
  val LEQ: String = "<="
  val GEQ: String = ">="
  val OR: String = "||"
  val AND: String = "&&"
  val LEFT_PAREN: String = "("
  val RIGHT_PAREN: String = ")"

  def run(input: String): CalcOperand = {
    val lexer = new CalcLexer(CharStreams.fromString(input))
    val parser = new CalcParser(new BufferedTokenStream(lexer))
    visitData(parser.data())
  }

  override def visitData(ctx: CalcParser.DataContext): CalcOperand = visit(ctx.expression())

  override def visitAdditionExp(ctx: CalcParser.AdditionExpContext): CalcOperand = evaluate(ctx)

  override def visitLogicalExp(ctx: CalcParser.LogicalExpContext): CalcOperand = evaluate(ctx)

  override def visitComparisonExp(ctx: CalcParser.ComparisonExpContext): CalcOperand = evaluate(ctx)

  override def visitAtomExp(ctx: CalcParser.AtomExpContext): CalcOperand = visit(ctx.getChild(0))

  override def visitMultiplyExp(ctx: CalcParser.MultiplyExpContext): CalcOperand = evaluate(ctx)

  def evaluate(ctx: ParserRuleContext): CalcOperand = {
    var result = visit(ctx.getChild(0))
    val length = ctx.children.size()
    if (length > 1) {
      val operations = JListWrapper(ctx.children).tail.sliding(2, 2).toList
      operations.foreach(operation => {
        val second = visit(operation.last)
        operation.head.getText match {
          case PLUS => result += second
          case MINUS => result -= second
          case MULT => result *= second
          case DIV => result /= second
          case MOD => result %= second
          case EQ => result = result == second
          case NEQ => result = result != second
          case LESS => result = result < second
          case GREATER => result = result > second
          case LEQ => result = result <= second
          case GEQ => result = result >= second
          case OR => result = result || second
          case AND => result = result && second
        }
      })
    }
    result
  }

  override def visitTerminal(node: TerminalNode): CalcOperand =
    IntCalcOperand(node.getSymbol.getText.toInt)

  override def visitBool(ctx: CalcParser.BoolContext): CalcOperand =
    BooleanCalcOperand(ctx.getChild(0).getText.toBoolean)

  override def visitParenExp(ctx: CalcParser.ParenExpContext): CalcOperand = visit(ctx.getChild(1))
}
