package rpn.EventOperator;

public class MultiplicationEvent extends Operator2OperandEvent{
    public MultiplicationEvent(double leftOperand, double rightOperand) {
        super("MultiplicationEvent", leftOperand, rightOperand);
    }
}
