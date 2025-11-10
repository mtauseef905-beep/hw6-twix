package binary;

public class Const implements Op {

    private double value;

    public Const(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public double eval(double left, double right) {
        return value; // Constants ignore inputs
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
