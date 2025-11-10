package binary;

public class Divide implements Binop {

    @Override
    public double eval(double left, double right) {
        if (right == 0) return 0; // avoid division by zero
        return left / right;
    }

    @Override
    public String toString() {
        return "/";
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

