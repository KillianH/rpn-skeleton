package rpn.exceptions;

public class InvalidOperation extends Exception {
    public InvalidOperation(String left, String right){
        super(left + " and " + right + " should be parsable to int");
    }
}
