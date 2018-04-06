package rpn.Operator;

import rpn.exceptions.InvalidOperation;
import rpn.exceptions.InvalidOperator;

import java.util.Stack;

import static java.lang.Integer.parseInt;

public class Addition extends Operator {
    public String symbol = "+";

    @Override
    public Stack<String> operate(Stack<String> operation) throws InvalidOperator, InvalidOperation {
        String symbol = operation.pop();

        if(!symbol.equals(this.symbol)) throw new InvalidOperator(symbol, this.symbol);

        String a = "";
        String b = "";
        int intA, intB;

        try{
            a    = operation.pop();
            b    = operation.pop();

            intA = parseInt(a);
            intB = parseInt(b);
        }catch(Exception e){
            throw new InvalidOperation(a, b);
        }

        operation.push(String.valueOf(intA + intB));
        return operation;
    }
}
