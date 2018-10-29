import scala.io.StdIn.readLine

object Main {
  private val TERMINATOR = "exit"

  def main(args: Array[String]): Unit = {
    println("Enter expression to calculate or 'exit' to halt")
    var input: String = null
    do {
      print("> ")
      input = readLine()
      if (input != TERMINATOR) {
        try {
          println(Evaluator.getStringResult(input))
        } catch {
          case e: ParsingException => println(s"Invalid expression: ${e.message}")
          case _: ArithmeticException => println("Zero division occurred")
          case e: Throwable => println(s"Unknown error: ${e.getMessage}")
        }
      }
    } while (input != TERMINATOR)
  }
}
