package rpn.Operator;

import org.junit.Test;
import rpn.exceptions.InvalidOperation;
import rpn.exceptions.InvalidOperator;

import java.util.Stack;

public class DivisionTest {
    @Test
    public void should_multiply_two_number() throws Exception{
        Division division = new Division();

        Stack<String> stackOperation = new Stack<String>();
        stackOperation.push("4");
        stackOperation.push("4");
        stackOperation.push("/");

        Stack<String> result = division.operate(stackOperation);
        result.pop().equals("16");
    }

    @Test(expected = InvalidOperator.class)
    public void should_throw_invalid_operator() throws Exception {
        Division division = new Division();

        Stack<String> stackOperation = new Stack<String>();
        stackOperation.push("+");

        Stack<String> result = division.operate(stackOperation);
    }

    @Test(expected = InvalidOperation.class)
    public void should_throw_invalid_operation() throws Exception {
        Division division = new Division();

        Stack<String> stackOperation = new Stack<String>();
        stackOperation.push("2");
        stackOperation.push("a");
        stackOperation.push("/");

        Stack<String> result = division.operate(stackOperation);
    }

    @Test(expected = InvalidOperation.class)
    public void should_throw_invalid_operation_if_only_one_number() throws Exception {
        Division division = new Division();

        Stack<String> stackOperation = new Stack<String>();
        stackOperation.push("2");
        stackOperation.push("/");

        Stack<String> result = division.operate(stackOperation);
    }
}
