grammar ExprGrammar;

parse : expression EOF;

expression : (NUMBER | BOOL_LITERAL | '(' inner = expression ')')
    | left = expression operator = ('*' | '/' | '%') right = expression
    | left = expression operator = ('+' | '-') right = expression
    | left = expression operator = ('<' | '<=' | '>' | '>=') right = expression
    | left = expression operator = ('==' | '!=') right = expression
    | left = expression operator = '&&' right = expression
    | left = expression operator = '||' right = expression;

NUMBER          : ('-')?[1-9][0-9]* | '0';
BOOL_LITERAL    : 'true' | 'false';
SPACE           : (' ' | '\r' | '\t' | '\n')+ -> skip;