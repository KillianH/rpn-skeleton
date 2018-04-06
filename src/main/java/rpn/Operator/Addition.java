package rpn.Operator;

public class Addition extends Operator2Operands {
    Addition() {
        super("+");
    }

    @Override
    public int apply(int a, int b) {
        return a + b;
    }
}
