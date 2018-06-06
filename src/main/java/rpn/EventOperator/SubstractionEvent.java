package rpn.EventOperator;

import rpn.Event.EventDispatcher;
import rpn.Operator.Operator2Operands;
import rpn.exceptions.InvalidOperation;

import java.util.ArrayList;

public class SubstractionEvent extends Operator2OperandEvent {
    public SubstractionEvent(ArrayList<String> operation, int operatorIndex) throws InvalidOperation { super("SubstractionEvent", operation, operatorIndex); }
}
