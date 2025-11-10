package binary;

public interface Unop extends Op {
    double eval(double[] values);

    @Override
    default Object clone() {
        try {
            return this.getClass().getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Cannot clone Unop", e);
        }
    }
}


