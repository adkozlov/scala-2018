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

expr returns [double value]
    :   e=logicalOr {$value = $e.value;}
    ;

// Precedence: 12
logicalOr returns [double value]
    :   e=logicalAnd {$value = $e.value;}
        (   '||' e=logicalAnd {$value = ($value == 0 ? false : true)
                               || ($e.value == 0 ? false : true)
                               ? 1 : 0;}
        )*
    ;

// Precedence: 11
logicalAnd returns [double value]
    :   e=equality {$value = $e.value;}
        (   '&&' e=equality {$value = ($value == 0 ? false : true)
                             && ($e.value == 0 ? false : true)
                             ? 1 : 0;}
        )*
    ;

// Precedence: 7
equality returns [double value]
    :   e=relational {$value = $e.value;}
        (   '==' e=relational {$value = $value == $e.value ? 1 : 0;}
        |   '!=' e=relational {$value = $value != $e.value ? 1 : 0;}
        )*
    ;

// Precedence: 6
relational returns [double value]
    :   e=additive {$value = $e.value;}
        (   '<=' e=additive {$value = $value <= $e.value ? 1 : 0;}
        |   '>=' e=additive {$value = $value >= $e.value ? 1 : 0;}
        |   '>' e=additive {$value = $value > $e.value ? 1 : 0;}
        |   '<' e=additive {$value = $value < $e.value ? 1 : 0;}
        )*
    ;

// Precedence: 4
additive returns [double value]
    :   e=multiplicative {$value = $e.value;}
        (   '+' e=multiplicative {$value += $e.value;}
        |   '-' e=multiplicative {$value -= $e.value;}
        )*
    ;

// Precedence: 3
multiplicative returns [double value]
    :   e=atom {$value = $e.value;}
        (   '*' e=atom {$value *= $e.value;}
        |   '/' e=atom {$value /= $e.value;}
        |   '%' e=atom {$value %= $e.value;}
        )*
        ;

atom returns [double value]
    :   DOUBLE {$value = Double.parseDouble($DOUBLE.text);}
    |   '(' e=expr ')' {$value = $e.value;}
    ;

DOUBLE :   ('-')?[0-9]+('.'[0-9]+)? ;
NEWLINE:'\r'? '\n' ;
WS  :   (' '|'\t')+ {skip();} ;
