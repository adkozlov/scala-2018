package ru.hse.spb

import org.antlr.v4.runtime._
import org.antlr.v4.runtime.tree._

object Main {
    def main(args: Array[String]) = {
        val inputText = args.headOption.getOrElse("{1,2,3,4}")
        val input = new ANTLRInputStream(inputText)
        val lexer = new ArrayInitLexer(input)
        val tokens = new CommonTokenStream(lexer)
        val parser = new ArrayInitParser(tokens)
        val tree = parser.init()
        println(tree toStringTree parser)
    }
}
