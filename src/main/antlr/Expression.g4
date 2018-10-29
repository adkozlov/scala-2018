grammar Expression;

expression
    : num=NUMBER
    | bool=BOOLEAN
    | '(' innerExpression=expression ')'
    | left=expression op=OPERATOR1 right=expression
    | left=expression op=OPERATOR2 right=expression
    | left=expression op=OPERATOR3 right=expression
    | left=expression op=OPERATOR4 right=expression
    | left=expression op=OPERATOR5 right=expression
    | left=expression op=OPERATOR6 right=expression
    ;

OPERATOR1
    : MUL | DIV | MOD;
OPERATOR2
    : PLUS | MINUS;
OPERATOR3
    : LESS_THAN | GREATER_THAN | LE | GE;
OPERATOR4
    : EQ | NEQ;
OPERATOR5
    : AND;
OPERATOR6
    : OR;

// precedence = 1
MUL : '*';
DIV : '/';
MOD : '%';
// precedence = 2
PLUS : '+';
MINUS : '-';
// precedence = 3
LESS_THAN : '<';
GREATER_THAN : '>';
LE : '<=';
GE : '>=';
// precedence = 4
EQ : '==';
NEQ : '!=';
// precedence = 5
AND : '&&';
// precedence = 6
OR : '||';


NUMBER: ('0'..'9')+;
BOOLEAN: 'true' | 'false';

WS
    : [ \t\r\n]+ -> skip
    ;