grammar Calculator;

eval
    : doubleExpression
    | booleanExpression
    ;

doubleExpression
    : atomDouble
    | <assoc=left> left=doubleExpression (op='*' | op ='/') right=doubleExpression
    | <assoc=left> left=doubleExpression (op='+' | op ='-') right=doubleExpression
    ;

booleanExpression
    : atomBoolean
    | booleanCompare
    | left=booleanExpression (op='==' | op='!=') right=booleanExpression
    | left=booleanExpression (op='&&' | op='||') right=booleanExpression
    ;

booleanCompare
    : left=doubleExpression (op='>=' | op='<=' | op='==' | op='!=' | op='>' | op='<') right=doubleExpression
    ;

atomDouble
    : number
    | bracedDoubleExpression
    ;

number: n=NUMBER;
bracedDoubleExpression: '(' exp=doubleExpression ')';

atomBoolean
    : bool
    | bracedBooleanExpression
    ;

bool: b=BOOLEAN;
bracedBooleanExpression: '(' exp=booleanExpression ')';


NUMBER:    [0-9]+('.'[0-9]*)?;
BOOLEAN: 'true' | 'false' | 'TRUE' | 'FALSE' ;

WS : (' ' | '\t') -> skip;