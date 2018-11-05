package ru.hse.jvm.scala

import org.antlr.v4.runtime.{ANTLRInputStream, BufferedTokenStream}

object Main {
  def eval(expr: String): Double = {
    val lexer = new CalcLexer(new ANTLRInputStream(expr))
    new CalcParser(new BufferedTokenStream(lexer)).eval().accept(new MyVisitor)
  }

  def main(args: Array[String]): Unit = {
    println(eval("1-2*3-2"))
  }
}
