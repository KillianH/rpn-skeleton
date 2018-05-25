package rpn.EventOperator;

import rpn.Event.Event;

public class OperationAppliedEvent extends Event {
    public double result;

    public OperationAppliedEvent(double result) {
        super("OperationAppliedEvent");
        this.result = result;
    }
}
