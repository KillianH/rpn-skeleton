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
    public double apply(double a, double b) { return a - b; }

    @Override
    public ArrayList<Double> getOperand(ArrayList<String> operation, int indexOperator) throws InvalidOperation {
        ArrayList<String> res = new ArrayList<>();
        ArrayList<Double> doubleRes = new ArrayList<>();

        try{
            res.add(operation.get(--indexOperator));
            operation.remove(indexOperator);
            if(indexOperator <= 0){

                res.add("0");
            }else{
                res.add(operation.get(--indexOperator));
                operation.remove(indexOperator);
            }

            doubleRes.add(parseDouble(res.get(0)));
            doubleRes.add(parseDouble(res.get(1)));
        }catch(Exception e){
            throw new InvalidOperation(res.get(1), res.get(0));
        }

        return doubleRes;
    }
}
