package rpn.exceptions;

import java.util.ArrayList;

/**
 * Invalid Expression
 * Thrown when the expression is invalid
 * Ex: Missing operator to evaluate the full expression
 */
public class InvalidExpression extends Exception {
    private final String message;

    /**
     * Constructor
     * @param s message
     * @param expression fields left from expression
     */
    public InvalidExpression(String s, ArrayList<String> expression) {
        super(s);
        StringBuilder fieldsLeft = new StringBuilder("\nFields left :");
        for(String field : expression){
            fieldsLeft.append(" ").append(field);
        }
        s += fieldsLeft;
        this.message = s;
    }

    @Override
    public String getMessage(){
        return this.message;
    }
}
