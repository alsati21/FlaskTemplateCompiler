parser grammar ProductParser;

options { tokenVocab=ProductLexer; }

start
    : file EOF
    ;

file
    : importStmt+ appInit dataBlock* htmlTemplate? routeDef* runStmt?
    ;

/* ---------- Imports ---------- */
importStmt
    : FROM FLASK IMPORT importItems
    | IMPORT importJsItems
    ;

importItems
    : importItem (COMMA importItem)*
    ;

importItem
    : FLASK_KW
    | RENDER_STR
    | RENDER_TMP
    | REQUEST
    | ID
    ;

importJsItems
    : IDENTIFIER (COMMA LBRACE IDENTIFIER RBRACE FROM STRING)?
    ;

/* ---------- App Initialization ---------- */
appInit
    : APP EQ FLASK_KW LP DUUNDER_NAME RP
    ;

/* ---------- Data Blocks ---------- */
dataBlock
    : addBlock
    | dictAssign
    ;

addBlock
    : ID EQ LBRACK (dictAssign (COMMA dictAssign)*)? RBRACK
    ;

dictAssign
    : LBRACE productFields RBRACE
    | ID EQ LBRACE productFields RBRACE
    ;

productFields
    : field (COMMA field)*
    ;

field
    : STRING COLON expr
    ;

/* ---------- HTML Template كسلسلة فقط ---------- */
    singleTag : OPENTAG (FORM|ID) ((METHOD|ID) EQ STRING)* (ID)* CLOSETAG;
    closeSingleTag : OPENTAG DIV (FORM|ID) CLOSETAG;
     id_id: (ID MINUS ID)|ID;
     //idHand:ID HANDRED;
    bodyCSS : DOT? (id_id COLON)? (id_id)+ LBRACE( id_id COLON ( (ID|NUMBER|HANDRED|HASH|LP|RP|FLOAT_NUM|COMMA)* ( COMMA id_id)?)  SEMICOLON)* RBRACE;
jinjatemplete :
LBRACE LBRACE ID(DOT ID)* RBRACE RBRACE
;
elseElif : LBRACE HANDRED (ELIF|ELSE) (ID|IN)*  HANDRED  RBRACE;

if_statment :LBRACE HANDRED (IF) (ID|IN)*  HANDRED  RBRACE  (htmlTag | elseElif|fortemplete)*   LBRACE HANDRED (ENDIF)  HANDRED  RBRACE ;

htmlTag :
  singleTag+
  |(singleTag  ((
  STRING
  |ID
  |COLON
  |EQ
  |SDOLAR
  |fortemplete
  |if_statment
  |jinjatemplete
    |bodyCSS

  )*  closeSingleTag)*)
 ;

fortemplete :
  LBRACE HANDRED (FOR) (ID|IN)*  HANDRED  RBRACE (htmlTag|singleTag)* LBRACE HANDRED (ENDFOR) (ID|IN)*  HANDRED  RBRACE
  ;

valueHtmlL :
(
 DOCTYPE
  |htmlTag

 )*
;

htmlTemplate
    : ID EQ TRIPLE_STRING valueHtmlL TRIPLE_STRING
    ;



/* ---------- Route Definition ---------- */
routeDef
    : AT APP DOT ROUTE LP STRING (COMMA METHODS EQ LBRACK STRING (COMMA STRING)* RBRACK)? RP
      DEF ID LP paramList? RP COLON routeBody+
    ;

paramList
    : ID (COMMA ID)*
    ;

routeBody
    : (statement | formHandler | returnStmt)+
    ;

returnStmt
    : RETURN (RENDER_STR | RENDER_TMP) LP expr (COMMA ID EQ expr)* RP
    ;

formHandler
    : IF requestMethodIsPost COLON statement+ returnStmt
    ;

requestMethodIsPost
    : REQUEST DOT METHOD EQEQ STRING
    ;

statement
    : target EQ expr
    | expr
    ;

target
    : ID
    | ID LBRACK COLON RBRACK
    | ID LBRACK expr RBRACK
    ;

/* ---------- Expressions ---------- */
expr
    : literal
    | (ID | REQUEST | INT | IDENTIFIER) (suffix)*
    | dictLiteral
    | listLiteral
    | listComprehension
    | jsInstruction
    ;

literal
    : STRING
    | STRING_LITERAL
    | NUMBER
    | FLOAT_NUM
    | DECIMAL_INTEGER_LITERAL
    | FLOAT_LITERAL
    | TRUE
    | FALSE
    | NULL
    ;

suffix
    : DOT (ID | REQUEST | FORM | METHOD | IDENTIFIER)
    | LBRACK (STRING | NUMBER) RBRACK
    | LP (expr (COMMA expr)*)? RP
    ;

dictLiteral
    : LBRACE productFields RBRACE
    ;

listLiteral
    : LBRACK exprList? RBRACK
    ;

exprList
    : expr (COMMA expr)*
    ;

/* ---------- List comprehension ---------- */
listComprehension
    : LBRACK compFor RBRACK
    ;

compFor
    : expr FOR ID IN ID (IF compCond)?
    ;

compCond
    : leftOperand comparator rightOperand
    ;

leftOperand
    : ID
    | ID LBRACK STRING RBRACK
    | (ID | REQUEST | INT) (suffix)+
    ;

rightOperand
    : expr
    ;

comparator
    : EQEQ
    | NEQ
    ;

/* ---------- Run Statement ---------- */
runStmt
    : APP DOT RUNKW LP runArgs? RP
    | IF mainCheck COLON APP DOT RUNKW LP runArgs? RP
    ;

mainCheck
    : DUUNDER_NAME EQEQ STRING
    ;

runArgs
    : arg (COMMA arg)*
    ;

arg
    : ID EQ expr
    ;

/* ---------- JS / JSX ---------- */
jsInstruction
    : function_declaration
    | function_call
    | variabe
    | return_js
    ;

function_declaration
    : FUNCTION IDENTIFIER function_body
    ;

function_body
    : LP (IDENTIFIER (COMMA IDENTIFIER)*)? RP
      ( ARROW LBRACE (instruction_js)* RBRACE
      | LBRACE (instruction_js)* RBRACE )
    ;

instruction_js
    : function_call SEMICOLON?
    | variabe SEMICOLON?
    | return_js SEMICOLON?
    | expr SEMICOLON?
    ;

return_js
    : RETURN expr
    ;

function_call
    : IDENTIFIER LP (expr (COMMA expr)*)? RP
    ;

variabe
    : (CONST | LET | VAR)? (IDENTIFIER) (EQ expr)?
    ;
