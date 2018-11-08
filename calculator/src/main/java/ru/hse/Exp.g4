grammar Exp;

@header {package ru.hse;}

expression
    : orExpression EOF;

atomExpression
    : boolLiteral
    | intLiteral
    | expressionWithBraces
    ;

expressionWithBraces : '(' orExpression ')';

intLiteral : IntLiteral;

boolLiteral : BoolLiteral;

orExpression
    : orExpression OrOp andExpression
    | andExpression
    ;

andExpression
    : andExpression AndOp relationalExpression
    | relationalExpression
    ;

relationalExpression
    : relationalExpression RelationalOp additiveExpression
    | additiveExpression
    ;

additiveExpression
    : additiveExpression AdditiveOp multiplicativeExpression
    | multiplicativeExpression
    ;

multiplicativeExpression
    : multiplicativeExpression MultiplicativeOp atomExpression
    | atomExpression
    ;

MultiplicativeOp : '*' | '/' | '%' ;

AdditiveOp : '+' | '-' ;

RelationalOp : '>' | '<' | '>=' | '<=' | '==' | '!=' ;

AndOp : '&&' ;

OrOp : '||' ;

BoolLiteral : 'true' | 'false';

IntLiteral : '0' | '-' ? [1-9] [0-9] *;

WS : ( '//'.*?'\n' | ' ' | '\t' | '\r' | '\n' ) -> skip;