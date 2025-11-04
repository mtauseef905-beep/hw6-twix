package binary;

import java.util.Random;

public class TestRefactored {
    public static void main(String[] args) {
        int numIndepVars = 3;
        int maxDepth = 4;
        Random rand = new Random();

        double[] data = {3.14, 2.78, 1.0};
        Binop[] ops = {new Plus(), new Minus(), new Mult(), new Divide()};
        NodeFactory n = new NodeFactory(ops, numIndepVars);

        Node root = n.getOperator(rand);
        root.addRandomKids(n, maxDepth, rand);

        System.out.println(root + " = " + String.format("%.2f", root.eval(data)));
    }
}

