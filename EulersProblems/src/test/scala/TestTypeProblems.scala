import Problem401.{Problem401Scala}
import Problem501.{Problem501Scala}
import Problem549.{Problem549Scala}
import Problem625.{Problem625Scala}
import Problem634.{Nat, Problem634Scala}
import org.junit.Test

class TestTypeProblems {
  @Test
  def testProblem625(): Unit = {
    assert(Problem625Scala.ans(1) == Problem625.toInt[Problem625._1#ProblemSolve])
    assert(Problem625Scala.ans(2) == Problem625.toInt[Problem625._2#ProblemSolve])
    assert(Problem625Scala.ans(3) == Problem625.toInt[Problem625._3#ProblemSolve])
    assert(Problem625Scala.ans(4) == Problem625.toInt[Problem625._4#ProblemSolve])
    assert(Problem625Scala.ans(5) == Problem625.toInt[Problem625._5#ProblemSolve])
    assert(Problem625Scala.ans(6) == Problem625.toInt[Problem625._6#ProblemSolve])
    assert(Problem625Scala.ans(7) == Problem625.toInt[Problem625._7#ProblemSolve])
    assert(Problem625Scala.ans(8) == Problem625.toInt[Problem625._8#ProblemSolve])
    assert(Problem625Scala.ans(9) == Problem625.toInt[Problem625._9#ProblemSolve])
    assert(Problem625Scala.ans(10) == Problem625.toInt[Problem625._10#ProblemSolve])
  }

  @Test
  def testProblem549(): Unit = {
    assert(Problem549Scala.S(1) == Problem549.toInt[Problem549._1#SFor])
    assert(Problem549Scala.S(2) == Problem549.toInt[Problem549._2#SFor])
    assert(Problem549Scala.S(3) == Problem549.toInt[Problem549._3#SFor])
    assert(Problem549Scala.S(4) == Problem549.toInt[Problem549._4#SFor])
    assert(Problem549Scala.S(5) == Problem549.toInt[Problem549._5#SFor])
    assert(Problem549Scala.S(6) == Problem549.toInt[Problem549._6#SFor])
  }

  @Test
  def testProblem401(): Unit = {
    assert(Problem401Scala.sigmaSum(1) == Problem401.toInt[Problem401._1#SigmaSum])
    assert(Problem401Scala.sigmaSum(2) == Problem401.toInt[Problem401._2#SigmaSum])
    assert(Problem401Scala.sigmaSum(3) == Problem401.toInt[Problem401._3#SigmaSum])
    assert(Problem401Scala.sigmaSum(4) == Problem401.toInt[Problem401._4#SigmaSum])
    assert(Problem401Scala.sigmaSum(5) == Problem401.toInt[Problem401._5#SigmaSum])
  }

  @Test
  def testProblem634(): Unit = {
    assert(Problem634Scala.solve(1) == Problem634.toInt[Nat#solve[Problem634._1]])
    assert(Problem634Scala.solve(2) == Problem634.toInt[Nat#solve[Problem634._2]])
    assert(Problem634Scala.solve(3) == Problem634.toInt[Nat#solve[Problem634._3]])
    assert(Problem634Scala.solve(4) == Problem634.toInt[Nat#solve[Problem634._4]])
  }

  @Test
  def testProblem501(): Unit = {
    assert(Problem501Scala.sigma(4, 4) == Problem501.toInt[Problem501._4#Sigma[Problem501._4]])
    assert(Problem501Scala.sigma(5, 5) == Problem501.toInt[Problem501._5#Sigma[Problem501._5]])
    assert(Problem501Scala.f(24) == Problem501.toInt[Problem501._24#F])
  }
}