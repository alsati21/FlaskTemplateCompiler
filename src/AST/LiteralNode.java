package AST;

public class LiteralNode extends ASTNode {

    private String value;

    public LiteralNode(String value, int line) {
        super("Literal", line);
        this.value = value;
    }

    @Override
    protected void print(String indent, boolean last) {
        System.out.print(indent);
        System.out.print(last ? "└── " : "├── ");
        System.out.println(nodeName + " : " + value + " (line " + line + ")");
    }
}
