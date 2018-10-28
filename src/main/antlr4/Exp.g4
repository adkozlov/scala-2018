grammar Exp;

expression
    :       '(' innerExpression=expression ')'
        |   left=expression (operation=MULT | operation=DIVIDE) right=expression
        |   left=expression (operation=MODULO) right=expression
        |   left=expression (operation=PLUS | operation=MINUS) right=expression
        |   left=expression (operation=GREATER | operation=LOWER | operation=GEQ | operation=LEQ) right=expression
        |   left=expression (operation=EQ | operation=NEQ) right=expression
        |   left=expression (operation=AND | operation=EQ) right=expression
        |   boolLiteral=BOOL_LITERAL
        |   literal=LITERAL
     ;

PLUS
    :    '+'
    ;

MINUS
    :    '-'
    ;

MULT
    :    '*'
    ;

DIVIDE
    :    '/'
    ;

MODULO
    :    '%'
    ;

GREATER
    :    '>'
    ;

LOWER
    :    '<'
    ;

GEQ
    :    '>='
    ;

LEQ
    :    '<='
    ;

EQ
    :    '=='
    ;

NEQ
    :    '!='
    ;

OR
    :    '||'
    ;

AND
    :    '&&'
    ;

BOOL_LITERAL
    : 'true' | 'false'
    ;

LITERAL
    :    '(-' NUMBER ')' | NUMBER
    ;

NUMBER
    : ('1'..'9')(('0'..'9')*)|'0'
    ;

WS
    : (' ' | '\t' | '\r'| '\n') -> skip
    ;