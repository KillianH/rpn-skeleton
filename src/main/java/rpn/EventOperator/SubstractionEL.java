package rpn.EventOperator;

import rpn.Event.*;
import rpn.Operator.Substraction;

public class SubstractionEL extends EmiterListener implements IOperatorEL {
    Substraction operator = new Substraction();
    public final Class EVENT_CLASS = SubstractionEvent.class;

    public SubstractionEL(EventDispatcher eventDispatcher) {
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
