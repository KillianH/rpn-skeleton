package rpn.EventOperator;

import rpn.Event.Event;
import rpn.exceptions.InvalidOperation;

import java.util.ArrayList;

public class Operator2OperandEvent extends Event {
    public int               operatorIndex;
    public int               toRemove = 1;
    public ArrayList<String> operation;

    public Operator2OperandEvent(String name, ArrayList<String> operation, int operatorIndex) throws InvalidOperation {
        super(name);

        this.operatorIndex   = operatorIndex;
        this.operation       = operation;

    }
}
