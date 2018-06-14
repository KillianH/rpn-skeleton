package rpn.EventOperator;

import rpn.Event.EventDispatcher;
import rpn.Operator.Operator2Operands;
import rpn.exceptions.InvalidOperation;

import java.util.ArrayList;

public class MultiplicationEvent extends Operator2OperandEvent{
    public MultiplicationEvent(ArrayList<String> operation, int operatorIndex) throws InvalidOperation { super("MultiplicationEvent", operation, operatorIndex); }
}
