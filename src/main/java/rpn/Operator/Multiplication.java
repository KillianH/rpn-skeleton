package rpn.Operator;

public class Multiplication extends Operator2Operands {
    public Multiplication() {
        super("*");
    }

    @Override
    public int apply(int a, int b) {
        return a * b;
    }
}
