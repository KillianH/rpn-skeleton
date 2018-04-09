package rpn.Operator;

import rpn.exceptions.InvalidOperation;
import rpn.exceptions.InvalidOperator;

import java.util.Stack;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public abstract class Operator2Operands extends Operator {
    Operator2Operands(String symbol) {
        super(symbol);
    }

    public abstract double apply(double a, double b);

    public Stack<String> operate(Stack<String> operation) throws InvalidOperator, InvalidOperation {
        String a = "";
        String b = "";
        double doubleA, doubleB;

        try{
            a       = operation.pop();
            b       = operation.pop();

            doubleA = parseDouble(a);
            doubleB = parseDouble(b);
        }catch(Exception e){
            throw new InvalidOperation(a, b);
        }

        String symbol = operation.pop();

        if(!symbol.equals(this.symbol)) throw new InvalidOperator(symbol, this.symbol);


        operation.push(String.valueOf(apply(doubleA, doubleB)));
        return operation;
    }
}
