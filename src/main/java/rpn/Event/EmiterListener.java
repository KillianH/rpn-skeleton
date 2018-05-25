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
        System.out.println("EMIT :" + event.name);
        emiter.emit(event);
    }

    @Override
    public void register(String eventKey, ICoffee coffee) {
        System.out.println("REGISTER :" + eventKey);
        listener.register(eventKey, coffee);
    }
}
