package rpn.Operator;

import rpn.exceptions.InvalidOperation;
import rpn.exceptions.InvalidOperator;

import java.util.Stack;

import static java.lang.Integer.parseInt;

public abstract class Operator2Operands extends Operator {
    Operator2Operands(String symbol) {
        super(symbol);
    }

    public abstract int apply(int a, int b);

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

        operation.push(String.valueOf(apply(intA, intB)));
        return operation;
    }
}
