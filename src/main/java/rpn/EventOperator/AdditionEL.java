package rpn.EventOperator;

import rpn.Event.*;
import rpn.Operator.Addition;

public class AdditionEL extends EmiterListener implements ICoffee<Operator2OperandEvent> {
    Addition addition = new Addition();

    public AdditionEL(EventDispatcher eventDispatcher) {
        super(eventDispatcher);

        register("AdditionEvent", this);
    }

    @Override
    public void call(Operator2OperandEvent event) {
        System.out.println("coffee");
        double res = addition.apply(event.leftOperand, event.rightOperand);

        emit(new OperationAppliedEvent(res));
    }
}
