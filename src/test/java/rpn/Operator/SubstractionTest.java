package rpn.Operator;

import org.junit.Test;
import rpn.exceptions.InvalidOperation;
import rpn.exceptions.InvalidOperator;

import java.util.Stack;

public class SubstractionTest {
    @Test
    public void should_substract_two_number() throws Exception{
        Substraction substract = new Substraction();

        Stack<String> stackOperation = new Stack<String>();
        stackOperation.push("-");
        stackOperation.push("4");
        stackOperation.push("4");

        Stack<String> result = substract.operate(stackOperation);
        result.pop().equals("0");
    }

    @Test(expected = InvalidOperator.class)
    public void should_throw_invalid_operator() throws Exception {
        Substraction substract = new Substraction();

        Stack<String> stackOperation = new Stack<String>();
        stackOperation.push("+");
        stackOperation.push("2");
        stackOperation.push("2");

        Stack<String> result = substract.operate(stackOperation);
    }

    @Test(expected = InvalidOperation.class)
    public void should_throw_invalid_operation() throws Exception {
        Substraction substract = new Substraction();

        Stack<String> stackOperation = new Stack<String>();
        stackOperation.push("-");
        stackOperation.push("a");
        stackOperation.push("2");

        Stack<String> result = substract.operate(stackOperation);
    }

    @Test(expected = InvalidOperation.class)
    public void should_throw_invalid_operation_if_only_one_number() throws Exception {
        Substraction substract = new Substraction();

        Stack<String> stackOperation = new Stack<String>();
        stackOperation.push("2");
        stackOperation.push("-");

        Stack<String> result = substract.operate(stackOperation);
    }
}
