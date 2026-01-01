package AST;

public class CssBlockNode extends ASTNode {

    public CssBlockNode(int line) {
        super("CssBlock", line);
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + "CssBlock (line " + line + ")");
        for (ASTNode child : children)
            child.print(indent + "  ");
    }
}
