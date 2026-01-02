package visitior;

import AST.*;
import antlr.ProductLexer;
import antlr.ProductParser;
import antlr.ProductParserBaseVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;
import symbol_table.SymbolTable;

public class ASTBuilder extends ProductParserBaseVisitor<ASTNode> {

    // Global Symbol Table
    private final SymbolTable globalScope = new SymbolTable();

    public SymbolTable getGlobalScope() {
        return globalScope;
    }

    // ================= START =================

    @Override
    public ASTNode visitStart(ProductParser.StartContext ctx) {
        ProgramNode program = new ProgramNode(ctx.start.getLine());

        ASTNode fileNode = visit(ctx.file());
        if (fileNode != null) program.addChild(fileNode);

        return program;
    }

    // ================= FILE =================

    @Override
    public ASTNode visitFile(ProductParser.FileContext ctx) {
        FileNode file = new FileNode(ctx.start.getLine());

        if (ctx.importStmt() != null)
            ctx.importStmt().forEach(i -> file.addChild(visit(i)));

        if (ctx.appInit() != null)
            file.addChild(visit(ctx.appInit()));

        if (ctx.dataBlock() != null)
            ctx.dataBlock().forEach(db -> file.addChild(visit(db)));

        if (ctx.htmlTemplate() != null)
            file.addChild(visit(ctx.htmlTemplate()));

        if (ctx.routeDef() != null)
            ctx.routeDef().forEach(r -> file.addChild(visit(r)));

        if (ctx.runStmt() != null)
            file.addChild(visit(ctx.runStmt()));

        return file;
    }

    // ================= IMPORT =================

    @Override
    public ASTNode visitImportStmt(ProductParser.ImportStmtContext ctx) {
        // Check which alternative was matched and dispatch to the appropriate method
        // Handles alternative labels: #flaskImport | #jsImport
        if (ctx.importItems() != null) {
            return visitFlaskImport(ctx);
        } else if (ctx.importJsItems() != null) {
            return visitJsImport(ctx);
        }
        return null;
    }

    // Specific visitor methods for import alternatives
    // Handles alternative label: #flaskImport
    public ASTNode visitFlaskImport(ProductParser.ImportStmtContext ctx) {
        ImportNode node = new ImportNode(ctx.start.getLine());

        if (ctx.importItems() != null) {
            for (var item : ctx.importItems().importItem()) {
                String name = item.getText();
                node.addChild(new IdentifierNode(name, ctx.start.getLine()));
                globalScope.insert(name);
            }
        }

        return node;
    }

    // Handles alternative label: #jsImport
    public ASTNode visitJsImport(ProductParser.ImportStmtContext ctx) {
        ImportNode node = new ImportNode(ctx.start.getLine());

        if (ctx.importJsItems() != null) {
            String name = ctx.importJsItems().getText();
            node.addChild(new IdentifierNode(name, ctx.start.getLine()));
            globalScope.insert(name);
        }

        return node;
    }

    // ================= APP INIT =================

    @Override
    public ASTNode visitAppInit(ProductParser.AppInitContext ctx) {
        return new ASTNode("AppInit", ctx.start.getLine()) {
            @Override
            public void print(String indent) {
                System.out.println(indent + nodeName + " : Flask(__name__)");
            }
        };
    }

    // ================= DATA BLOCK =================

    @Override
    public ASTNode visitDataBlock(ProductParser.DataBlockContext ctx) {
        // Check which alternative was matched and dispatch to the appropriate method
        // Handles alternative labels: #addDataBlock | #dictDataBlock | #simpleAssignBlock
        if (ctx.addBlock() != null) {
            return visitAddDataBlock(ctx);
        } else if (ctx.dictAssign() != null) {
            return visitDictDataBlock(ctx);
        } else {
            // For the simpleAssignBlock alternative: ID EQ literal SEMICOLON
            // Check if the context has the expected structure for this alternative
            if (ctx.getChildCount() >= 3) {
                // Check if it matches ID EQ literal pattern
                if (ctx.getChild(0) instanceof TerminalNode &&
                    ctx.getChild(1) != null && ctx.getChild(1).getText().equals("=") &&
                    ctx.getChild(2) != null) {
                    return visitSimpleAssignBlock(ctx);
                }
            }
        }
        return null;
    }

