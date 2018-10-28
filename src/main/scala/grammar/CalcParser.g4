parser grammar CalcParser;

options { tokenVocab=CalcLexer; }

logicalVar: (TRUE | FALSE);

mainExpr: expr;

expr
 : LPAR expr RPAR                     #InParentheses
 | <assoc=right> expr op=POW expr     #BinOp
 | op=SUB expr                        #UnaryOp
 | op=NOT expr                        #UnaryOp
 | expr op=(MUL | DIV | MOD) expr     #BinOp
 | expr op=(ADD | SUB) expr           #BinOp
 | expr op=(LE | GE | LT | GT) expr   #BinOpLogic
 | expr op=(EQ | NEQ) expr            #BinOpLogic
 | expr op=(AND | OR) expr            #BinOpLogic
 | logicalVar                         #Logic
 | NUMBER                             #Number
 ;

