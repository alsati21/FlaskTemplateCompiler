package AST;

public class FileNode extends ASTNode {

    public FileNode(int line) {
        super("File", line);
    }

    public void add(ASTNode node) {
        addChild(node);
    }
}
