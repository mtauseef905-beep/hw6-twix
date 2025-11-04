package binary;

import java.util.Random;

/**
 * Builds two balanced algebraic trees (3 internal binop nodes, 4 terminals)
 * and evaluates each with two different variable assignments.
 */
public class TestAlgebra {
    public static void main(String[] args) {
        Random rand = new Random();

        // Operators array to choose from
        Binop[] ops = { new Plus(), new Minus(), new Mult(), new Divide() };

        // We'll build two test trees
        for (int t = 0; t < 2; t++) {
            Node root = buildBalancedTree(rand, ops);
            double[] values1 = {1.0, 2.0, 3.0}; // example 1
            double[] values2 = {2.0, 1.0, 0.0}; // example 2

            // Print exactly as example format
            System.out.println("When {X0,X1,X2} = {1.0,2.0,3.0}:");
            System.out.println(root.toString() + " = " + String.format("%.1f", root.eval(values1)));
            System.out.println();
            System.out.println("When {X0,X1,X2} = {2.0,1.0,0.0}:");
            System.out.println(root.toString() + " = " + String.format("%.1f", root.eval(values2)));
            System.out.println();
        }
    }

    // Build a balanced tree with 3 internal nodes and 4 terminals (full binary tree of height 2)
    private static Node buildBalancedTree(Random rand, Binop[] ops) {
        // Create operator nodes
        Binop opRoot = ops[rand.nextInt(ops.length)];
        Binop opLeft = ops[rand.nextInt(ops.length)];
        Binop opRight = ops[rand.nextInt(ops.length)];

        Node root = new Node((Binop) opRoot);
        Node left = new Node((Binop) opLeft);
        Node right = new Node((Binop) opRight);

        root.lChild = left;
        root.rChild = right;

        // For 4 leaves, attach terminals to left and right internal nodes
        left.lChild = makeRandomTerminal(rand);
        left.rChild = makeRandomTerminal(rand);
        right.lChild = makeRandomTerminal(rand);
        right.rChild = makeRandomTerminal(rand);

        return root;
    }

    // Terminal: coin flip: heads => Const [1..20], tails => Variable X0..X2
    private static Node makeRandomTerminal(Random rand) {
        boolean coin = rand.nextBoolean();
        if (coin) {
            double v = 1 + rand.nextInt(20); // 1..20
            return new Node(new Const(v));
        } else {
            int idx = rand.nextInt(3); // X0..X2
            return new Node(new Variable(idx));
        }
    }
}
