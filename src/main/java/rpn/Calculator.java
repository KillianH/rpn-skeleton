package rpn;

import rpn.Operator.*;
import rpn.Parser.Parser;
import rpn.exceptions.InvalidOperation;
import rpn.exceptions.InvalidOperator;

import java.util.ArrayList;

public class Calculator {
    private ArrayList<Operator> operations = new ArrayList<>();
    private Parser parser;

    Calculator(){
        operations.add(new Addition());
        operations.add(new Substraction());
        operations.add(new Multiplication());
        operations.add(new Division());
        parser = new Parser();
    }

    Calculator(ArrayList<Operator> operators){
        operations = operators;
    }

    private String beautifyResponse(ArrayList<String> toBeauty){
        StringBuffer res = new StringBuffer();

        for(String token : toBeauty){
            res.append(" " + token);
        }

        return res.toString().trim();
    }

    public String calculate(String calculation) throws InvalidOperation, InvalidOperator {
        ArrayList<String> stackRes = parser.parse(calculation);
        boolean hasOperator;
        boolean hasOperated;

        do{
            hasOperator = false;
            hasOperated = false;
            ArrayList<String> arrayRes = new ArrayList<String>(stackRes);

            for(int i = 0; i < arrayRes.size(); i++){
                String token = arrayRes.get(i);
                for(Operator operator : operations){
                    if(token.equals(operator.symbol)){
                        stackRes    = operator.operate(stackRes, i);
                        hasOperated = true;
                        hasOperator = true;
                    }
                    if(hasOperated) break;
                }
                if(hasOperated) break;
            }

        }
        while(hasOperator);


        return beautifyResponse(stackRes);
    }
}
