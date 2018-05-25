package rpn.Event;

public class BasicListener extends EventConsumer implements IListener{

    public BasicListener(EventDispatcher eventDispatcher) {
        super(eventDispatcher);
    }

    public void register(String eventKey, ICoffee coffee) {
        this.eventDispatcher.register(eventKey, coffee);
    }
}
