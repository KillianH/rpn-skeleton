package rpn.Operator;

import rpn.Event.EventDispatcher;
import rpn.exceptions.InvalidOperation;
import rpn.exceptions.InvalidOperator;

import java.util.ArrayList;

import static java.lang.Double.parseDouble;

public abstract class Operator2Operands extends Operator {
    Operator2Operands(String symbol) {
        super(symbol);
    }

    public abstract double apply(double a, double b);

    public ArrayList<String> operate(ArrayList<String> operation, int indexOperator) throws InvalidOperator, InvalidOperation {
        String rightOperand = "";
        String leftOperand  = "";
        double doubleRightOperand, doubleLeftOperand;

        String symbol = operation.get(indexOperator);
        operation.remove(indexOperator);

        if(!symbol.equals(this.symbol)) throw new InvalidOperator(symbol, this.symbol);

        try{
            rightOperand = operation.get(--indexOperator);
            operation.remove(indexOperator);
            leftOperand  = operation.get(--indexOperator);
            operation.remove(indexOperator);

            doubleRightOperand = parseDouble(rightOperand);
            doubleLeftOperand  = parseDouble(leftOperand);
        }catch(Exception e){
            throw new InvalidOperation(leftOperand, rightOperand);
        }


        operation.add(indexOperator, String.valueOf(apply(doubleLeftOperand, doubleRightOperand)));
        return operation;
    }
}