    // Specific visitor methods for dataBlock alternatives
    // Handles alternative label: #addDataBlock
    public ASTNode visitAddDataBlock(ProductParser.DataBlockContext ctx) {
        DataBlockNode node = new DataBlockNode(ctx.start.getLine());

        if (ctx.addBlock() != null)
            node.addChild(visit(ctx.addBlock()));

        return node;
    }

    // Handles alternative label: #dictDataBlock
    public ASTNode visitDictDataBlock(ProductParser.DataBlockContext ctx) {
        DataBlockNode node = new DataBlockNode(ctx.start.getLine());

        if (ctx.dictAssign() != null)
            node.addChild(visit(ctx.dictAssign()));

        return node;
    }

    // Handles alternative label: #simpleAssignBlock
    public ASTNode visitSimpleAssignBlock(ProductParser.DataBlockContext ctx) {
        // For the simpleAssignBlock alternative: ID EQ literal SEMICOLON
        // Need to find the literal in the children
        // Look for a child that is a LiteralContext
        TerminalNode idNode = null;
        ProductParser.LiteralContext literalCtx = null;

        for (int i = 0; i < ctx.getChildCount(); i++) {
            if (ctx.getChild(i) instanceof TerminalNode &&
                ((TerminalNode) ctx.getChild(i)).getSymbol().getType() == ProductLexer.ID) {
                idNode = (TerminalNode) ctx.getChild(i);
            } else if (ctx.getChild(i) instanceof ProductParser.LiteralContext) {
                literalCtx = (ProductParser.LiteralContext) ctx.getChild(i);
            }
        }

        if (idNode != null && literalCtx != null) {
            String idText = idNode.getText();
            AssignmentNode node = new AssignmentNode(
                new IdentifierNode(idText, ctx.start.getLine()),
                visit(literalCtx),
                ctx.start.getLine()
            );
            globalScope.insert(idText);
            return node;
        }
        return null;
    }

    @Override
    public ASTNode visitAddBlock(ProductParser.AddBlockContext ctx) {
        ASTNode node = new ASTNode("AddBlock", ctx.start.getLine());

        if (ctx.ID() != null) {
            globalScope.insert(ctx.ID().getText());
            node.addChild(new IdentifierNode(ctx.ID().getText(), ctx.start.getLine()));
        }

        if (ctx.dictAssign() != null)
            ctx.dictAssign().forEach(d -> node.addChild(visit(d)));

        return node;
    }

    @Override
    public ASTNode visitDictAssign(ProductParser.DictAssignContext ctx) {
        // Check which alternative was matched and dispatch to the appropriate method
        // Handles alternative labels: #anonymousDict | #namedDict
        if (ctx.ID() != null) {
            return visitNamedDict(ctx);
        } else {
            return visitAnonymousDict(ctx);
        }
    }

    // Specific visitor methods for dictAssign alternatives
    // Handles alternative label: #anonymousDict
    public ASTNode visitAnonymousDict(ProductParser.DictAssignContext ctx) {
        ASTNode node = new ASTNode("AnonymousDict", ctx.start.getLine());

        if (ctx.productFields() != null)
            node.addChild(visit(ctx.productFields()));

        return node;
    }

    // Handles alternative label: #namedDict
    public ASTNode visitNamedDict(ProductParser.DictAssignContext ctx) {
        ASTNode node = new ASTNode("NamedDict", ctx.start.getLine());

        if (ctx.ID() != null) {
            globalScope.insert(ctx.ID().getText());
            node.addChild(new IdentifierNode(ctx.ID().getText(), ctx.start.getLine()));
        }

        if (ctx.productFields() != null)
            node.addChild(visit(ctx.productFields()));

        return node;
    }

    @Override
    public ASTNode visitProductFields(ProductParser.ProductFieldsContext ctx) {
        ASTNode node = new ASTNode("ProductFields", ctx.start.getLine());
        ctx.field().forEach(f -> node.addChild(visit(f)));
        return node;
    }

    @Override
    public ASTNode visitField(ProductParser.FieldContext ctx) {
        ASTNode node = new ASTNode("Field", ctx.start.getLine());

        node.addChild(new LiteralNode(ctx.STRING().getText(), ctx.start.getLine()));
        node.addChild(visit(ctx.expr()));

        return node;
    }

    // ================= HTML =================

