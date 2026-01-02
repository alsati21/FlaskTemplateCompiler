package AST;

public class IdentifierNode extends ASTNode {

    private String name;

    public IdentifierNode(String name, int line) {
        super("Identifier", line);
        this.name = name;
    }
    public String getName() {
        return nodeName; // nodeName موجود في ASTNode
    }
    @Override
    protected void print(String indent, boolean last) {
        System.out.print(indent);
        System.out.print(last ? "└── " : "├── ");
        System.out.println(nodeName + " : " + name + " (line " + line + ")");
    }
}
