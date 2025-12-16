parser grammar ProductParser;

options { tokenVocab=ProductLexer; }

file
    : importStmt
      appInit
      detailsBlock
      htmlTemplate
      routeDef
      runStmt
      EOF
    ;

// --------------------
// from flask import ...
// --------------------
importStmt
    : FROM FLASK IMPORT FLASK_KW COMMA RENDER_STR
    ;

// --------------------
// app = Flask(__name__)
// --------------------
appInit
    : APP EQ FLASK_KW LP DUUNDER_NAME RP
    ;

// --------------------
// product = { ... }
// --------------------
detailsBlock
    : PRODUCT EQ LBRACE productFields RBRACE
    ;

productFields
    : field (COMMA field)*
    ;

field
    : STRING COLON (STRING | NUMBER)
    ;

// --------------------
// html_template = """ ... """
// --------------------
htmlTemplate
    : HTML_TEMPLATE EQ TRIPLE_STRING
    ;

// --------------------
// @app.route("/")
// def product_details():
// --------------------
routeDef
    : AT APP DOT ID LP STRING RP
      DEF ID LP RP COLON
      routeBody
    ;

// --------------------
// return render_template_string(...)
// --------------------
routeBody
    : RETURN RENDER_STR LP HTML_TEMPLATE COMMA PRODUCT EQ PRODUCT RP
    ;

// --------------------
// app.run(debug=True)
// --------------------
runStmt
    : RUN LP DEBUG RP
    ;
