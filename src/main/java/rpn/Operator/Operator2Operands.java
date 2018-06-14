package rpn.Operator;

import rpn.Event.EventDispatcher;
import rpn.exceptions.InvalidOperation;
import rpn.exceptions.InvalidOperator;

import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Double.parseDouble;

public abstract class Operator2Operands extends Operator {
    Operator2Operands(String symbol) {
        super(symbol);
    }

    public abstract double apply(double a, double b);

    public ArrayList<Double> getOperand(ArrayList<String> operation, int index) throws InvalidOperation {
//        ArrayList<String> operation = (ArrayList<String>) originalOperation.clone();
        ArrayList<String> res = new ArrayList<>();
        ArrayList<Double> doubleRes = new ArrayList<>();
        try{
            res.add(operation.get(--index));
            operation.remove(index);
            res.add(operation.get(--index));
            operation.remove(index);

            doubleRes.add(parseDouble(res.get(0)));
            doubleRes.add(parseDouble(res.get(1)));
        }catch(Exception e){
            throw new InvalidOperation(res.size() < 2 ? "" : res.get(1), res.size() < 1 ? "" : res.get(0));
        }

        return doubleRes;
    }

    public ArrayList<String> operate(ArrayList<String> operation, int indexOperator) throws InvalidOperator, InvalidOperation {
        String symbol = operation.get(indexOperator);
        operation.remove(indexOperator);

        if(!symbol.equals(this.symbol)) throw new InvalidOperator(symbol, this.symbol);

        ArrayList<Double> doubleOperand = getOperand(operation,indexOperator);

        System.out.println(Arrays.toString(operation.toArray()));
        System.out.println(Arrays.toString(doubleOperand.toArray()));

        while(indexOperator - doubleOperand.size() < 0){
            indexOperator++;
        }

        operation.add(indexOperator - doubleOperand.size(), String.valueOf(apply(doubleOperand.get(1), doubleOperand.get(0))));

        System.out.println(Arrays.toString(operation.toArray()));

        return operation;
    }
}
