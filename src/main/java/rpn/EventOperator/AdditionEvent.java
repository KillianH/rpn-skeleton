package rpn.EventOperator;

import java.util.ArrayList;

public class AdditionEvent extends Operator2OperandEvent {
    public AdditionEvent(ArrayList<String> operation, int operatorIndex) { super("AdditionEvent", operation, operatorIndex); }
}
