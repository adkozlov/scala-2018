package ru.hse.jvm.scala

import org.scalatest.{FlatSpec, Matchers}

class CalcTest extends FlatSpec with Matchers{

  def check(expr: String, value: Double): Unit = {
    Main.eval(expr) should be(value)
  }

  "calc" should "additive" in check("2+2+2", 6)

  "calc" should "multiplicative" in check("2*2*2", 8)

  "calc" should "assoctiative subtraction" in check("2-2-2", -2)

  "calc" should "assoctiative division" in check("8/2/2", 2)
}

