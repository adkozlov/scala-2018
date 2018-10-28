grammar Exp;

expression
    : left=andExp ('||' right+=andExp)*;

andExp
    : left=equalsExp ('&&' right+=equalsExp)*;

equalsExp
    : left=compareExp (op=('=='|'!=') right=compareExp)*;

compareExp
    : left=plusExp (op=('>'|'<'|'>='|'<=') right=plusExp)*;

plusExp
    : left=multExp (op+=('+'|'-') right+=multExp)*;

multExp
    : left=literal (op+=('*'|'/'|'%') right+=literal)*;

literal
    : Literal
    | '(' expression ')';


Literal
    : ([1-9] [0-9]* | '0')
    ;

WS
    : (' ' | '\t' | '\r'| '\n') -> skip
    ;