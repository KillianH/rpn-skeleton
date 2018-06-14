package rpn.exceptions;

import rpn.Event.Event;

/**
 * Created by Killian on 04/06/2018.
 */
public class ErrorEvent extends Event {
    private String type;
    private String message;

    public ErrorEvent(Throwable e) {
        super("ErrorEvent");
        type = e.getClass().getSimpleName();
        message = e.getMessage();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
