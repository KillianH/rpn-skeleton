package rpn.Event;

import java.util.ArrayList;
import java.util.HashMap;

public class EventDispatcher {
    private HashMap<String, ArrayList<ICoffee>> registeredEventListener;

    public EventDispatcher(){
        registeredEventListener = new HashMap<String, ArrayList<ICoffee>>();
    }

    public void register(String eventKey, ICoffee coffee){
        if(!registeredEventListener.containsKey(eventKey)) registeredEventListener.put(eventKey, new ArrayList<>());
        registeredEventListener.get(eventKey).add(coffee);
    }

    public void emit(Event event){
        if(registeredEventListener.get(event.name) != null) {
            for (ICoffee coffee : registeredEventListener.get(event.name)) {
                coffee.call(event);
            }
        }
    }
}
