package rpn.EventOperator;

import rpn.Event.EventDispatcher;
import rpn.Operator.Operator2Operands;

import java.util.ArrayList;

public class SubstractionEvent extends Operator2OperandEvent {
    public SubstractionEvent(ArrayList<String> operation, int operatorIndex) { super("SubstractionEvent", operation, operatorIndex); }
}
