package rpn.EventOperator;

import rpn.Event.EventDispatcher;
import rpn.Event.ICoffee;
import rpn.Operator.Operator2Operands;
import rpn.exceptions.ErrorEvent;
import rpn.exceptions.InvalidOperation;

import java.util.ArrayList;
import java.util.Arrays;

public class Operator2OperandCoffee implements ICoffee<Operator2OperandEvent> {
    private Operator2Operands operator;
    private EventDispatcher eventDispatcher;

    public Operator2OperandCoffee(Operator2Operands operator, EventDispatcher eventDispatcher){
        this.operator        = operator;
        this.eventDispatcher = eventDispatcher;
    }

    @Override
    public void call(Operator2OperandEvent event) {
        ArrayList<Double> operands = new ArrayList<>();
        try {
            operands = operator.getOperand(event.operation, event.operatorIndex);
        } catch (InvalidOperation invalidOperation) {
            eventDispatcher.emit(new ErrorEvent(invalidOperation));
        }

        double res = operator.apply(operands.get(0), operands.get(1));

        for(int iToRemove = 0; iToRemove < event.toRemove; iToRemove++){
            event.operation.remove(event.operatorIndex);
        }

        event.operation.add(event.operatorIndex - event.toRemove + 1, String.valueOf(res));

        eventDispatcher.emit(new OperationAppliedEvent(event.operation));
    }
}
