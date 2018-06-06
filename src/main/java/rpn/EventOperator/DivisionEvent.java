package rpn.EventOperator;

import rpn.exceptions.InvalidOperation;

import java.util.ArrayList;

public class DivisionEvent extends Operator2OperandEvent {
    public DivisionEvent(ArrayList<String> operation, int operatorIndex) throws InvalidOperation { super("DivisionEvent", operation, operatorIndex); }
}
