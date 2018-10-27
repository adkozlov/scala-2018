grammar Calc;

@header{
package ru.hse.mit;
}

data: expression EOF;

expression
    :   binaryExpression
    |   Number
        LeftParen expression RightParen;

binaryExpression: logicalExp;

logicalExp: comparisonExp ((Or | And) comparisonExp)*;

comparisonExp: additionExp ((NotEquals
                           | IsEqual
                           | LessEqual
                           | GreaterEqual
                           | Less
                           | Greater) additionExp)?;

additionExp: multiplyExp ((Plus | Minus) multiplyExp)*;

multiplyExp: atomExp ((Mult | Div | Mod) atomExp)*;

atomExp:  Number | bool | LeftParen expression RightParen;

bool: True | False;

//////////////////////////////////////////////////////////////////////

True: 'true';
False: 'false';

LeftParen : '(';
RightParen : ')';

IsEqual: '==';
NotEquals: '!=';
Less : '<';
LessEqual : '<=';
Greater : '>';
GreaterEqual : '>=';

Plus: '+';
Minus: '-';
Mult : '*';
Div : '/';
Mod : '%';

Or: '||';
And: '&&';

Number: '0' | Minus? ('1'..'9') ('0'..'9')*;

WS : (' ' | '\t' | '\r'| '\n') -> skip;