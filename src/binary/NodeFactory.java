package binary;

import java.util.Random;

public class NodeFactory {
    private int numIndepVars;      // number of independent variables (X0, X1, ..., Xn-1)
    private Node[] currentOps;     // stores operator nodes (Plus, Minus, etc.)

    // Constructor: store Binops and number of variables
    public NodeFactory(Binop[] b, int numVars) {
        numIndepVars = numVars;
        currentOps = new Node[b.length];
        for (int i = 0; i < b.length; i++) {
            currentOps[i] = new Node(b[i]); // each is a Node wrapping a Binop
        }
    }

    // Return number of operator types
    public int getNumOps() {
        return currentOps.length;
    }

    // Return number of variables (X0 to X(numIndepVars-1))
    public int getNumIndepVars() {
        return numIndepVars;
    }

    // ✅ Return a cloned operator Node
    public Node getOperator(Random rand) {
        int index = rand.nextInt(currentOps.length);
        return (Node) currentOps[index].clone();
    }

    // ✅ Return a terminal: either Variable or Const
    public Node getTerminal(Random rand) {
        int bound = numIndepVars + 1;
        int pick = rand.nextInt(bound);

        if (pick < numIndepVars) {
            return new Node(new Variable(pick)); // Variable: X0, X1, etc.
        } else {
            double val = rand.nextDouble(); // [0,1)
            return new Node(new Const(val));
        }
    }
}

