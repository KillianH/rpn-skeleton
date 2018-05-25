package rpn.EventParser;

import rpn.Event.Event;

import java.util.ArrayList;

public class ParseFinishedEvent extends Event {
    public ArrayList<String> tokens;

    public ParseFinishedEvent(ArrayList<String> tokenList) {
        super("ParseFinishedEvent");

        tokens = tokenList;
    }
}
