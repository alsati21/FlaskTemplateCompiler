package AST;

public class HtmlTextNode extends ASTNode {

    private final String text;

    public HtmlTextNode(String text, int line) {
        super("HtmlText", line);  // nodeName يكون ثابتًا HtmlText
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + nodeName + " (\"" + text + "\")" + " : line " + line);
    }
}
