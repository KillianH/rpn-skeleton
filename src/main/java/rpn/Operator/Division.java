package rpn.Operator;

public class Division extends Operator2Operands{
    public Division(){
        super("/");
    }

    @Override
    public double apply(double a, double b) {
        if(b == 0) throw new ArithmeticException("division by 0");
        return a / b;
    }
}
