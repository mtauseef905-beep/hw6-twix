package binary;

import java.util.Random;

public class NodeFactory {
    private Node[] currentOps;
    private int numIndepVars;

    public NodeFactory(Binop[] b, int numVars) {
        currentOps = new Node[b.length];
        for (int i = 0; i < b.length; i++) {
            currentOps[i] = new Node((Op) b[i].clone());
        }
        this.numIndepVars = numVars;
    }

    public Node getOperator(Random rand) {
        int index = rand.nextInt(currentOps.length);
        return (Node) currentOps[index].clone();
    }

    public int getNumOps() {
        return currentOps.length;
    }

    public Node getTerminal(Random rand) {
        int choice = rand.nextInt(numIndepVars + 1);
        if (choice < numIndepVars) {
            return new Node(new Variable(choice));
        } else {
            return new Node(new Const(rand.nextDouble()));
        }
    }

    public int getNumIndepVars() {
        return numIndepVars;
    }
}


