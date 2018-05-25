package rpn.EventOperator;

import rpn.Event.*;
import rpn.Operator.Substraction;

public class SubstractionEL extends EmiterListener implements ICoffee<Operator2OperandEvent> {
    Substraction substraction = new Substraction();

    public SubstractionEL(EventDispatcher eventDispatcher) {
        super(eventDispatcher);

        register("SubstractionEvent", this);
    }

    @Override
    public void call(Operator2OperandEvent event) {
        double res = substraction.apply(event.leftOperand, event.rightOperand);

        emit(new OperationAppliedEvent(res));
    }
}
