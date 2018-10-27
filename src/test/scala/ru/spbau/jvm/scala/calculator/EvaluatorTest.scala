package ru.spbau.jvm.scala.calculator

import org.junit.Test
import org.scalatest.junit.AssertionsForJUnit

class EvaluatorTest extends AssertionsForJUnit {

  @Test
  def `test numbers`(): Unit = {
    assertResult("1.0") { Main.eval("1") }
    assertResult("-2.0") { Main.eval("-2") }
    assertResult("1.00002") { Main.eval("1.00002") }
    assertResult("-2.01") { Main.eval("-2.01") }
    assertResult("0.1") { Main.eval(".1") }
    assertResult("-0.2") { Main.eval("-.2") }
    assertResult("1.0") { Main.eval("1.") }
    assertResult("-2.0") { Main.eval("-2.") }
    assertResult("1000000.0") { Main.eval("10e5") }
    assertResult("-0.002") { Main.eval("-20e-4") }
    assertResult("1.3E15") { Main.eval("1.3E15") }
  }
  
  @Test
  def `test simple expressions`(): Unit = {
    assertResult("3.0") { Main.eval("1 + 2") }
    assertResult("0.8") { Main.eval("1. - .2") }
    assertResult("17.0") { Main.eval("3.4 * 5") }
    assertResult("0.0") { Main.eval("0/1.0") }
    assertResult("-2.0") { Main.eval("-(1+1)") }
    assertResult("2.0") { Main.eval("+(2)") }
    assertResult("false") { Main.eval("! true") }
    assertResult("false") { Main.eval("true && false") }
    assertResult("false") { Main.eval("false  ||false") }
    assertResult("true") { Main.eval("true^ false") }
    assertResult("false") { Main.eval("false  ==  true") }
  }

  @Test
  def `test complex expressions`(): Unit = {
    assertResult("6.0") { Main.eval("2 + 2 * 2") }
    assertResult("8.0") { Main.eval("(2 + 2) * 2") }
    assertResult("-4.0") { Main.eval("(2 + 2) / -(3 - 2)") }
    assertResult("-10.799000000000001") { Main.eval("(9 - 18.1) + (((-2/3+1)-.19)*2.1)-2") }
  }
  
}
