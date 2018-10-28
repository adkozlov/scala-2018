grammar Calculator;

input
   : lexpression EOF
   | expression EOF
   ;

lexpression
   : latom
   | expression relop expression
   | lexpression OR lexpression
   | lexpression AND lexpression
   | NOT lexpression
   | TRUE
   | FALSE
   ;

expression
   : term
   | expression PLUS term
   | expression MINUS term
   ;

term
   : factor
   | term TIMES factor
   | term DIV factor
   ;

factor
   : signedAtom
   | factor POW signedAtom
   ;

signedAtom
   : MINUS atom
   | atom
   ;

atom
   : LPAREN expression RPAREN
   | NUMBER
   ;

latom
   : LPAREN lexpression RPAREN
   ;


relop
   : EQ
   | GT
   | GEQ
   | LT
   | LEQ
   ;

NUMBER
   : ('0' .. '9') + ('.' ('0' .. '9') +)?
   ;

LPAREN
   : '('
   ;

RPAREN
   : ')'
   ;

PLUS
   : '+'
   ;

MINUS
   : '-'
   ;

TIMES
   : '*'
   ;

DIV
   : '/'
   ;

POW
   : '^'
   ;

GT
   : '>'
   ;

GEQ
   : '>='
   ;

LT
   : '<'
   ;

LEQ
   : '<='
   ;

EQ
   : '='
   ;

AND
   : '&&'
   ;

OR
   : '||'
   ;

NOT
   : '!'
   ;

TRUE
   : 'true'
   ;

FALSE
   : 'false'
   ;

WS
   : [ \r\n\t] + -> skip
   ;
