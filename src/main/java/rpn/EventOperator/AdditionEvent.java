package rpn.EventOperator;

import rpn.Event.Event;

public class AdditionEvent extends Operator2OperandEvent {
    public AdditionEvent(double leftOperand, double rightOperand) {
        super("AdditionEvent", leftOperand, rightOperand);
    }
}
