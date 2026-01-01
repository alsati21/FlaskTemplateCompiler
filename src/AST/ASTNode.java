package AST;

import java.util.ArrayList;
import java.util.List;

public class ASTNode {

    protected String nodeName;
    protected int line;
    protected List<ASTNode> children = new ArrayList<>();

    public ASTNode(String nodeName, int line) {
        this.nodeName = nodeName;
        this.line = line;
    }

    public void addChild(ASTNode child) {
        if (child != null)
            children.add(child);
    }

    // entry point
    public void print(String indent) {
        print(indent, true);
    }

    // real tree printer
    protected void print(String indent, boolean last) {
        System.out.print(indent);

        if (last) {
            System.out.print("└── ");
            indent += "    ";
        } else {
            System.out.print("├── ");
            indent += "│   ";
        }

        System.out.println(nodeName + " (line " + line + ")");

        for (int i = 0; i < children.size(); i++) {
            children.get(i).print(indent, i == children.size() - 1);
        }
    }
}
