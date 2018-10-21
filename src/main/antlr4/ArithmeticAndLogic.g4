grammar ArithmeticAndLogic;
import Arithmetic, Logic;

equation
    : logicExpression       # logic
    | arithmeticExpression  # arithmetic
    ;