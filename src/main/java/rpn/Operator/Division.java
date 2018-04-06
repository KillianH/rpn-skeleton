package rpn.Operator;

public class Division extends Operator2Operands{
    public Division(){
        super("/");
    }

    @Override
    public int apply(int a, int b) {
        return a / b;
    }
}
