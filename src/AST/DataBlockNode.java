package AST;

public class DataBlockNode extends ASTNode {

    public DataBlockNode(int line) {
        super("DataBlock", line);
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + nodeName);
        for (ASTNode child : children) {
            child.print(indent + "  ");
        }
    }
}
