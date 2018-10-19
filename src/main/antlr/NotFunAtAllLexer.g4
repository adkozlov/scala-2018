lexer grammar NotFunAtAllLexer;

fragment WS      : [\t ]+;
fragment NL      : '\r'? '\n'
        | '\r' ;

SKIP_: (WS | NL | EOF) -> skip;

fragment CR
        : '\r'
        ;

fragment LF
        : '\n'
        ;

/* OPERATORS */
/* ARITHMETIC */
PLUS    : '+';
MINUS   : '-';
ASTERISK: '*';
DIVISION: '/';
MOD     : '%';

/* COMPARE */
EQUAL   : '==';
NOTEQUAL: '!=';
GREATER : '>';
GREQUAL : '>=';
LESS    : '<';
LEQUAL  : '<=';

/* LOGICAL */
AND     : '&&';
OR      : '||';

/* DELIMITERS */
LPAREN  : '(' ;
RPAREN  : ')' ;

/* LITERALS */
INT_NUM : '-'? ('0' .. '9')+;
TRUE    : 'true';
FALSE   : 'false';


