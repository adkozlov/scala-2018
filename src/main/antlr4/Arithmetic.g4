grammar Arithmetic;

arithmeticExpression
   : head=mathTerm (ops+=(PLUS | MINUS) rest+=mathTerm)*
   ;

mathTerm
   : head=signedAtom (ops+=(TIMES | DIV) rest+=signedAtom)*
   ;

signedAtom
   : PLUS signedAtom
   | MINUS signedAtom
   | mathAtom
   ;

mathAtom
   : NUMBER                                 #numberAtom
   | LPAREN arithmeticExpression RPAREN     #atomInParens
   ;

//The integer part gets its potential sign from the signedAtom rule

NUMBER
   : ('0' .. '9') + ('.' ('0' .. '9') +)?
   ;


fragment SIGN
   : ('+' | '-')
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


POINT
   : '.'
   ;


WS
   : [ \r\n\t] + -> skip
;
