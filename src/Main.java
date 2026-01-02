import AST.*;
import antlr.*;
import org.antlr.v4.runtime.*;
import visitior.ASTBuilder;
import symbol_table.SymbolTable;

import static org.antlr.v4.runtime.CharStreams.fromFileName;

public class Main {
    public static void main(String[] args) throws Exception {
        String urlFile = "src/tests/product_";
        String code = urlFile+"details.txt";

        CharStream input = fromFileName(code);
        ProductLexer lexer = new ProductLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ProductParser parser = new ProductParser(tokens);

        ASTBuilder builder = new ASTBuilder();
        ASTNode ast = builder.visit(parser.start());

        System.out.println("=== AST ===");
        ast.print("");


    }
}
