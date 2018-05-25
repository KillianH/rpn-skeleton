package rpn.Event;

public class EmiterListener extends EventConsumer implements IEmiter, IListener {
    private BasicListener listener;
    private BasicEmiter   emiter;

    public EmiterListener(EventDispatcher eventDispatcher) {
        super(eventDispatcher);

        listener = new BasicListener(eventDispatcher);
        emiter   = new BasicEmiter(eventDispatcher);
    }

    @Override
    public void emit(Event event) {
        emiter.emit(event);
    }

    @Override
    public void register(String eventKey, ICoffee coffee) {
        listener.register(eventKey, coffee);
    }
}
