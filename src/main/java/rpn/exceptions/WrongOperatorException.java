package rpn.exceptions;

/**
 * WrongOperatorException
 * Thrown when a given operator is not supported or invalid
 * Ex: Anything else than a double or + - * '*' /
 */
public class WrongOperatorException extends Exception {

    /**
     * Constructor
     * @param operator specify the wrong operator
     */
    public WrongOperatorException(String operator) {
        super("Unhandled operator : " + operator);
    }

}
