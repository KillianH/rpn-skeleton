package rpn.EventOperator;

import rpn.Event.Event;

public class DivisionEvent extends Operator2OperandEvent {
    public DivisionEvent(double leftOperand, double rightOperand) {
        super("DivisionEvent", leftOperand, rightOperand);
    }
}
