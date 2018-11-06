lexer grammar CalcLexer;

LITERAL:            (('-'?) [0-9] (Digits?));

// Separators
LPAREN:             '(';
RPAREN:             ')';

// Whitespace
WS:                 (' ' | '\t' | '\n')+    -> channel(HIDDEN);

// Operators
ADD:                '+';
SUB:                '-';
MULT:               '*';
DIV:                '/';
MOD:                '%';
GT:                 '>';
LT:                 '<';
LE:                 '<=';
GE:                 '>=';
EQUAL:              '==';
NOTEQUAL:           '!=';
AND:                '&&';
OR:                 '||';

fragment Digits
    : [0-9] ([0-9_]* [0-9])?
    ;
