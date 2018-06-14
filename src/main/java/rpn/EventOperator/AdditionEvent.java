package rpn.EventOperator;

import rpn.exceptions.InvalidOperation;

import java.util.ArrayList;

public class AdditionEvent extends Operator2OperandEvent {
    public AdditionEvent(ArrayList<String> operation, int operatorIndex) throws InvalidOperation { super("AdditionEvent", operation, operatorIndex); }
}
