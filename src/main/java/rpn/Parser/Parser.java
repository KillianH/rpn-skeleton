package rpn.Parser;

import java.util.Stack;

public class Parser {
    public final String symbol;
    Parser(String symbol){
        this.symbol = symbol;
    }

    public Parser(){
        this.symbol = " ";
    }

    public Stack<String> parse(String string){
        Stack<String> result = new Stack<>();

        for (String token : string.split(this.symbol)) {
            result.push(token);
        }

        return result;
    }
}
