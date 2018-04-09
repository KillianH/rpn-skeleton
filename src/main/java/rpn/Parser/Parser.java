package rpn.Parser;

import java.util.ArrayList;
import java.util.Arrays;

public class Parser {
    public final String symbol;
    Parser(String symbol){
        this.symbol = symbol;
    }

    public Parser(){
        this.symbol = " ";
    }

    public ArrayList<String> parse(String string){
        return new ArrayList<>(Arrays.asList(string.split(this.symbol)));
    }
}
