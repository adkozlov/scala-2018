grammar ExprGrammar;

expression : arithmeticExpression  #arithmetic
    | booleanExpression            #boolean;

arithmeticExpression : NUMBER | '(' inner = arithmeticExpression ')'
    | left = arithmeticExpression operator = (MUL | DIV | MOD) right = arithmeticExpression
    | left = arithmeticExpression operator = (PLUS | MINUS) right = arithmeticExpression;

booleanExpression : booleanAtom
    | left = booleanExpression operator = AND right = booleanExpression
    | left = booleanExpression operator = OR right = booleanExpression;

booleanAtom :
    | literal = ('true' | 'false')
    | '!' negated = booleanAtom
    | '(' inner = booleanExpression ')';

NUMBER : ('-')?[1-9][0-9]* | '0';
MUL    : '*';
DIV    : '/';
MOD    : '%';
PLUS   : '+';
MINUS  : '-';
AND    : '&&';
OR     : '||';
SPACE  : (' ' | '\r' | '\t' | '\n')+ -> skip;