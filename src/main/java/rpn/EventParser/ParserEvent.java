package rpn.EventParser;

import rpn.Event.Event;

public class ParserEvent extends Event {
    public String str;
    public String symbol;
    public ParserEvent(String str) {
        this(str, " ");
    }
    public ParserEvent(String str, String symbol) {
        super("ParserEvent");

        this.str    = str;
        this.symbol = symbol;
    }
}
