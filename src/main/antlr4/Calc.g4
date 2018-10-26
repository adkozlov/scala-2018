grammar Calc;

@header {
    import ru.hse.spb.ast.*;
}

expression returns [Expr value]
    :    literal
         { $value = new Const($literal.value); }
    |    '(' expression ')'
         { $value = $expression.value; }
    |    x=expression s=('*'|'/'|'%') y=expression
         { $value = new BinOp($s.text, $x.value, $y.value); }
    |    x=expression s=('+'|'-') y=expression
         { $value = new BinOp($s.text, $x.value, $y.value); }
    |    x=expression s=('<='|'>='|'<'|'>') y=expression
         { $value = new BinOp($s.text, $x.value, $y.value); }
    |    x=expression s=('=='|'!=') y=expression
         { $value = new BinOp($s.text, $x.value, $y.value); }
    |    x=expression s='&&' y=expression
         { $value = new BinOp($s.text, $x.value, $y.value); }
    |    x=expression s='||' y=expression
         { $value = new BinOp($s.text, $x.value, $y.value); }
    ;

literal returns [int value]
    :    n=Number {$value = Integer.parseInt($n.text);}
    ;

Number
    :    ('1'..'9')('0'..'9')*|'0'
    ;

WS : [ \t\r\n]+ -> skip;
