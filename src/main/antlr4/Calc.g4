grammar Calc;

file : expression EOF ;

expression : <assoc=left> left=expression op=(MULT | DIV | MOD) right=expression      # intBinaryOperation
           | <assoc=left> left=expression op=(PLUS | MINUS) right=expression          # intBinaryOperation
           | <assoc=left> left=expression op=(GT | LT | GEQ | LEQ) right=expression   # boolBinaryOperation
           | <assoc=left> left=expression op=(EQ | NEQ) right=expression              # boolBinaryOperation
           | <assoc=left> left=expression op=AND right=expression                     # boolBinaryOperation
           | <assoc=left> left=expression op=OR right=expression                      # boolBinaryOperation
           | IntLiteral                                                               # integerLiteral
           | BoolLiteral                                                              # booleanLiteral
           | '(' expression ')'                                                       # surroundedExpression ;

IntLiteral : ('1'..'9') ('0'..'9')* | '0' ;

BoolLiteral : 'false' | 'true' ;

SKIP_SYMBOLS : (' ' | '\t' | '\r' | '\n') -> skip ;

PLUS : '+' ;
MINUS : '-' ;
MULT : '*' ;
DIV : '/' ;
MOD : '%' ;
GT : '>' ;
LT : '<' ;
GEQ : '>=' ;
LEQ : '<=' ;
EQ : '==' ;
NEQ : '!=' ;
OR : '||' ;
AND : '&&' ;