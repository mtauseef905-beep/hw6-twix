package binary;

public class Const implements Unop, Cloneable {
    private double value;

    public Const(double v) {
        this.value = v;
    }

    @Override
    public double eval(double[] values) {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public Object clone() {
        return new Const(this.value);
    }
}