    @Override
    public ASTNode visitHtmlTemplate(ProductParser.HtmlTemplateContext ctx) {
        HtmlTemplateNode node = new HtmlTemplateNode(ctx.start.getLine());

        if (ctx.valueHtmlL() != null)
            ctx.valueHtmlL().children.forEach(c -> node.addChild(visit(c)));

        return node;
    }

    @Override
    public ASTNode visitHtmlTag(ProductParser.HtmlTagContext ctx) {
        // Check which alternative was matched and dispatch to the appropriate method
        // Handles alternative labels: #simpleHtml | #complexHtml
        // For simpleHtml: singleTag+
        // For complexHtml: singleTag ((STRING|ID|COLON|EQ|SDOLAR|fortemplete|if_statment|jinjatemplete|bodyCSS)* closeSingleTag)*
        if (ctx.fortemplete() != null || ctx.if_statment() != null || ctx.bodyCSS() != null || ctx.closeSingleTag() != null) {
            return visitComplexHtml(ctx);
        } else {
            return visitSimpleHtml(ctx);
        }
    }

    // Specific visitor methods for htmlTag alternatives
    // Handles alternative label: #simpleHtml
    public ASTNode visitSimpleHtml(ProductParser.HtmlTagContext ctx) {
        HtmlTagNode node = new HtmlTagNode("SimpleHtml", ctx.start.getLine());

        if (ctx.singleTag() != null)
            ctx.singleTag().forEach(t -> node.addChild(visit(t)));

        for (TerminalNode tn : ctx.getTokens(ProductLexer.ID)) {
            node.addChild(new HtmlTextNode(tn.getText(), tn.getSymbol().getLine()));
        }

        return node;
    }

    // Handles alternative label: #complexHtml
    public ASTNode visitComplexHtml(ProductParser.HtmlTagContext ctx) {
        HtmlTagNode node = new HtmlTagNode("ComplexHtml", ctx.start.getLine());

        if (ctx.singleTag() != null)
            ctx.singleTag().forEach(t -> node.addChild(visit(t)));

        if (ctx.fortemplete() != null)
            ctx.fortemplete().forEach(f -> node.addChild(visit(f)));

        if (ctx.if_statment() != null)
            ctx.if_statment().forEach(i -> node.addChild(visit(i)));

        if (ctx.bodyCSS() != null)
            ctx.bodyCSS().forEach(c -> node.addChild(visit(c)));

        if (ctx.closeSingleTag() != null)
            ctx.closeSingleTag().forEach(c -> node.addChild(visit(c)));

        for (TerminalNode tn : ctx.getTokens(ProductLexer.ID)) {
            node.addChild(new HtmlTextNode(tn.getText(), tn.getSymbol().getLine()));
        }

        return node;
    }

    // ================= FOR (Scope حقيقي) =================

    @Override
    public ASTNode visitFortemplete(ProductParser.FortempleteContext ctx) {

        globalScope.enterScope(); // ← Scope جديد

        String iterator = ctx.ID(0).getText();
        String iterable = ctx.ID(1).getText();

        globalScope.insert(iterator);

        HtmlForNode node = new HtmlForNode(iterator, iterable, ctx.start.getLine());

        if (ctx.htmlTag() != null)
            ctx.htmlTag().forEach(t -> node.addChild(visit(t)));

        globalScope.exitScope(); // ← نهاية Scope

        return node;
    }

    // ================= ROUTE (Scope حقيقي) =================

    @Override
    public ASTNode visitRouteDef(ProductParser.RouteDefContext ctx) {

        globalScope.insert(ctx.ID().getText()); // Global

        globalScope.enterScope(); // Route Scope

        RouteDefNode node =
                   new RouteDefNode(ctx.ID().getText(), ctx.start.getLine());

        ctx.routeBody().forEach(b -> node.addChild(visitRouteBody(b)));

        globalScope.exitScope();

        return node;
    }

    public ASTNode visitRouteBody(ProductParser.RouteBodyContext ctx) {
        ASTNode node = new ASTNode("RouteBody", ctx.start.getLine());

        if (ctx.statement() != null)
            ctx.statement().forEach(s -> node.addChild(visit(s)));

        if (ctx.formHandler() != null)
            ctx.formHandler().forEach(f -> node.addChild(visit(f)));

        if (ctx.returnStmt() != null)
            ctx.returnStmt().forEach(r -> node.addChild(visit(r)));

        return node;
    }

    // ================= FORM HANDLER (Scope حقيقي) =================

