grammar Calc;

@header {
    import ru.hse.spb.ast.*;
}

expression
    :    n=Number # ConstExpr
    |    '(' expression ')' # ParenthesisedExpr
    |    x=expression s=('*'|'/'|'%') y=expression # BinOpExpr
    |    x=expression s=('+'|'-') y=expression # BinOpExpr
    |    x=expression s=('<='|'>='|'<'|'>') y=expression # BinOpExpr
    |    x=expression s=('=='|'!=') y=expression # BinOpExpr
    |    x=expression s='&&' y=expression # BinOpExpr
    |    x=expression s='||' y=expression # BinOpExpr
    ;

Number
    :    ('1'..'9')('0'..'9')*|'0'
    ;

WS : [ \t\r\n]+ -> skip;
