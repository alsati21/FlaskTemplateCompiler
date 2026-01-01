import AST.*;
import antlr.*;
import org.antlr.v4.runtime.*;
import visitior.ASTBuilder;
import symbol_table.SymbolTable;

import static org.antlr.v4.runtime.CharStreams.fromFileName;

public class Main {
    public static void main(String[] args) throws Exception {

        String code = "src/tests/product_details.txt";

        CharStream input = fromFileName(code);
        ProductLexer lexer = new ProductLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ProductParser parser = new ProductParser(tokens);

        ASTBuilder builder = new ASTBuilder();
        ASTNode ast = builder.visit(parser.start());

        System.out.println("=== AST ===");
        ast.print("");

        // طباعة محتويات الـ Symbol Table بعد بناء AST
        SymbolTable globalScope = builder.getGlobalScope();
        System.out.println("\n=== Symbol Table (Global Scope) ===");
        globalScope.print("");
        System.out.println("=== End of Symbol Table ===\n");
    }
}
