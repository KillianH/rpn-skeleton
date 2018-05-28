package rpn;

import rpn.Event.Event;

import java.util.ArrayList;

public class CalculFinished extends Event {
    public ArrayList<String> calcul;
    public CalculFinished(ArrayList<String> calcul) {
        super("CalculFinished");

        this.calcul = calcul;
    }
}
