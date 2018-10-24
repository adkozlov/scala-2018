grammar a;


expr returns [int res]
  : e = or { $res = $e.res; }
  ;

or returns [int res]
  : and                 { $res  = $and.res; }
    (
      '||' and          { $res = ($res == 1) || ($and.res == 1) ? 1 : 0; }
    )*
  ;

and returns [int res]
  : equals              { $res  = $equals.res; }
    (
      '&&' equals       { $res = ($res == 0) || ($equals.res == 0) ? 0 : 1; }
    )*
  ;

equals returns [int res]
  : compare              { $res  = $compare.res; }
    (
      '==' compare       { $res = ($res == $compare.res) ? 1 : 0; } |
      '!=' compare       { $res = ($res != $compare.res) ? 1 : 0; }
    )*
  ;

compare returns [int res]
  : plus             { $res  = $plus.res; }
    (
      '<' plus       { $res = ($res  < $plus.res) ? 1 : 0; } |
      '>' plus       { $res = ($res  > $plus.res) ? 1 : 0; } |
      '<=' plus      { $res = ($res <= $plus.res) ? 1 : 0; } |
      '>=' plus      { $res = ($res >= $plus.res) ? 1 : 0; }
    )*
  ;

plus returns [int res]
  : mult             { $res  = $mult.res; }
    (
      '+' mult       { $res += $mult.res; } |
      '-' mult       { $res -= $mult.res; }
    )*
  ;

mult returns [int res]
  : unary             { $res  = $unary.res; }
    (
      '*' unary       { $res *= $unary.res; } |
      '%' unary       { $res %= $unary.res; } |
      '/' unary       { $res /= $unary.res; }
    )*
  ;

unary returns [int res]
  : primary           { $res =     $primary.res; }
  | '-' unary         { $res =   - $unary.res; }
  | '!' unary         { $res = 1 - $unary.res; }
  ;

primary returns [int res]
  : NUM                 { $res = $NUM.int;  }
  | 'true'              { $res = 1;         }
  | 'false'             { $res = 0;         }
  | LBRACE expr RBRACE  { $res = $expr.res; }
  ;


NUM : [0-9]+ ;
LBRACE : '(' ;
RBRACE : ')' ;
WS  : [ \t\r\n]+ -> skip ;
