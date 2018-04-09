package rpn.Operator;

import org.junit.Test;
import rpn.exceptions.InvalidOperation;
import rpn.exceptions.InvalidOperator;

import java.util.ArrayList;
import java.util.Stack;

import static junit.framework.TestCase.assertEquals;

public class DivisionTest {
    @Test
    public void should_divide_two_number() throws Exception{
        Division division            = new Division();

        Stack<String> stackOperation = new Stack<String>();
        stackOperation.push("/");
        stackOperation.push("4");
        stackOperation.push("4");

        Stack<String> result    = division.operate(stackOperation);

        Stack<String> toCompare = new Stack<String>();
        toCompare.push("1.0");

        assertEquals(toCompare, result);
    }

    @Test(expected = InvalidOperator.class)
    public void should_throw_invalid_operator() throws Exception {
        Division division = new Division();

        Stack<String> stackOperation = new Stack<String>();
        stackOperation.push("+");
        stackOperation.push("2");
        stackOperation.push("2");

        division.operate(stackOperation);
    }

    @Test(expected = InvalidOperation.class)
    public void should_throw_invalid_operation() throws Exception {
        Division division = new Division();

        Stack<String> stackOperation = new Stack<String>();
        stackOperation.push("/");
        stackOperation.push("a");
        stackOperation.push("2");

        division.operate(stackOperation);
    }

    @Test(expected = InvalidOperation.class)
    public void should_throw_invalid_operation_if_only_one_number() throws Exception {
        Division division = new Division();

        Stack<String> stackOperation = new Stack<String>();
        stackOperation.push("/");
        stackOperation.push("2");

        division.operate(stackOperation);
    }

    @Test(expected = ArithmeticException.class)
    public void should_throw_an_error()throws Exception{
        Division division = new Division();

        Stack<String> stackOperation = new Stack<String>();
        stackOperation.push("/");
        stackOperation.push("0");
        stackOperation.push("2");

        division.operate(stackOperation);
    }
}
