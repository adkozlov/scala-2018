grammar Calculator;

statement
   : expression EOF
   ;

expression
     :  orExp | atomExp
     ;

OrOperation
      : '||'
      ;

AndOperation
     : '&&'
     ;

ComparOperation
      : '<' | '>' | '==' | '!=' | '>=' | '<='
      ;

MultiplyOperation
      : '*' | '/' | '%'
      ;

AdditionOperation
      : '+' | '-'
      ;

orExp
    : andExp (OrOperation andExp)*
    ;


andExp
    : comparExp (AndOperation comparExp)*
    ;

comparExp
    : additionExp (ComparOperation additionExp)*
    ;

additionExp
    : multiplyExp (AdditionOperation multiplyExp)*
    ;

multiplyExp
    : atomExp (MultiplyOperation atomExp)*
    ;


atomExp
     : integerExp |  doubleExp | booleanExp | surroundedExpression
     ;

surroundedExpression
     : '(' expression ')'
     ;

doubleExp
     :
     Double
     ;

integerExp
      :
      Integer
      ;

booleanExp
      :
      Boolean
      ;

Integer
     : '0' | ('-')?('1'..'9')(('0'..'9')*)
     ;

Double
    :    ('-')?('0'..'9')+ ('.' ('0'..'9')+)
    ;

Boolean
    : 'true' | 'false'
    ;

WS : (' ' | '\t' | '\r'| '\n') -> skip;
