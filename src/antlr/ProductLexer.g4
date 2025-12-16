lexer grammar ProductLexer;

// -------- Keywords --------
FROM        : 'from';
IMPORT      : 'import';
FLASK       : 'flask';
FLASK_KW    : 'Flask';
RENDER_STR  : 'render_template_string';
REQUEST     : 'request';
APP         : 'app';
DEF         : 'def';
RETURN      : 'return';
RUN         : 'app.run';
DEBUG       : 'debug=True';

IF          : 'if';
METHOD      : 'method';
FORM        : 'form';
INT         : 'int';
METHODS     : 'methods';

// -------- HTTP --------
GET         : '"GET"';
POST        : '"POST"';

// -------- Names --------


// -------- Symbols --------
AT      : '@';
EQEQ    : '==';
EQ      : '=';
LP      : '(';
RP      : ')';
LBRACK  : '[';
RBRACK  : ']';
LBRACE  : '{';
RBRACE  : '}';
COLON   : ':';
COMMA   : ',';
DOT     : '.';

// -------- Types --------
STRING        : '"' (~["\r\n])* '"';
NUMBER        : [0-9]+;
TRIPLE_STRING : '"""' .*? '"""';

// -------- Identifiers --------
DUUNDER_NAME : '__name__';
ID           : [a-zA-Z_][a-zA-Z0-9_]*;


// -------- Skip --------
WS : [ \t\r\n]+ -> skip;
