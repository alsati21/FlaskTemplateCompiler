package AST;

public class HtmlForNode extends ASTNode {

    private String iterator;
    private String iterable;

    public HtmlForNode(String iterator, String iterable, int line) {
        super("HtmlFor", line);
        this.iterator = iterator;
        this.iterable = iterable;
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + "HtmlFor (" + iterator + " in " + iterable + ")");
        children.forEach(c -> c.print(indent + "  "));
    }
}
