grammar Calc;

file : expression EOF;

expression : logical;

logical : equality ((OR | AND) equality)*;

equality : comparison ((EQUAL_EQUAL | NOT_EQUAL) comparison)*;

comparison : addition ((LT | GT | LE | GE) addition)*;

addition : multiplication ((ADD | SUB) multiplication)*;

multiplication : atomic ((MUL | DIV | MOD) atomic)*;

atomic : number | bool | LPAREN expression RPAREN;

number : NUM;

bool : TRUE | FALSE;

//////////////////////////////////////////////////////////////////

TRUE : 'true' ;
FALSE : 'false' ;
NUM : '-'?('1'..'9')('0'..'9')* | '0';

OR : '||' ;
AND : '&&' ;
EQUAL_EQUAL : '==' ;
NOT_EQUAL : '!=' ;
LT : '<' ;
GT : '>' ;
LE : '<=' ;
GE : '>=' ;
ADD : '+' ;
SUB : '-' ;
MUL : '*' ;
DIV : '/' ;
MOD : '%' ;
LPAREN : '(' ;
RPAREN : ')' ;

WS : (' ' | '\t' | '\r'| '\n') -> skip;