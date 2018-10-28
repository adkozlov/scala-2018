lexer grammar CalcLexer;

WS: [ \t\n]+ -> skip ;

NUMBER: ('0' .. '9') + ('.' ('0' .. '9') +)?;

TRUE: 'true';
FALSE: 'false';

ADD: '+';
SUB: '-';
MUL: '*';
DIV: '/';
MOD: '%';
POW: '^';

EQ: '==';
NEQ: '!=';
LT: '<';
LE: '<=';
GT: '>';
GE: '>=';
OR: '||';
AND: '&&';
NOT: '!';

LPAR: '(';
RPAR: ')';
