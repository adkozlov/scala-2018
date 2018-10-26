package ru.hse.spb

import org.antlr.v4.runtime._
import org.antlr.v4.runtime.tree._

object Main {
    def main(args: Array[String]) = {
        val inputText = args.headOption.getOrElse("0")
        val input = new ANTLRInputStream(inputText)
        val lexer = new CalcLexer(input)
        val tokens = new CommonTokenStream(lexer)
        val parser = new CalcParser(tokens)
        val tree = parser.expression()
        println(tree toStringTree parser)
    }
}
