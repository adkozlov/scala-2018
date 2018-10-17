grammar Calc;

expression
    : logicExpr
    | intExpr
    ;

logicExpr
    : logicOrExpr
    | '(' SPACES* logicExpr SPACES* ')'
    ;

intExpr
    : additionExp
    | '(' SPACES* intExpr SPACES* ')'
    ;

// -------------------------- logic --------------------------

logicOrExpr
    : var=logicAndExpr (SPACES* '||' SPACES* vars+=logicAndExpr)*
    ;

logicAndExpr
    : var=atomLogicExpr (SPACES* '&&' SPACES* vars+=atomLogicExpr)*
    ;

atomLogicExpr
    : value=equalityExpr
    | constValue=BoolLiteral
    | '(' SPACES* exp=logicOrExpr SPACES* ')'
    ;

equalityExpr
    : var1=intExpr SPACES* op=(EQUAL | NOT_EQUAL | LT | LE | GT | GE) SPACES* var2=intExpr
    ;

// ------------------------ arithmetic ------------------------

additionExp
    : var=multiplyExp (SPACES* ops+=(PLUS | MINUS) SPACES* vars+=multiplyExp)*
    ;

multiplyExp
    : var=atomExp (SPACES* ops+=(MULT | DIV | MOD) SPACES* vars+=atomExp)*
    ;

atomExp
    : n=Literal
    | '(' SPACES* exp=intExpr SPACES* ')'
;

BoolLiteral
    : TRUE
    | FALSE
    ;

TRUE
    : 'true'
    ;

FALSE
    : 'false'
    ;

fragment Digit
    : [0-9]
    ;

Literal
    : '-'? '0'
    | '-'? [1-9] Digit*
    ;

PLUS
    : '+'
    ;

MINUS
    : '-'
    ;

MULT
    : '*'
    ;

DIV
    : '/'
    ;

MOD
    : '%'
    ;

EQUAL
    : '=='
    ;

NOT_EQUAL
    : '!='
    ;

GT
    : '>'
    ;

GE
    : '>='
    ;

LT
    : '<'
    ;

LE
    : '<='
    ;

AND
    : '&&'
    ;

OR
    : '||'
    ;

NEWLINE
    : [\r\n]+
    ;

SPACES
    : ' '+
    ;