parser grammar CalculatorParser;

options { tokenVocab=CalculatorLexer; }

expr: andExpr (OR andExpr)*;
andExpr: eqExpr (AND eqExpr)*;
eqExpr: compExpr (EQ compExpr)*;
compExpr: plusExpr (COMP plusExpr)*;
plusExpr: multExpr (SUM multExpr)*;
multExpr: atom (MULT atom)*;
atom: INT | LPAREN expr RPAREN;