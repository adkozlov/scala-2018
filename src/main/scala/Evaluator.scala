package ru.hse.spb

import ru.hse.spb.ast._

object Evaluator {
    def eval(expression: Expr): Int = expression match {
        case Const(value) => value
        case BinOp(operator, left_operand, right_operand) => {
            val x = eval(left_operand)
            val y = eval(right_operand)
            val toInt = (b: Boolean) => if (b) { 1 } else { 0 }
            val toBool = (i: Int) => i != 0

            /* this match *could* be total if we parsed the operators to some
            enum, but creating such a enum would be a hassle, trashing the
            grammar without evident gains for such a small project that is
            easily verifiable manually. */
            operator match {
                case "*"  => x * y
                case "/"  => x / y
                case "%"  => x % y
                case "+"  => x + y
                case "-"  => x - y
                case "<=" => toInt (x <= y)
                case ">=" => toInt (x >= y)
                case "<"  => toInt (x <  y)
                case ">"  => toInt (x >  y)
                case "==" => toInt (x == y)
                case "!=" => toInt (x != y)
                case "&&" => toInt (toBool(x) && toBool(y))
                case "||" => toInt (toBool(x) || toBool(y))
            }
        }
    }
}
