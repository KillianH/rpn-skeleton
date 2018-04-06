package rpn.Operator;

public class Substraction extends Operator2Operands {
    public Substraction() {
        super("-");
    }

    @Override
    public int apply(int a, int b) {
        return a - b;
    }
}
