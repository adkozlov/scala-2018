grammar Logic;

logicExpression
   : head=boolTerm (ops+=OR rest+=boolTerm)*
   ;

boolTerm
   : head=negatedBoolAtom (ops+=AND rest+=negatedBoolAtom)*
   ;

negatedBoolAtom
   : NOT negatedBoolAtom
   | boolAtom
   ;

boolAtom
   : literal=(TRUE|FALSE)                   #boolLiteralAtom
   | LPAREN logicExpression RPAREN          #boolAtomInParens
   ;

TRUE
    : 'true'
    ;

FALSE
    : 'false'
    ;

NOT
    : '!'
    ;

LPAREN
   : '('
   ;


RPAREN
   : ')'
   ;


OR
   : '||'
   ;


AND
   : '&&'
   ;

WS
   : [ \r\n\t] + -> skip
;
