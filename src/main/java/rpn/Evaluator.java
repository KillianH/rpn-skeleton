package rpn;

import rpn.exceptions.InvalidExpression;
import rpn.exceptions.WrongOperatorException;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Evaluator
 * Can evaluate an expression given in the Reverse Polish Notation
 */
class Evaluator {

    private static final String PLUS = "+";

    private static final String MINUS = "-";

    private static final String MULTIPLY = "*";

    private static final String MULTIPLY_WINDOWS = "'*'";

    private static final String DIVIDE = "/";

    private static final String[] TOKENS = new String[]{"+", "-", "*", "'*'", "/"};

    /**
     * Evaluate an expression
     * @param args String[] members of the expression
     * @return Double result of the given expression
     * @throws WrongOperatorException when an operator in the given expression is not supported
     * @throws InvalidExpression when the given expression can't be fully evaluated
     */
    Double evaluate(String[] args) throws WrongOperatorException, InvalidExpression {
        ArrayList<String> expression = new ArrayList<>(Arrays.asList(args));
        ArrayList<String> tokens = new ArrayList<>(Arrays.asList(TOKENS));
        while(expression.size() != 1){
            boolean operatorFound = false;
            for (int i = 2; i<expression.size(); i++) {
                if(tokens.contains(expression.get(i))){
                    operatorFound = true;
                    String result = calculate(expression.get(i-2),expression.get(i-1),expression.get(i));
                    expression.remove(i);
                    expression.remove(i-1);
                    expression.set(i-2,result);
                    i -= 2;
                }else{
                    try {
                        Double.parseDouble(expression.get(i));
                    }catch (NumberFormatException e){
                        throw new WrongOperatorException(expression.get(i));
                    }
                }
            }
            if(!operatorFound){
                throw new InvalidExpression("No operator found", expression);
            }
        }
        return Double.parseDouble(expression.get(0));
    }

    /**
     * Calculate an expression
     * @param member1 first member of the expression
     * @param member2 second member of the expression
     * @param operator operator of the expression
     * @return String to replace the given index in the evaluate method
     * @throws WrongOperatorException when the given operator is not supported
     */
    private String calculate(String member1, String member2, String operator) throws WrongOperatorException {
        float result;
        switch (operator){
            case PLUS :
                result = Float.parseFloat(member1) + Float.parseFloat(member2);
                break;
            case MINUS :
                result = Float.parseFloat(member1) - Float.parseFloat(member2);
                break;
            case MULTIPLY :
                result = Float.parseFloat(member1) * Float.parseFloat(member2);
                break;
            case MULTIPLY_WINDOWS :
                result = Float.parseFloat(member1) * Float.parseFloat(member2);
                break;
            case DIVIDE :
                result = Float.parseFloat(member1) / Float.parseFloat(member2);
                break;
            default:
                throw new WrongOperatorException(operator);
        }
        return String.valueOf(result);
    }

}
