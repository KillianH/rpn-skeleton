package rpn.EventOperator;

import rpn.Event.*;
import rpn.Operator.Multiplication;

public class MultiplicationEL extends EmiterListener implements IOperatorEL {
    Multiplication operator        = new Multiplication();
    public final Class EVENT_CLASS = MultiplicationEvent.class;

    public MultiplicationEL(EventDispatcher eventDispatcher) {
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

    public String getOperator(){
        return operator.symbol;
    }
}
