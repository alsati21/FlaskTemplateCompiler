lexer grammar ProductLexer;

// ---------- Python / Flask ----------
FROM : 'from';
IMPORT : 'import';
AS : 'as';
FLASK : 'flask';
FLASK_KW : 'Flask';
RENDER_STR : 'render_template_string';
RENDER_TMP : 'render_template';
REQUEST : 'request';
APP : 'app';
ROUTE : 'route';
DEF : 'def';
RETURN : 'return';
RUNKW : 'run';
IF : 'if';
ENDIF : 'endif';

ELSE : 'else';
ELIF : 'elif';
FOR : 'for';
ENDFOR : 'endfor';
//ENDFOR|ELIF|ELSE|ENDIF

IN : 'in';
METHOD : 'method';
FORM : 'form';
INT : 'int';
FLOAT : 'float';
STR : 'str';
BOOL : 'bool';
METHODS : 'methods';

// ---------- JS/React ----------
FUNCTION: 'function';
EXPORT: 'export';
DEFAULT: 'default';
CONST: 'const';
LET: 'let';
VAR: 'var';
NULL: 'null';
TRUE: 'true';
FALSE: 'false';
SDOLAR :'$';

// ---------- Symbols ----------
AT : '@';
EQEQ : '==';
NEQ : '!=';
EQ : '=';
PLUS : '+';
MINUS : '-';
STAR : '*';
DIV : '/';
LP : '(';
RP : ')';
LBRACK : '[';
RBRACK : ']';
LBRACE : '{';
RBRACE : '}';
COMMA : ',';
DOT : '.';
EXCL : '!';
SEMICOLON: ';';
ARROW: '=>';
COLON : ':';

// ---------- Comparison ----------
IS_EQUAL_TYPE: '===';
NOT_EQUAL_TYPE: '!==';
LESS_EQUAL: '<=';
GRETER_EQUAL: '>=' ;
AND: '&&';
OR: '||';
HANDRED :'%';
HASH :'#';

// ---------- Triple-quoted string ----------
TRIPLE_STRING : '"""' ;

// ---------- Comments / WS ----------
LINE_COMMENT_PY : '~' ~[\r\n]* -> skip;
LINE_COMMENT_JS: '//' ~[\r\n]* -> skip;
BLOCK_COMMENT: '/*' .*? '*/' -> skip;
WS : [ \t\r\n]+ -> skip;

// ---------- Numbers ----------
FLOAT_NUM : [0-9]+ '.' [0-9]+ ;
NUMBER : [0-9]+ ;
DECIMAL_INTEGER_LITERAL: [1-9][0-9]* | '0';
FLOAT_LITERAL: [0-9]*'.'[0-9]+;

// ---------- Strings ----------
STRING : '"' (~["\r\n])* '"' ;
STRING_LITERAL : '"' ( '\\' . | ~["\\\r\n] )* '"' ;
TEMPLATE_LITERAL : '`' ( '\\' . | ~[`\\\r\n] )* '`' ;

// ---------- Identifiers ----------
DUUNDER_NAME : '__name__' ;
DOCTYPE: '<!DOCTYPE html>' ;


OPENTAG:'<' ;
CLOSETAG:'>';

//-> pushMode(HTML_TEXT_MODE)

ID : [a-zA-Z_][a-zA-Z0-9_]* ;
IDENTIFIER: [a-zA-Z_][a-zA-Z0-9_]* ;
// ---------- Misc ----------
NEWLINE : '\r'? '\n' ;


fragment ESC: '\\' [btnfr"'\\`];

mode HTML_TEXT_MODE ;
HTML_WS: [ \t\r\n]+ -> skip;
HTML_TEXT : (ESC | ~[<>(){}])+;