    @Override
    public ASTNode visitFormHandler(ProductParser.FormHandlerContext ctx) {

        globalScope.enterScope();

        ASTNode node = new ASTNode("FormHandler", ctx.start.getLine());

        ctx.statement().forEach(s -> node.addChild(visit(s)));
        node.addChild(visit(ctx.returnStmt()));

        globalScope.exitScope();

        return node;
    }

    // ================= STATEMENTS =================

    @Override
    public ASTNode visitStatement(ProductParser.StatementContext ctx) {
        // Check which alternative was matched and dispatch to the appropriate method
        // Handles alternative labels: #assignmentStatement | #expressionStatement
        if (ctx.EQ() != null) {
            return visitAssignmentStatement(ctx);
        } else {
            return visitExpressionStatement(ctx);
        }
    }

    // Specific visitor methods for statement alternatives
    // Handles alternative label: #assignmentStatement
    public ASTNode visitAssignmentStatement(ProductParser.StatementContext ctx) {
        ASTNode left = visit(ctx.target());
        ASTNode right = visit(ctx.expr());

        if (left instanceof IdentifierNode id)
            globalScope.insert(id.getName());

        return new AssignmentNode(left, right, ctx.start.getLine());
    }

    // Handles alternative label: #expressionStatement
    public ASTNode visitExpressionStatement(ProductParser.StatementContext ctx) {
        return visit(ctx.expr());
    }

    @Override
    public ASTNode visitTarget(ProductParser.TargetContext ctx) {
        // Check which alternative was matched and dispatch to the appropriate method
        // Handles alternative labels: #simpleTarget | #sliceTarget | #indexTarget
        // For simpleTarget: ID
        // For sliceTarget: ID LBRACK COLON RBRACK
        // For indexTarget: ID LBRACK expr RBRACK
        if (ctx.getChildCount() == 1 && ctx.getChild(0) instanceof TerminalNode) {
            // simpleTarget: ID
            return visitSimpleTarget(ctx);
        } else if (ctx.getChildCount() == 4) {
            // Either sliceTarget: ID LBRACK COLON RBRACK or indexTarget: ID LBRACK expr RBRACK
            if (ctx.getChild(2) instanceof TerminalNode && ctx.getChild(2).getText().equals(":")) {
                // sliceTarget: ID LBRACK COLON RBRACK
                return visitSliceTarget(ctx);
            } else {
                // indexTarget: ID LBRACK expr RBRACK
                return visitIndexTarget(ctx);
            }
        }
        return new IdentifierNode(ctx.getText(), ctx.start.getLine());
    }

    // Specific visitor methods for target alternatives
    // Handles alternative label: #simpleTarget
    public ASTNode visitSimpleTarget(ProductParser.TargetContext ctx) {
        // For simpleTarget: ID
        if (ctx.getChild(0) instanceof TerminalNode) {
            return new IdentifierNode(ctx.getChild(0).getText(), ctx.start.getLine());
        }
        return new IdentifierNode(ctx.getText(), ctx.start.getLine());
    }

    // Handles alternative label: #sliceTarget
    public ASTNode visitSliceTarget(ProductParser.TargetContext ctx) {
        // For sliceTarget: ID LBRACK COLON RBRACK
        if (ctx.getChild(0) instanceof TerminalNode) {
            return new IdentifierNode(ctx.getChild(0).getText(), ctx.start.getLine());
        }
        return new IdentifierNode(ctx.getText(), ctx.start.getLine());
    }

    // Handles alternative label: #indexTarget
    public ASTNode visitIndexTarget(ProductParser.TargetContext ctx) {
        // For indexTarget: ID LBRACK expr RBRACK
        if (ctx.getChild(0) instanceof TerminalNode) {
            return new IdentifierNode(ctx.getChild(0).getText(), ctx.start.getLine());
        }
        return new IdentifierNode(ctx.getText(), ctx.start.getLine());
    }

