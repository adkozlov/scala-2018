lexer grammar CalculatorLexer;


INT: [0-9]+ ;
MULT: '*' | '/';

SUM: '+' | '-';

COMP: '>' | '<' | '>=' | '<=';

EQ: '==' | '!=';

AND: '&&' ;

OR: '||' ;

RPAREN: ')' ;
LPAREN:	'(' ;

WS : [ \t\r\n]+ -> skip ;