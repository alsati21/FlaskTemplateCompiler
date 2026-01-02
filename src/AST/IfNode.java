package AST;

public class IfNode extends ASTNode {

    private ASTNode condition;

    public IfNode(int line) {
        super("IfStatement", line);
    }

    public void setCondition(ASTNode condition) {
        this.condition = condition;
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + "IfStatement (line " + line + ")");

        // طباعة الشرط
        if (condition != null) {
            System.out.println(indent + "  Condition:");
            condition.print(indent + "    ");
        }

        // طباعة جسم الـ if
        if (!children.isEmpty()) {
            System.out.println(indent + "  Body:");
            for (ASTNode child : children) {
                child.print(indent + "    ");
            }
        }
    }
}
