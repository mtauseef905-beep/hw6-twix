package binary;

public class Mult implements Binop {

    @Override
    public double eval(double left, double right) {
        return left * right;
    }

    @Override
    public String toString() {
        return "*";
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
