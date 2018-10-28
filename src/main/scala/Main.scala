import org.antlr.v4.runtime.{ANTLRInputStream, CommonTokenStream}
import grammar._

import scala.io.StdIn

object Main {
  def parse(input:String) = {


    val charStream = new ANTLRInputStream(input)
    val lexer = new CalcLexer(charStream)
    val tokens = new CommonTokenStream(lexer)
    val parser = new CalcParser(tokens)

    val calcVisitor = new CalcVisitorApp()

    parser.expr().accept(calcVisitor)
  }

  def main(args: Array[String]): Unit = {
    println("Hello!")
    println("Print 'exit' for exit from program")
    while (true) {
      val line = StdIn.readLine()
      println("\nEvaluating expression " + line)
      if (line.equals("exit")) {
        return
      }
      println(parse(line))
    }
  }

}
