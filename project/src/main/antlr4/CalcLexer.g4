lexer grammar CalcLexer;

Number : ('0'..'9')+ ('.' ('0'..'9')+)?
    ;

WS : (' ' | '\t' | '\r'| '\n') -> skip;

Add : '+' | '-';
Mul : '*' | '/';
LB : '(';
RB : ')';