package ru.spbau.jvm.scala.lecture02

import scala.annotation.tailrec

/**
  * Please do not use [[scala.App]]
  *
  * @see [[scala.App]]
  */
object FactorialExample extends App {

  private def fac(n: Int): BigInt =
    if (n == 0) 1
    else n * fac(n - 1)

  private def facTailRec(n: Int) = {
    @tailrec
    def facTailRec(n: Int, accumulator: BigInt = 1): BigInt = n match {
      case 0 => accumulator
      case _ => facTailRec(n - 1, n * accumulator)
    }

    facTailRec(n)
  }

  println("Hello, world")

  val bigInteger = 100000
  try {
    fac(bigInteger)
  } catch {
    case _: StackOverflowError =>
      println(facTailRec(bigInteger))
  } finally {
  }
}
