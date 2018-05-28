package rpn.EventOperator;

import java.util.ArrayList;

public class DivisionEvent extends Operator2OperandEvent {
    public DivisionEvent(ArrayList<String> operation, int operatorIndex) { super("DivisionEvent", operation, operatorIndex); }
}
