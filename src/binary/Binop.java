package binary;

public interface Binop extends Op {
    @Override
    double eval(double left, double right);

    @Override
    String toString();

    @Override
    Object clone();
}

