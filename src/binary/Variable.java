package binary;

public class Variable implements Unop, Cloneable {
    private int index; // X0, X1, etc.

    public Variable(int index) {
        this.index = index;
    }

    @Override
    public double eval(double[] values) {
        return values[index];
    }

    @Override
    public String toString() {
        return "X" + index;
    }

    @Override
    public Object clone() {
        return new Variable(this.index);
    }
}

