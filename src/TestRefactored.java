import binary.*;
import java.util.Random;

public class TestRefactored {
    public static void main(String[] args) {
        int numIndepVars = 3;
        int maxDepth = 4;
        Random rand = new Random();

        double[] data = {3.14, 2.78, 1.0};

        Binop[] ops = { new Plus(), new Minus(), new Mult(), new Divide() };
        NodeFactory factory = new NodeFactory(ops, numIndepVars);

        Node root = factory.getOperator(rand);
        root.depth = 0;
        root.addRandomKids(factory, maxDepth, rand);

        System.out.println(root.toString() + " = " + root.eval(data));
    }
}

