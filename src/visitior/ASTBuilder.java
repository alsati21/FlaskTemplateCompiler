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
        ImportNode node = new ImportNode(ctx.start.getLine());

        if (ctx.importItems() != null) {
            for (var item : ctx.importItems().importItem()) {
                String name = item.getText();
                node.addChild(new IdentifierNode(name, ctx.start.getLine()));
                globalScope.insert(name);
            }
        }

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
        DataBlockNode node = new DataBlockNode(ctx.start.getLine());

        if (ctx.addBlock() != null)
            node.addChild(visit(ctx.addBlock()));
        else if (ctx.dictAssign() != null)
            node.addChild(visit(ctx.dictAssign()));

        return node;
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
        ASTNode node = new ASTNode("DictAssign", ctx.start.getLine());

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
        HtmlTagNode node = new HtmlTagNode("HtmlTag", ctx.start.getLine());

        if (ctx.singleTag() != null)
            ctx.singleTag().forEach(t -> node.addChild(visit(t)));

        if (ctx.fortemplete() != null)
            ctx.fortemplete().forEach(f -> node.addChild(visit(f)));

        if (ctx.if_statment() != null)
            ctx.if_statment().forEach(i -> node.addChild(visit(i)));

        if (ctx.bodyCSS() != null)
            ctx.bodyCSS().forEach(c -> node.addChild(visit(c)));

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
        if (ctx.EQ() != null) {
            ASTNode left = visit(ctx.target());
            ASTNode right = visit(ctx.expr());

            if (left instanceof IdentifierNode id)
                globalScope.insert(id.getName());

            return new AssignmentNode(left, right, ctx.start.getLine());
        }
        return visit(ctx.expr());
    }

    @Override
    public ASTNode visitTarget(ProductParser.TargetContext ctx) {
        return new IdentifierNode(ctx.getText(), ctx.start.getLine());
    }

    @Override
    public ASTNode visitLiteral(ProductParser.LiteralContext ctx) {
        return new LiteralNode(ctx.getText(), ctx.start.getLine());
    }

    @Override
    public ASTNode visitReturnStmt(ProductParser.ReturnStmtContext ctx) {
        ReturnNode node = new ReturnNode(ctx.start.getLine());
        node.addChild(visit(ctx.expr(0)));
        return node;
    }
}
