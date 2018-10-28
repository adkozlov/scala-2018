grammar Exp;

expression
    :    operation=('-' | '!') expression
    |    expression operation=('*' | '/' | '%') expression
    |    expression operation=('+' | '-') expression
    |    expression operation=('>' | '<' | '>=' | '<=') expression
    |    expression operation=('==' | '!=') expression
    |    expression operation='&&' expression
    |    expression operation='||' expression
    |    '(' expression ')'
    |    Literal
    ;

Literal
    :    [1-9] [0-9]*
    |    'true'
    |    'false'
    |    '0'
    ;

WS : (' ' | '\t' | '\r'| '\n') -> skip;