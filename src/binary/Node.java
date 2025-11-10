package binary;

import java.util.Random;

public class Node implements Cloneable {

    public Node left;
    public Node right;
    public Op operation;
    public int depth;

    // Constructor
    public Node(Op operation) {
        this.operation = operation;
        this.left = null;
        this.right = null;
        this.depth = 0;
    }

    // ✅ Evaluate the expression tree using data[] values for variables
    public double eval(double[] data) {
        if (operation instanceof Const) {
            return ((Const) operation).getValue();
        }
        if (operation instanceof Variable) {
            int index = ((Variable) operation).getIndex();
            return data[index];
        }
        double leftVal = left.eval(data);
        double rightVal = right.eval(data);
        return operation.eval(leftVal, rightVal);
    }

    // ✅ String form of the expression tree
    @Override
    public String toString() {
        if (left == null && right == null) {
            return operation.toString();
        }
        return "(" + left.toString() + " " + operation.toString() + " " + right.toString() + ")";
    }

    // ✅ Recursive tree builder using NodeFactory
    public void addRandomKids(NodeFactory f, int maxDepth, Random rand) {
        if (this.depth >= maxDepth) {
            this.left = f.getTerminal(rand);
            this.left.depth = this.depth + 1;
            this.right = f.getTerminal(rand);
            this.right.depth = this.depth + 1;
            return;
        }

        // Left child
        if (rand.nextBoolean()) {
            this.left = f.getOperator(rand);
            this.left.depth = this.depth + 1;
            this.left.addRandomKids(f, maxDepth, rand);
        } else {
            this.left = f.getTerminal(rand);
            this.left.depth = this.depth + 1;
        }

        // Right child
        if (rand.nextBoolean()) {
            this.right = f.getOperator(rand);
            this.right.depth = this.depth + 1;
            this.right.addRandomKids(f, maxDepth, rand);
        } else {
            this.right = f.getTerminal(rand);
            this.right.depth = this.depth + 1;
        }
    }

    // ✅ FULL DEEP CLONE
    @Override
    public Object clone() {
        try {
            Node cloned = (Node) super.clone();
            if (this.left != null) cloned.left = (Node) this.left.clone();
            if (this.right != null) cloned.right = (Node) this.right.clone();
            if (this.operation != null) cloned.operation = (Op) this.operation.clone();
            return cloned;
        } catch (CloneNotSupportedException e) {
            System.out.println("Node clone failed");
            return null;
        }
    }
}
