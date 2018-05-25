package rpn.EventOperator;

import rpn.Event.*;
import rpn.Operator.Division;

public class DivisionEL extends EmiterListener implements ICoffee<Operator2OperandEvent> {
    Division division = new Division();

    public DivisionEL(EventDispatcher eventDispatcher) {
        super(eventDispatcher);

        register("DivisionEvent", this);
    }

    @Override
    public void call(Operator2OperandEvent event) {
        double res = division.apply(event.leftOperand, event.rightOperand);

        emit(new OperationAppliedEvent(res));
    }
}
