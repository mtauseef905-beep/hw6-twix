package binary;

public interface Op extends Cloneable {
    double eval(double[] values);
    String toString();
    Object clone();
}


