package rpn.EventOperator;

import rpn.Event.EventDispatcher;
import rpn.Event.ICoffee;
import rpn.Operator.Operator2Operands;

public class Operator2OperandCoffee implements ICoffee<Operator2OperandEvent> {
    private Operator2Operands operator;
    private EventDispatcher eventDispatcher;

    public Operator2OperandCoffee(Operator2Operands operator, EventDispatcher eventDispatcher){
        this.operator        = operator;
        this.eventDispatcher = eventDispatcher;
    }

    @Override
    public void call(Operator2OperandEvent event) {
        double res = operator.apply(event.leftOperand, event.rightOperand);

        for(int iToRemove = 0; iToRemove < event.toRemove; iToRemove++){

            event.operation.remove(event.operatorIndex - iToRemove);
        }

        event.operation.add(event.operatorIndex - event.toRemove + 1, String.valueOf(res));

        eventDispatcher.emit(new OperationAppliedEvent(event.operation));
    }
}
