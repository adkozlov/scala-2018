grammar Expressions;

expression             : logicalExpression EOF
                       | arithmeticExpression EOF;

logicalExpression      : LPAREN nested=logicalExpression RPAREN                                        #NestedLogical
                       | left=logicalExpression op=AND right=logicalExpression                         #And
                       | left=logicalExpression op=XOR right=logicalExpression                         #Xor
                       | left=logicalExpression op=OR right=logicalExpression                          #Or
                       | left=logicalExpression op=(EQ | NEQ) right=logicalExpression                  #EqLogical
                       | left=arithmeticExpression op=(LT | LEQ | GT | GEQ) right=arithmeticExpression #Comp
                       | left=arithmeticExpression op=(EQ | NEQ) right=arithmeticExpression            #EqArithmetic
                       | op=NOT operand=logicalExpression                                              #Not
                       | BOOL                                                                          #Bool;

arithmeticExpression   : LPAREN nested=arithmeticExpression RPAREN                                     #NestedArithmetic
                       | op=(PLUS | MINUS) operand=arithmeticExpression                                #Unary
                       | left=arithmeticExpression op=(MULT | DIV) right=arithmeticExpression          #Mult
                       | left=arithmeticExpression op=(PLUS | MINUS) right=arithmeticExpression        #Add
                       | NUMBER                                                                        #Number;

WS     : [ \t\n\r] -> skip;

LPAREN : '(';
RPAREN : ')';
DOT    : '.';

PLUS   : '+';
MINUS  : '-';
MULT   : '*';
DIV    : '/';

LT     : '<';
LEQ    : '<=';
GT     : '>';
GEQ    : '>=';
EQ     : '==';
NEQ    : '!=';

AND    : '&&';
OR     : '||';
XOR    : '^';
NOT    : '!';

NUMBER  : Positive FloatingPart? ScientificPart? | FloatingPart ScientificPart?;
BOOL    : 'true' | 'false';

fragment Positive : ZeroDigit | (DigitWithoutZero Digit*);

fragment ZeroDigit : [0];

fragment DigitWithoutZero : [1-9];

fragment Digit : [0-9] ;

fragment Digits : Digit*;

fragment FloatingPart : DOT Digits?;

fragment ScientificPart : [Ee] Sign? Positive;

fragment Sign : ('+'|'-');

/**
    Any illegal symbol will be accepted by lexer as MismatchedSymbol token.
    Therefore, lexer cannot produce errors while handling given expression,
    but parser will do it
*/
MismatchedSymbol: . ;