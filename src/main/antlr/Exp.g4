grammar Exp;

calc
    : exp=expr EOF
    ;

expr :
    num=Number |
    neg_num=negative_Number |
    '(' exp=expr ')' |
    left=expr op=(MUL|DEL) right=expr |
    left=expr op=(SUM|MUN) right=expr |
    left=expr op=(EQ|NEQ|LEQ|GEQ|GR|LE) right=expr |
    left=expr op=(OR|AND) right=expr
    ;

negative_Number :
    '(-' num=Number ')'
    ;

MUL : '*';
DEL : '/';
SUM : '+';
MUN : '-';
EQ  : '==';
NEQ : '!=';
LE  : '<';
GR  : '>';
LEQ : '<=';
GEQ : '>=';
OR  : '||';
AND : '&&';

Number :
    ('1'..'9')('0'..'9')* | '0'
    ;

WS : (' ' | '\t' | '\r'| '\n') -> skip;