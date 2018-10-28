grammar Calculator;

eval returns [String value]
    : dexp=doubleExpression {$value = Double.toString($dexp.value);}
    | bexp=booleanExpression {$value = $bexp.value ? "true" : "false";}
    ;

doubleExpression returns [double value]
    : atom=atomDouble {$value = $atom.value;}
    | <assoc=left> left=doubleExpression {$value = $left.value;}
        (
          '*' righta=atomDouble {$value *= $righta.value;}
        | '/' righta=atomDouble {$value /= $righta.value;}
        | '+' right=doubleExpression {$value += $right.value;}
        | '-' right=doubleExpression {$value -= $right.value;}
        )
    ;

booleanExpression returns [boolean value]
    : atom=atomBoolean {$value = $atom.value;}
    | leftd=doubleExpression
        (
          '>=' rightd=doubleExpression {$value = $leftd.value >= $rightd.value;}
        | '<=' rightd=doubleExpression {$value = $leftd.value <= $rightd.value;}
        | '==' rightd=doubleExpression {$value = $leftd.value == $rightd.value;}
        | '!=' rightd=doubleExpression {$value = $leftd.value != $rightd.value;}
        | '>' rightd=doubleExpression {$value = $leftd.value > $rightd.value;}
        | '<' rightd=doubleExpression {$value = $leftd.value < $rightd.value;}
        )
    | left=booleanExpression
        (
          '==' right=booleanExpression {$value = $left.value == $right.value;}
        | '!=' right=booleanExpression {$value = $left.value != $right.value;}
        )
    | left=booleanExpression '&&' right=booleanExpression {$value = $left.value && $right.value;}
    | left=booleanExpression '||' right=booleanExpression {$value = $left.value || $right.value;}
    ;



atomDouble returns [double value]
    : n=NUMBER              {$value = Double.parseDouble($n.text);}
    | '(' exp=doubleExpression ')' {$value = $exp.value;}
    ;

atomBoolean returns [boolean value]
    : b=BOOLEAN {$value = Boolean.parseBoolean($b.text);}
    | '(' exp=booleanExpression ')' {$value = $exp.value;}
    ;

NUMBER:    [0-9]+('.'[0-9]*)?;
BOOLEAN: 'true' | 'false' | 'TRUE' | 'FALSE' ;

WS : (' ' | '\t') -> skip;