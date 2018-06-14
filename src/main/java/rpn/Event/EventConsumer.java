package rpn.Event;

public abstract class EventConsumer {
    protected EventDispatcher eventDispatcher;

    public EventConsumer(EventDispatcher eventDispatcher) {
        this.eventDispatcher = eventDispatcher;
    }
}
