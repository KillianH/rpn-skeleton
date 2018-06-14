package rpn.Operator;

public class Addition extends Operator2Operands {
    public Addition() {
        super("+");
    }

    @Override
    public double apply(double a, double b) {
        return a + b;
    }
}
