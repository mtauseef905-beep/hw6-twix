package binary;

public class Node implements Cloneable {
    protected Op operation;
    protected Node lChild;
    protected Node rChild;

    public Node(Op o) {
        this.operation = o;
    }

    public void setLeft(Node n) {
        lChild = n;
    }

    public void setRight(Node n) {
        rChild = n;
    }

    public double eval(double[] values) {
        if (operation instanceof Binop) {
            double leftVal = lChild.eval(values);
            double rightVal = rChild.eval(values);
            return ((Binop) operation).eval(leftVal, rightVal);
        } else {
            return operation.eval(values);
        }
    }

    @Override
    public String toString() {
        if (operation instanceof Binop) {
            return "(" + lChild.toString() + " " + operation.toString() + " " + rChild.toString() + ")";
        }
        return operation.toString();
    }
}
public void addRandomKids(NodeFactory factory, int maxDepth, Random rand) {
    if (this.operation instanceof Unop) return;

    // Left child
    if (rand.nextInt(factory.getNumOps() + factory.getNumIndepVars()) < factory.getNumOps()) {
        this.lChild = factory.getOperator(rand);
        this.lChild.addRandomKids(factory, maxDepth, rand);
    } else {
        this.lChild = factory.getTerminal(rand);
    }

    // Right child
    if (rand.nextInt(factory.getNumOps() + factory.getNumIndepVars()) < factory.getNumOps()) {
        this.rChild = factory.getOperator(rand);
        this.rChild.addRandomKids(factory, maxDepth, rand);
    } else {
        this.rChild = factory.getTerminal(rand);
    }
}
