package rpn.Event;

import java.util.ArrayList;
import java.util.HashMap;

public class EventDispatcher {
    private HashMap<String, ArrayList<ICoffee>> registeredEventListener;

    public EventDispatcher(){
        registeredEventListener = new HashMap<String, ArrayList<ICoffee>>();
    }

    public void register(String eventKey, ICoffee coffee){
        System.out.println("listen to →" + eventKey);
        if(!registeredEventListener.containsKey(eventKey)) registeredEventListener.put(eventKey, new ArrayList<>());
        registeredEventListener.get(eventKey).add(coffee);
    }

    public void emit(Event event){
        System.out.println("has been emit →" + event.name);
        if(registeredEventListener.get(event.name) != null) {
            for (ICoffee coffee : registeredEventListener.get(event.name)) {
                System.out.println("has been catch!");
                coffee.call(event);
            }
        }else{
            System.out.println("caution event " + event.name + " was not catch");
        }
    }
}
