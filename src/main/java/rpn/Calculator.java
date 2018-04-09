package rpn;

import rpn.Operator.*;
import rpn.Parser.Parser;
import rpn.exceptions.InvalidOperation;
import rpn.exceptions.InvalidOperator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Stream;

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

    private String beautifyResponse(Stack toBeauty){
        StringBuffer res = new StringBuffer();

        while(!toBeauty.empty()){
            res.append(" " + toBeauty.pop());
        }

        return res.toString().trim();
    }

    public String calculate(String calculation) throws InvalidOperation, InvalidOperator {
        Stack<String> stackRes = parser.parse(new StringBuilder(calculation).reverse().toString());
        boolean hasOperator;
        boolean hasOperated;

        do{
            hasOperator = false;
            hasOperated = false;
            ArrayList<String> arrayRes = new ArrayList<String>(stackRes);
            System.out.println("array →" + arrayRes);

            System.out.println("stack →" + stackRes);

            for(String token : arrayRes){
                System.out.println(token);
                for(Operator operator : operations){
                    if(token.equals(operator.symbol)){
                        stackRes    = operator.operate(stackRes);
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
