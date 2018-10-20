grammar Arithmetic;

expression
   : head=term (ops+=(PLUS | MINUS) rest+=term)*
   ;

term
   : head=signedAtom (ops+=(TIMES | DIV) rest+=signedAtom)*
   ;

signedAtom
   : PLUS signedAtom
   | MINUS signedAtom
   | atom
   ;

atom
   : NUMBER                     #numberAtom
   | LPAREN expression RPAREN   #atomInParens
   ;

number
    : NUMBER
    ;

//relop
//   : EQ
//   | GT
//   | LT
//   ;


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


GT
   : '>'
   ;


LT
   : '<'
   ;


EQ
   : '='
   ;


POINT
   : '.'
   ;


WS
   : [ \r\n\t] + -> skip
;
