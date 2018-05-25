package rpn.EventOperator;

import rpn.Event.Event;

public class Operator2OperandEvent extends Event {
    public double leftOperand;
    public double rightOperand;
    public Operator2OperandEvent(String name, double leftOperand, double rightOperand) {
        super(name);

        this.leftOperand  = leftOperand;
        this.rightOperand = rightOperand;
    }
}
