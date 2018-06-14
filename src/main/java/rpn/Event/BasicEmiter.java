package rpn.Event;

public class BasicEmiter extends EventConsumer implements IEmiter{


    public BasicEmiter(EventDispatcher eventDispatcher) {
        super(eventDispatcher);
    }

    public void emit(Event event) {
        eventDispatcher.emit(event);
    }
}
