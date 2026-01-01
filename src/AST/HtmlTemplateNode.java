package AST;

import java.util.ArrayList;
import java.util.List;

public class HtmlTemplateNode extends ASTNode {

    private List<ASTNode> elements = new ArrayList<>();

    public HtmlTemplateNode(int line) {
        super("HtmlTemplate", line);
    }

    public void addElement(ASTNode node) {
        if (node != null)
            elements.add(node);
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + "HtmlTemplate (line " + line + ")");
        for (ASTNode el : elements) {
            el.print(indent + "  ");
        }
    }
}
