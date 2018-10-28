grammar Arithmetic;

input: expression EOF;

expression: function =  (SIN | COS) LEFT_PARENTHESIS expression RIGHT_PARENTHESIS #FunctionExpr
          | left = expression op = MUL right = expression #MultiplicationExpr
          | left = expression op = ADD right = expression #AdditionExpr
          | left = expression op = (OR|AND) right = expression #LogicalExpr
          | LEFT_PARENTHESIS op = ADD expression RIGHT_PARENTHESIS #UnaryExpr
          | NOT expression #NegateExpression
          | DOUBLE #LiteralExpr
          | LEFT_PARENTHESIS expression RIGHT_PARENTHESIS #ParenthesisedExpr;


SIN: 'sin';
COS: 'cos';

fragment DIGIT: ('0'..'9');

DOUBLE: INTEGER POINT DIGIT+ | INTEGER;
INTEGER: ('1'..'9') DIGIT* | '0';

OR: '||';
AND: '&&';
ADD: '-' | '+';
MUL: '*' | '/' | '%';
NOT: '!';


WHITESPACE: (' ' | '\t' | '\r'| '\n') -> skip;

LEFT_PARENTHESIS: '(';
RIGHT_PARENTHESIS: ')';
POINT: '.';