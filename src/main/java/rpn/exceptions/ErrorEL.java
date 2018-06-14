package rpn.exceptions;

import rpn.Event.EmiterListener;
import rpn.Event.EventDispatcher;
import rpn.Event.ICoffee;

/**
 * Created by Killian on 06/06/2018.
 */
public class ErrorEL extends EmiterListener {

    public ErrorEL(EventDispatcher eventDispatcher) {
        super(eventDispatcher);

        register("ErrorEvent", new ICoffee<ErrorEvent>(){
            @Override
            public void call(ErrorEvent event) {
                System.out.println(event.getType() + " - " + event.getMessage());
            }
        });
    }
}