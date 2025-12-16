parser grammar ProductParser;

options { tokenVocab=ProductLexer; }

file
    : importStmt
      appInit
      (addBlock | detailsBlock)
      htmlTemplate
      routeDef
      runStmt
      EOF
    ;

// -------- import --------
importStmt
    : FROM FLASK IMPORT FLASK_KW COMMA RENDER_STR (COMMA REQUEST)?
    ;

// -------- app = Flask(__name__) --------
appInit
    : APP EQ FLASK_KW LP DUUNDER_NAME RP
    ;

// -------- products = [] --------
addBlock
    : ID EQ LBRACK  detailsBlock  RBRACK
    ;

// -------- product = { ... } --------
detailsBlock
    :  (LBRACE productFields RBRACE )
    ;

productFields
    : field (COMMA field)*
    ;

field
    : STRING COLON (STRING | NUMBER)
    ;

// -------- html_template --------
htmlTemplate
    : ID  EQ TRIPLE_STRING

    ;

// -------- @app.route --------
routeDef
    : AT APP DOT ID LP STRING (COMMA METHODS EQ LBRACK GET COMMA POST RBRACK)? RP
      DEF ID LP RP COLON
      routeBody
    ;

// -------- body --------
routeBody
    : formHandler
    | RETURN RENDER_STR LP ID COMMA ID EQ ID RP
    | RETURN RENDER_STR LP ID RP
    | RETURN RENDER_STR LP ID RP
    ;

// -------- if POST --------
formHandler
    : IF REQUEST DOT METHOD EQEQ POST COLON
      ID EQ LBRACE formFields RBRACE
      ID DOT ID LP ID RP
      RETURN RENDER_STR LP ID RP
    ;

// -------- form fields --------
formFields
    : formField (COMMA formField)*
    ;

formField
    : STRING COLON
      ( REQUEST DOT FORM LBRACK STRING RBRACK
      | INT LP REQUEST DOT FORM LBRACK STRING RBRACK RP
      )
    ;

// -------- run --------
runStmt
    : RUN LP DEBUG RP
    ;
