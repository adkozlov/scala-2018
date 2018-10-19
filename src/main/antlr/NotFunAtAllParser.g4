parser grammar NotFunAtAllParser;

options { tokenVocab=NotFunAtAllLexer; }

bool_literal
    : TRUE
    | FALSE;

logical_expr
    : left=logical_expr op=logical_op right=logical_expr #LogicalBinaryExpr
    | left=arithm_expr op=compare_op right=arithm_expr #LogicalCompareExpr
    | LPAREN logical_expr RPAREN #LogicalParensExpr
    | bool_literal #LogicalAtomExpr;

atom
    : INT_NUM;

logical_op: AND | OR;
compare_op: EQUAL | NOTEQUAL | GREATER | GREQUAL | LESS | LEQUAL;

plumin: PLUS | MINUS;
divast: DIVISION | ASTERISK;

arithm_expr : left=arithm_expr op=divast right=arithm_expr #ArithmeticDABinaryExpr
            | left=arithm_expr op=plumin right=arithm_expr #ArithmeticPMBinaryExpr
            | LPAREN arithm_expr RPAREN #ArithmeticParensExpr
            | atom #ArithmeticAtomExpr;

binary_expr
    : logical_expr
    | arithm_expr;