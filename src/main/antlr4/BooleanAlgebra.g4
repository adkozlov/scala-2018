grammar BooleanAlgebra;


booleanExpr
  : binaryOr | EOF
  ;

binaryOr
  : left=binaryAdd ('|' right=binaryOr)?     # binaryDisjunction
  ;

binaryAdd
  : left=unaryNot ('&' right=binaryAdd)?     # binaryConjunction
  ;

unaryNot
  : value=logicalAtom                        # unaryConst
  | '!' value=unaryNot                       # unaryNegation
  ;

logicalAtom
  : literal=(TRUE|FALSE)                     # booleanLiteral
  | '(' booleanExpr ')'                      # parenthesizedExpr
  ;


TRUE   : 'true';
FALSE  : 'false';
WS     : [ \t\r\n]+ -> skip;
