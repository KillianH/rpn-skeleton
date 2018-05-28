package rpn.EventOperator;

import rpn.Event.*;
import rpn.Operator.Addition;

public class AdditionEL extends EmiterListener implements IOperatorEL {
    Addition operator               = new Addition();
    public final Class EVENT_CLASS = AdditionEvent.class;

    public AdditionEL(EventDispatcher eventDispatcher) {
        super(eventDispatcher);

        register(getEventName(), new Operator2OperandCoffee(operator, eventDispatcher));
    }

    @Override
    public String getEventName() {
        return EVENT_CLASS.getSimpleName();
    }

    @Override
    public Class getEventClass() {
        return EVENT_CLASS;
    }

    @Override
    public String getOperator() {
        return operator.symbol;
    }
}
