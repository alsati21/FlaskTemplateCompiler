package AST;

import java.util.ArrayList;
import java.util.List;

public class HtmlTagNode extends ASTNode {

    private String tagName;
    private List<ASTNode> attributes = new ArrayList<>();
    private List<ASTNode> body = new ArrayList<>();

    public HtmlTagNode(String tagName, int line) {
        super("HtmlTag", line);
        this.tagName = tagName;
    }

    public void addAttribute(ASTNode attr) {
        attributes.add(attr);
    }

    public void addBody(ASTNode node) {
        body.add(node);
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + "HtmlTag <" + tagName + ">");

        if (!attributes.isEmpty()) {
            System.out.println(indent + "  Attributes:");
            attributes.forEach(a -> a.print(indent + "    "));
        }

        if (!body.isEmpty()) {
            System.out.println(indent + "  Body:");
            body.forEach(b -> b.print(indent + "    "));
        }
    }
}
