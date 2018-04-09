package rpn.Operator;

public class Multiplication extends Operator2Operands {
    public Multiplication() {
        super("*");
    }

    @Override
    public double apply(double a, double b) {
        return a * b;
    }
}
