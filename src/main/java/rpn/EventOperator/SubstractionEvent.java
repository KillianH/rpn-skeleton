package rpn.EventOperator;

public class SubstractionEvent extends Operator2OperandEvent {
    public SubstractionEvent(double leftOperand, double rightOperand) {
        super("SubstractionEvent", leftOperand, rightOperand);
    }
}
