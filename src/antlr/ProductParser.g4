parser grammar ProductParser;

options { tokenVocab=ProductLexer; }

/* ---------- Start ---------- */
start
    : file EOF
    ;

/* ---------- File ---------- */
file
    : importStmt+ appInit dataBlock* htmlTemplate? routeDef* runStmt?
    ;

/* ---------- Imports ---------- */
importStmt
    : FROM FLASK IMPORT importItems     #flaskImport
    | IMPORT importJsItems              #jsImport
    ;

importItems
    : importItem (COMMA importItem)*
    ;

importItem
    : FLASK_KW        #importFlask
    | RENDER_STR     #importRenderStr
    | RENDER_TMP     #importRenderTmp
    | REQUEST        #importRequest
    | ID             #importId
    ;

importJsItems
    : ID (COMMA LBRACE ID RBRACE FROM STRING)? #jsImportItems
    ;

/* ---------- App Initialization ---------- */
appInit
    : APP EQ FLASK_KW LP DUUNDER_NAME RP #appInitialization
    ;

/* ---------- Data Blocks ---------- */
dataBlock
    : addBlock                          #addDataBlock
    | dictAssign                       #dictDataBlock
    | ID EQ literal SEMICOLON          #simpleAssignBlock
    | ID EQ LBRACE productFields RBRACE        #namedDict

    ;

addBlock
    : ID EQ LBRACK (dictAssign (COMMA dictAssign)*)? RBRACK #listAddBlock
    ;

dictAssign
    : LBRACE productFields RBRACE              #anonymousDict
    | ID                                        #name
    ;

productFields
    : field (COMMA field)*
    ;

field
    : STRING COLON expr                #fieldAssign
    ;

/* ---------- HTML / Template ---------- */
singleTag
    : OPENTAG (FORM|ID) ((METHOD|ID) EQ STRING)* (ID)* CLOSETAG #singleHtmlTag
    ;

closeSingleTag
    : OPENTAG DIV (FORM|ID) CLOSETAG #closeHtmlTag
    ;

id_id
    : ID MINUS ID   #rangeId
    | ID            #singleId
    ;

bodyCSS
    : DOT? (id_id COLON)? (id_id)+
      LBRACE
        ( id_id COLON ((ID|NUMBER|HANDRED|HASH|LP|RP|FLOAT_NUM|COMMA)* (COMMA id_id)?) SEMICOLON )*
      RBRACE
      #cssBody
    ;

jinjatemplete
    : LBRACE LBRACE ID (DOT ID)* RBRACE RBRACE #jinjaExpression
    ;

elseElif
    : LBRACE HANDRED (ELIF|ELSE) (ID|IN)* HANDRED RBRACE #elseElifBlock
    ;

if_statment
    : LBRACE HANDRED IF (ID|IN)* HANDRED RBRACE
      (htmlTag | elseElif | fortemplete)*
      LBRACE HANDRED ENDIF HANDRED RBRACE
      #ifStatement
    ;

htmlTag
    : singleTag+                                                  #simpleHtml
    | (singleTag ((STRING|ID|COLON|EQ|SDOLAR|fortemplete
                  |if_statment|jinjatemplete|bodyCSS)* closeSingleTag)*)
                  #complexHtml
    ;

fortemplete
    : LBRACE HANDRED FOR (ID|IN)* HANDRED RBRACE
      (htmlTag|singleTag)*
      LBRACE HANDRED ENDFOR (ID|IN)* HANDRED RBRACE
      #forTemplate
    ;

valueHtmlL
    : (DOCTYPE | htmlTag)* #htmlValueList
    ;

htmlTemplate
    : ID EQ TRIPLE_STRING valueHtmlL TRIPLE_STRING #htmlTemplateAssign
    ;

/* ---------- Routes ---------- */
routeDef
    : AT APP DOT ROUTE LP STRING
      (COMMA METHODS EQ LBRACK STRING (COMMA STRING)* RBRACK)?
      RP
      DEF ID LP paramList? RP COLON routeBody+
       #routeDefinition
    ;

paramList
    : ID (COMMA ID)* #parameterList
    ;

routeBody
    : (statement | formHandler | returnStmt)+ #routeBodyBlock
    ;

