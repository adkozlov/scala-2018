grammar Exp;

expression
    : LITERAL | BOOL_LITERAL | '(' inBraces = expression ')'
    | left = expression
      operator = ('*'|'/'|'%')
      right = expression
    | left = expression
      operator = ('+'|'-')
      right = expression
    | left = expression
      operator = ('>'|'<'|'>='|'<=')
      right = expression
    | left = expression
      operator = ('=='|'!=')
      right = expression
    | left = expression
      operator = '&&'
      right = expression
    | left = expression
      operator = '||'
      right = expression
    ;

LITERAL
    : ('+'|'-')? [1-9] DIGIT* | '0'
    ;

BOOL_LITERAL
    : 'true' | 'false'
    ;

fragment DIGIT
    : [0-9]
    ;

WS: (' ' | '\t' | '\r'| '\n') -> skip;