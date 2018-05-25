package rpn.EventOperator;

import rpn.Event.*;
import rpn.Operator.Multiplication;

public class MultiplicationEL extends EmiterListener implements ICoffee<Operator2OperandEvent> {
    Multiplication multiplication = new Multiplication();

    public MultiplicationEL(EventDispatcher eventDispatcher) {
        super(eventDispatcher);

        register("MultiplicationEvent", this);
    }

    @Override
    public void call(Operator2OperandEvent event) {
        double res = multiplication.apply(event.leftOperand, event.rightOperand);

        emit(new OperationAppliedEvent(res));
    }
}
