package AST;

public class RouteDefNode extends ASTNode {
    private String routeName;

    public RouteDefNode(String routeName, int line) {
        super("RouteDef", line);
        this.routeName = routeName;
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + nodeName + " : " + routeName + " (line " + line + ")");
        for (ASTNode child : children) {
            child.print(indent + "  ");
        }
    }
}
