package rpn.Operator;

import rpn.exceptions.InvalidOperation;
import rpn.exceptions.InvalidOperator;

import java.util.ArrayList;

import static java.lang.Double.parseDouble;

public class Substraction extends Operator2Operands {
    public Substraction() {
        super("-");
    }

    @Override
    public double apply(double a, double b) {
        return a - b;
    }

    @Override
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
            if(indexOperator <= 0){
                leftOperand = "0";
            }else{
                leftOperand = operation.get(--indexOperator);
                operation.remove(indexOperator);
            }

            doubleRightOperand = parseDouble(rightOperand);
            doubleLeftOperand  = parseDouble(leftOperand);
        }catch(Exception e){
            throw new InvalidOperation(leftOperand, rightOperand);
        }


        operation.add(indexOperator, String.valueOf(apply(doubleLeftOperand, doubleRightOperand)));
        return operation;
    }
}
