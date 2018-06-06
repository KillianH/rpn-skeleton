package rpn.EventOperator;

import rpn.Event.Event;
import rpn.exceptions.InvalidOperation;

import java.util.ArrayList;

public class Operator2OperandEvent extends Event {
    public double            leftOperand;
    public double            rightOperand;
    public int               operatorIndex;
    public int               toRemove = 1;
    public ArrayList<String> operation;

    public Operator2OperandEvent(String name, ArrayList<String> operation, int operatorIndex) throws InvalidOperation {
        super(name);

        this.operatorIndex   = operatorIndex;
        this.operation       = operation;

        try{

            operatorIndex -= 1;
            if(operatorIndex < 0){
                this.leftOperand = 0;
            }
            else{
                this.leftOperand = Double.parseDouble(operation.get(operatorIndex));
                toRemove += 1;
            }
        }catch (Exception e){
            String leftOperand = operation.get(operatorIndex);
            String rightOperand = "";
            operatorIndex -= 1;
            if(operatorIndex < 0){
                rightOperand = "0";
            }else{
                rightOperand = operation.get(operatorIndex);
            }
            throw new InvalidOperation(leftOperand,rightOperand);
        }

        try{
            operatorIndex -= 1;
            if(operatorIndex < 0){
                this.rightOperand = 0;
            }
            else{
                this.rightOperand = Double.parseDouble(operation.get(operatorIndex));
                toRemove += 1;
            }
        }catch (Exception e){
            throw new InvalidOperation(operation.get(operatorIndex), Double.toString(leftOperand));
        }
    }
}