    @Override
    public ASTNode visitLiteral(ProductParser.LiteralContext ctx) {
        // Check which alternative was matched and dispatch to the appropriate method
        // Handles alternative labels: #stringLiteral | #stringLiteral2 | #numberLiteral | #floatLiteral | #decimalLiteral | #trueLiteral | #falseLiteral | #nullLiteral
        // Since literal alternatives are terminal tokens, check the first child
        if (ctx.getChild(0) instanceof TerminalNode) {
            TerminalNode token = (TerminalNode) ctx.getChild(0);
            int tokenType = token.getSymbol().getType();

            if (tokenType == ProductLexer.STRING) {
                return visitStringLiteral(ctx);
            } else if (tokenType == ProductLexer.STRING_LITERAL) {
                return visitStringLiteral2(ctx);
            } else if (tokenType == ProductLexer.NUMBER) {
                return visitNumberLiteral(ctx);
            } else if (tokenType == ProductLexer.FLOAT_NUM) {
                return visitFloatLiteral(ctx);
            } else if (tokenType == ProductLexer.DECIMAL_INTEGER_LITERAL) {
                return visitDecimalLiteral(ctx);
            } else if (tokenType == ProductLexer.TRUE) {
                return visitTrueLiteral(ctx);
            } else if (tokenType == ProductLexer.FALSE) {
                return visitFalseLiteral(ctx);
            } else if (tokenType == ProductLexer.NULL) {
                return visitNullLiteral(ctx);
            }
        }
        return new LiteralNode(ctx.getText(), ctx.start.getLine());
    }

    // Specific visitor methods for literal alternatives
    // Handles alternative label: #stringLiteral
    public ASTNode visitStringLiteral(ProductParser.LiteralContext ctx) {
        if (ctx.getChild(0) instanceof TerminalNode) {
            return new LiteralNode(ctx.getChild(0).getText(), ctx.start.getLine());
        }
        return new LiteralNode(ctx.getText(), ctx.start.getLine());
    }

    // Handles alternative label: #stringLiteral2
    public ASTNode visitStringLiteral2(ProductParser.LiteralContext ctx) {
        if (ctx.getChild(0) instanceof TerminalNode) {
            return new LiteralNode(ctx.getChild(0).getText(), ctx.start.getLine());
        }
        return new LiteralNode(ctx.getText(), ctx.start.getLine());
    }

    // Handles alternative label: #numberLiteral
    public ASTNode visitNumberLiteral(ProductParser.LiteralContext ctx) {
        if (ctx.getChild(0) instanceof TerminalNode) {
            return new LiteralNode(ctx.getChild(0).getText(), ctx.start.getLine());
        }
        return new LiteralNode(ctx.getText(), ctx.start.getLine());
    }

    // Handles alternative label: #floatLiteral
    public ASTNode visitFloatLiteral(ProductParser.LiteralContext ctx) {
        if (ctx.getChild(0) instanceof TerminalNode) {
            return new LiteralNode(ctx.getChild(0).getText(), ctx.start.getLine());
        }
        return new LiteralNode(ctx.getText(), ctx.start.getLine());
    }

    // Handles alternative label: #decimalLiteral
    public ASTNode visitDecimalLiteral(ProductParser.LiteralContext ctx) {
        if (ctx.getChild(0) instanceof TerminalNode) {
            return new LiteralNode(ctx.getChild(0).getText(), ctx.start.getLine());
        }
        return new LiteralNode(ctx.getText(), ctx.start.getLine());
    }

    // Handles alternative label: #trueLiteral
    public ASTNode visitTrueLiteral(ProductParser.LiteralContext ctx) {
        if (ctx.getChild(0) instanceof TerminalNode) {
            return new LiteralNode(ctx.getChild(0).getText(), ctx.start.getLine());
        }
        return new LiteralNode(ctx.getText(), ctx.start.getLine());
    }

    // Handles alternative label: #falseLiteral
    public ASTNode visitFalseLiteral(ProductParser.LiteralContext ctx) {
        if (ctx.getChild(0) instanceof TerminalNode) {
            return new LiteralNode(ctx.getChild(0).getText(), ctx.start.getLine());
        }
        return new LiteralNode(ctx.getText(), ctx.start.getLine());
    }

    // Handles alternative label: #nullLiteral
    public ASTNode visitNullLiteral(ProductParser.LiteralContext ctx) {
        if (ctx.getChild(0) instanceof TerminalNode) {
            return new LiteralNode(ctx.getChild(0).getText(), ctx.start.getLine());
        }
        return new LiteralNode(ctx.getText(), ctx.start.getLine());
    }

    @Override
    public ASTNode visitReturnStmt(ProductParser.ReturnStmtContext ctx) {
        ReturnNode node = new ReturnNode(ctx.start.getLine());
        node.addChild(visit(ctx.expr(0)));
        return node;
    }
}
