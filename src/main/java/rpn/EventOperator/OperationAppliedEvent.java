package rpn.EventOperator;

import rpn.Event.Event;

import java.util.ArrayList;

public class OperationAppliedEvent extends Event {
    public ArrayList<String> result;

    public OperationAppliedEvent(ArrayList<String> result) {
        super("OperationAppliedEvent");
        this.result = result;
    }
}
