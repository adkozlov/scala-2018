/**
 * As basis was taken code example from official ANTLR documentation:
 * http://www.antlr3.org/works/help/tutorial/calculator.html
 * Precedence was taken into account according to Java Oracle documentation:
 * https://docs.oracle.com/javase/tutorial/java/nutsandbolts/operators.html
 **/

grammar Calculator;

@header {
package ru.hse.spb.jvm.scala;
}

expr
    : logicalOr
    ;

logicalOr
    : leftOperand=logicalAnd (operator='||' rightOperand=logicalOr)?
    ;

logicalAnd
    : leftOperand=equality (operator='&&' rightOperand=logicalAnd)?
    ;

equality
    : leftOperand=relational (operator=('==' | '!=') rightOperand=equality)?
    ;

relational
    : leftOperand=additive (operator=('>=' | '<=' | '>' | '<') rightOperand=relational)?
    ;

additive
    : leftOperand=multiplicative (operator=('+' | '-') rightOperand=additive)?
    ;

multiplicative
    : leftOperand=atom (operator=('*' | '/' | '%') rightOperand=multiplicative)?
;

atom
    :   DOUBLE #visitDouble
    |   '(' expr ')' #visitExpressionInBraces
    ;

DOUBLE :   ('-')?[0-9]+('.'[0-9]+)? ;
NEWLINE:'\r'? '\n' ;
WS  :   (' '|'\t')+ {skip();} ;
