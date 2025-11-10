package binary;

public interface Op extends Cloneable {
    double eval(double left, double right); // for binary ops like +, -, *, /
    String toString();
    Object clone();
}



