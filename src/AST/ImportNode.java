package AST;

public class ImportNode extends ASTNode {

    private String text;

    public ImportNode(int line) {
        super("ImportStmt", line);
        this.text = text;
    }

    @Override
    public void print(String indent)
    {
        System.out.println(indent + nodeName + " : " + text);
    }

}
