package AST;

public class AppInitNode extends ASTNode {

    public AppInitNode(int line) {
        super("AppInit", line);
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + nodeName + " : Flask(__name__)");
    }
}
