package AST;

public class AssignmentNode extends ASTNode {

    public AssignmentNode(ASTNode left, ASTNode right, int line) {
        super("Assignment", line);
        addChild(left);
        addChild(right);
    }
}
