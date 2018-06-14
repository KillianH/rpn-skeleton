package rpn;

import rpn.Event.Event;

public class CalculateEvent extends Event {
    public String calcul;
    public CalculateEvent(String calcul) {
        super("CalculateEvent");

        this.calcul = calcul;
    }
}