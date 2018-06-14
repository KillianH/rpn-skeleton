package rpn.EventParser;

import rpn.Event.EmiterListener;
import rpn.Event.EventDispatcher;
import rpn.Event.ICoffee;
import rpn.Parser.Parser;

import java.util.ArrayList;

public class ParserEL extends EmiterListener {
    private Parser parser;

    public ParserEL(EventDispatcher eventDispatcher) {
        super(eventDispatcher);

        register("ParserEvent", (ICoffee<ParserEvent>) event -> {
            parser = new Parser(event.symbol);
            ArrayList<String> res = parser.parse(event.str);
            emit(new ParseFinishedEvent(res));
        });
    }
}
