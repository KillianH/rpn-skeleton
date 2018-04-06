package rpn.Operator;

public class Substract extends Operator2Operands {
    Substract() {
        super("-");
    }

    @Override
    public int apply(int a, int b) {
        return a - b;
    }
}
