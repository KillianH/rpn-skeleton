package rpn.EventOperator;

import rpn.Event.*;
import rpn.Operator.Division;

public class DivisionEL extends EmiterListener implements IOperatorEL {
    Division operator             = new Division();
    public final Class EVENT_CLASS = DivisionEvent.class;

    public DivisionEL(EventDispatcher eventDispatcher) {
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

    public String getOperator() {
        return operator.symbol;
    }
}
