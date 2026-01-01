package AST;

public class HtmlIfNode extends ASTNode {

    private ASTNode condition;

    public HtmlIfNode(ASTNode condition, int line) {
        super("HtmlIf", line);
        this.condition = condition;
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + "HtmlIf");
        System.out.println(indent + "  Condition:");
        condition.print(indent + "    ");

        System.out.println(indent + "  Body:");
        children.forEach(c -> c.print(indent + "    "));
    }
}
