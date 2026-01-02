package AST;

public class ExprNode extends ASTNode {

    private String value;

    public ExprNode(String value, int line) {
        super("Expr", line);
        this.value = value;
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + "Expr: " + value + " (line " + line + ")");
    }
}
