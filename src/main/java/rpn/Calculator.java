package rpn;

import rpn.Operator.*;
import rpn.Parser.Parser;

import java.util.ArrayList;
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

    public String calculate(String calculation){
        Stack<String> stackRes = parser.parse(calculation);



        return String.valueOf(new ArrayList<>(stackRes));
    }
}
