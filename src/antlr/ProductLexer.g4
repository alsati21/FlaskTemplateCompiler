lexer grammar ProductLexer;

// ====================
// كلمات Flask / Python
// ====================
FROM        : 'from';
IMPORT      : 'import';
FLASK       : 'flask';
FLASK_KW    : 'Flask';
RENDER_STR  : 'render_template_string';
APP         : 'app';
DEF         : 'def';
RETURN      : 'return';
RUN         : 'app.run';
DEBUG       : 'debug=True';

// ====================
// كلمات تحكم
// ====================
IF      : 'if';
REQUEST : 'request';
METHOD  : 'method';
FORM    : 'form';
INT     : 'int';

// ====================
// أسماء متغيرات
// ====================
PRODUCTS        : 'products';
PRODUCT         : 'product';
HTML_TEMPLATE   : 'html_template';
NEW_PRODUCT     : 'new_product';
PRODUCTS_APPEND : 'products.append';

// ====================
// رموز
// ====================
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

// ====================
// قيم
// ====================
STRING  : '"' (~["\r\n])* '"';
NUMBER  : [0-9]+;
TRIPLE_STRING : '"""' .*? '"""';

// ====================
// معرفات
// ====================
DUUNDER_NAME : '__name__';
ID           : [a-zA-Z_][a-zA-Z0-9_]*;

// ====================
// تجاهل الفراغات
// ====================
WS : [ \t\r\n]+ -> skip;