returnStmt
    : RETURN (RENDER_STR | RENDER_TMP)
      LP expr (COMMA ID EQ expr)* RP
      #returnStatement
    ;

formHandler
    : IF requestMethodIsPost COLON statement+ returnStmt #formHandlerBlock
    ;

requestMethodIsPost
    : REQUEST DOT METHOD EQEQ STRING #postMethodCheck
    ;

/* ---------- Statements ---------- */
statement
    : target EQ expr     #assignmentStatement
    | expr               #expressionStatement
    ;

target
    : ID                       #simpleTarget
    | ID LBRACK COLON RBRACK   #sliceTarget
    | ID LBRACK expr RBRACK    #indexTarget
    ;

/* ---------- Expressions ---------- */
expr
    : literal                             #literalExpr
    | (ID | REQUEST | INT | ID) suffix* #accessExpr
    | dictLiteral                         #dictExpr
    | listLiteral                         #listExpr
    | listComprehension                   #listCompExpr
    | jsInstruction                       #jsExpr
    ;

literal
    : STRING                     #stringLiteral
    | STRING_LITERAL             #stringLiteral2
    | NUMBER                     #numberLiteral
    | FLOAT_NUM                  #floatLiteral
    | DECIMAL_INTEGER_LITERAL    #decimalLiteral
    | TRUE                       #trueLiteral
    | FALSE                      #falseLiteral
    | NULL                       #nullLiteral
    ;

suffix
    : DOT (ID | REQUEST | FORM | METHOD | ID)  #dotSuffix
    | LBRACK (STRING | NUMBER) RBRACK                  #indexSuffix
    | LP (expr (COMMA expr)*)? RP                      #callSuffix
    ;

dictLiteral
    : LBRACE productFields RBRACE #dictLiteralExpr
    ;

listLiteral
    : LBRACK exprList? RBRACK #listLiteralExpr
    ;

exprList
    : expr (COMMA expr)* #expressionList
    ;

/* ---------- List Comprehension ---------- */
listComprehension
    : LBRACK compFor RBRACK #listComprehensionExpr
    ;

compFor
    : expr FOR ID IN ID (IF compCond)? #comprehensionFor
    ;

compCond
    : leftOperand comparator rightOperand #comprehensionCondition
    ;

leftOperand
    : ID                                   #leftId
    | ID LBRACK STRING RBRACK              #leftIndex
    | (ID | REQUEST | INT) (suffix)+       #leftAccess
    ;

rightOperand
    : expr #rightExpr
    ;

comparator
    : EQEQ #equalsComparator
    | NEQ  #notEqualsComparator
    ;

/* ---------- Run ---------- */
runStmt
    : APP DOT RUNKW LP runArgs? RP                     #directRun
    | IF mainCheck COLON APP DOT RUNKW LP runArgs? RP  #guardedRun
    ;

mainCheck
    : DUUNDER_NAME EQEQ STRING #mainCheckExpr
    ;

runArgs
    : arg (COMMA arg)* #runArguments
    ;

arg
    : ID EQ expr #runArgument
    ;

/* ---------- JS / JSX ---------- */
jsInstruction
    : function_declaration   #jsFunctionDeclaration
    | function_call          #jsFunctionCall
    | variabe                #jsVariable
    | return_js              #jsReturn
    ;

function_declaration
    : FUNCTION ID function_body #functionDeclaration
    ;

function_body
    : LP (ID (COMMA ID)*)? RP
      ARROW LBRACE instruction_js* RBRACE   #arrowFunction
    | LP (ID (COMMA ID)*)? RP
      LBRACE instruction_js* RBRACE         #normalFunction
    ;

instruction_js
    : function_call SEMICOLON? #jsCallInstruction
    | variabe SEMICOLON?       #jsVarInstruction
    | return_js SEMICOLON?     #jsReturnInstruction
    | expr SEMICOLON?          #jsExprInstruction
    ;

return_js
    : RETURN expr #returnJs
    ;

function_call
    : ID LP (expr (COMMA expr)*)? RP #functionCall
    ;

variabe
    : (CONST | LET | VAR)? ID EQ expr #variableAssign
    | (CONST | LET | VAR)? ID         #variableDeclare
    ;
