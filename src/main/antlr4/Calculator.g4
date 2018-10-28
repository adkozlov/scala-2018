grammar Calculator;

expression
    : logicExpression                                                   # logic
    | arithmeticExpression                                              # arithmetic
;

arithmeticExpression
   : multiplierExpression
   ;

logicExpression
    : disjunctionExpression
    ;

multiplierExpression
    : left=multiplierExpression op=(PLUS | MINUS) right=multiplierExpression    #multiplier
    | addendExpression                                                          #atomMultiplier
    ;

addendExpression
    : left=addendExpression op=(MULT | DIV) right=addendExpression      #addend
    | signedArithmeticAtom                                              #atomAddend
    ;

disjunctionExpression
    : left=disjunctionExpression OR right=disjunctionExpression         #disjunction
    | conjunctionExpression                                             #atomDisjunction
    ;

conjunctionExpression
    : left=conjunctionExpression AND right=conjunctionExpression        #conjunction
    | logicAtom                                                         #atomConjunction
    ;

signedArithmeticAtom
   : sign=(PLUS | MINUS) signedArithmeticAtom                           #signedAtom
   | arithmeticAtom                                                     #simpleAtom
;

arithmeticAtom
    : NUMBER                                                            #numberArithmeticAtom
    | LBracket arithmeticExpression RBracket                            #arithmeticAtomWithBrackets
;

logicAtom
   : literal=(TRUE | FALSE)                                             #literalLogicAtom
   | NOT logicAtom                                                      #negatedLogicAtom
   | LBracket logicExpression RBracket                                  #logicAtomWithBrackets
   ;

NUMBER
    : ('0' .. '9') + (POINT ('0' .. '9') +)?
    ;

TRUE
    : 'true'
    ;

FALSE
    : 'false'
    ;

WS
    :   [ \t\r\n]+ -> skip
    ;

LBracket
    : '('
    ;

RBracket
    : ')'
    ;

POINT
    : '.'
    ;

PLUS
    : '+'
    ;

MINUS
    : '-'
    ;

MULT
    : '*'
    ;

DIV
    : '/'
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
