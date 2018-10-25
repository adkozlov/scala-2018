parser grammar CalcParser;

options { tokenVocab=CalcLexer; }

expression
    : operationUnit                             # operationUnitExpr
    | LPAREN expression RPAREN                  # paranthesisExpr
    | expression op=(MULT | DIV | MOD) expression # multExpr
    | expression op=(ADD | SUB) expression      # additiveExpr
    | expression op=(EQUAL | NOTEQUAL | LE | GE | LT | GT) expression # comparisonExpr
    | expression op=(AND | OR) expression       # boolExpr
    ;

operationUnit
    : LITERAL     # unitLiteral
    ;
