grammar RealField;


realExpr
  : addition | EOF
  ;

addition
  : left=multiplication (operation=(PLUS | MINUS) right=addition)?               # binaryAddition
  ;

multiplication
  : left=unary (operation=(PRODUCT | DIVISION | MODULUS) right=multiplication)?  # binaryMultiplication
  ;

unary
  :     value=atom     # unaryReal
  | '-' value=unary    # unaryNegate
  ;

atom
  : literal=NUM        # literal
  | '(' realExpr ')'   # parenthesizedExp
  ;

PLUS     : '+';
MINUS    : '-';
PRODUCT  : '*';
DIVISION : '/';
MODULUS  : '%';

NUM    : [0-9]+;
WS     : [ \t\r\n]+ -> skip;
