package rpn.EventOperator;

import rpn.Event.EventDispatcher;
import rpn.Operator.Operator2Operands;

import java.util.ArrayList;

public class MultiplicationEvent extends Operator2OperandEvent{
    public MultiplicationEvent(ArrayList<String> operation, int operatorIndex) { super("MultiplicationEvent", operation, operatorIndex); }
}
