package rpn.Operator;

public class Substraction extends Operator2Operands {
    public Substraction() {
        super("-");
    }

    @Override
    public double apply(double a, double b) {
        return a - b;
    }
}
