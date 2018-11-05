parser grammar CalcParser;

options { tokenVocab=CalcLexer; }

eval : additionExp;

additionExp : multiplyExp (Add multiplyExp)*
    ;

multiplyExp : atomExp (Mul atomExp)*;

atomExp : Number | LB additionExp RB;