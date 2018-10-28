grammar Calculator;

calculator:
    ex=expression
    EOF;

expression:
      unOp=SUB ex=expression
    | <assoc=left> left=expression (op=MUL | op=DIV | op=MOD) right=expression
    | <assoc=left> left=expression (op=ADD | op=SUB) right=expression
    | left=expression (op=LT | op=LE | op=GT | op=GE) right=expression
    | left=expression (op=EQ | op=NE) right=expression
    | left=expression op=AND right=expression
    | left=expression op=OR right=expression
    | '(' ex=expression ')'
    | num=Number;

Number: '0'|('1'..'9')('0'..'9')*;

MUL: '*' ;
DIV: '/' ;
MOD: '%' ;
ADD: '+' ;
SUB: '-' ;
LT:  '<' ;
LE:  '<=';
GT:  '>' ;
GE:  '>=';
EQ:  '==';
NE:  '!=';
AND: '&&';
OR:  '||';

WHITESPACE : (' ' | '\t' | '\r'| '\n' | '//' (.)*? '\n') -> skip;