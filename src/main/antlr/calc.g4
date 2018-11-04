grammar calc;

input returns [double value]
    : setVar NL input {$value = 0.0;}    # ToSetVar
    | pom=plusOrMinus NL? EOF {$value = $pom.value;} # Calculate
    ;

setVar
    : ID EQUAL plusOrMinus # SetVariable
    ;


plusOrMinus returns [double value]
    : p=plusOrMinus PLUS m=multOrDiv {$value = $p.value + $m.value;}# Plus
    | p2=plusOrMinus MINUS m2=multOrDiv {$value = $p2.value - $m2.value;}# Minus
    | m3=multOrDiv {$value = $m3.value;}                  # ToMultOrDiv
    ;

multOrDiv returns [double value]
    : m=multOrDiv MULT p=pow {$value = $m.value * $p.value;}# Multiplication
    | m=multOrDiv DIV p=pow  {$value = $m.value / $p.value;}# Division
    | p=pow                {$value = $p.value;}# ToPow
    ;

pow returns [double value]
    : u=unaryMinus {$value = $u.value;}# SimplePow
    | u=unaryMinus (POW p=pow) {$value = Math.pow($u.value, $p.value);}# ComplexPow
    ;

unaryMinus returns [double value]
    : MINUS u=unaryMinus {$value = -$u.value;}# ChangeSign
    | a=atom {$value = $a.value;}            # ToAtom
    ;

atom returns [double value]
    : d=DOUBLE {$value = Double.parseDouble($d.text);}               # Double
    | i=INT {$value = Double.parseDouble($i.text);}                  # Int
    | LPAR p=plusOrMinus RPAR {$value = $p.value;}# Braces
    ;

INT    : [0-9]+;
DOUBLE : [0-9]+'.'[0-9]+;
PI     : 'pi';
E      : 'e';
POW    : '^';
NL     : '\n';
WS     : [ \t\r]+ -> skip;
ID     : [a-zA-Z_][a-zA-Z_0-9]*;

PLUS  : '+';
EQUAL : '=';
MINUS : '-';
MULT  : '*';
DIV   : '/';
LPAR  : '(';
RPAR  : ')';