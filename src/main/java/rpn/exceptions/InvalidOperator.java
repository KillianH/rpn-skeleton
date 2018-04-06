package rpn.exceptions;

public class InvalidOperator extends Exception {
    public InvalidOperator(String wrongOperator, String rightOperator) {
        super(wrongOperator + "is not the right operator should have been : " + rightOperator);
    }
}
