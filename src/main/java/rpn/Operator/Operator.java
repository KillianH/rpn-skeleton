package rpn.Operator;

import rpn.exceptions.InvalidOperation;
import rpn.exceptions.InvalidOperator;

import java.util.Stack;

public abstract class Operator {
    public String symbol;
    public abstract Stack<String> operate(Stack<String> operation) throws InvalidOperator, InvalidOperation;
}
