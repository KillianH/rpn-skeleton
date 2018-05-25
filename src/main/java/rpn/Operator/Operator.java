package rpn.Operator;

import rpn.exceptions.InvalidOperation;
import rpn.exceptions.InvalidOperator;

import java.util.ArrayList;

public abstract class Operator {
    public final String symbol;
    public abstract ArrayList<String> operate(ArrayList<String> operation, int index) throws InvalidOperator, InvalidOperation;
    Operator(String symbol){ this.symbol = symbol; }
}
