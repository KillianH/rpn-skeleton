package rpn;

import rpn.Event.Event;

import java.util.ArrayList;

public class PerformCalculEvent extends Event {
    public ArrayList<String> calcul;
    public PerformCalculEvent(ArrayList<String> calcul) {
        super("PerformCalculEvent");

        this.calcul = calcul;
    }
}
