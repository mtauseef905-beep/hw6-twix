package binary;

public class Plus implements Binop, Cloneable {
    @Override
    public double eval(double left, double right) {
        return left + right;
    }

    @Override
    public double eval(double[] values) {
        throw new UnsupportedOperationException("Use eval(left, right) for Binop");
    }

    @Override
    public String toString() {
        return "+";
    }

    @Override
    public Object clone() {
        return new Plus();
    }
}

