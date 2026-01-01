package AST;

public class CssPropertyNode extends ASTNode {
    private String property;
    private String value;

    public CssPropertyNode(String property, String value, int line) {
        super("CssProperty", line);
        this.property = property;
        this.value = value;
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + nodeName + " (line " + line + "): " + property + " : " + value);
    }
}
