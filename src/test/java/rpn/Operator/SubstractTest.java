package rpn.Operator;

import org.junit.Test;
import rpn.exceptions.InvalidOperation;
import rpn.exceptions.InvalidOperator;

import java.util.Stack;

public class SubstractTest {
    @Test
    public void should_substract_two_number() throws Exception{
        Substract substract = new Substract();

        Stack<String> stackOperation = new Stack<String>();
        stackOperation.push("4");
        stackOperation.push("4");
        stackOperation.push("-");

        Stack<String> result = substract.operate(stackOperation);
        result.pop().equals("0");
    }

    @Test(expected = InvalidOperator.class)
    public void should_throw_invalid_operator() throws Exception {
        Substract substract = new Substract();

        Stack<String> stackOperation = new Stack<String>();
        stackOperation.push("+");

        Stack<String> result = substract.operate(stackOperation);
    }

    @Test(expected = InvalidOperation.class)
    public void should_throw_invalid_operation() throws Exception {
        Substract substract = new Substract();

        Stack<String> stackOperation = new Stack<String>();
        stackOperation.push("2");
        stackOperation.push("a");
        stackOperation.push("-");

        Stack<String> result = substract.operate(stackOperation);
    }

    @Test(expected = InvalidOperation.class)
    public void should_throw_invalid_operation_if_only_one_number() throws Exception {
        Substract substract = new Substract();

        Stack<String> stackOperation = new Stack<String>();
        stackOperation.push("2");
        stackOperation.push("-");

        Stack<String> result = substract.operate(stackOperation);
    }
}
