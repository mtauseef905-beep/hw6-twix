package binary;

public class Variable implements Op {

    private int index; // Example: X0 → index 0, X1 → index 1

    public Variable(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public double eval(double left, double right) {
        // In actual evaluation, this is handled in Node's eval using data[index]
        return 0;
    }

    @Override
    public String toString() {
        return "X" + index;
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
