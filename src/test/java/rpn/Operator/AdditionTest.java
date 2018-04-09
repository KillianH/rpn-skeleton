package rpn.Operator;

import org.junit.Test;
import rpn.exceptions.InvalidOperation;
import rpn.exceptions.InvalidOperator;

import java.util.Stack;

public class AdditionTest {
    @Test
    public void should_add_two_number() throws Exception{
        Addition addition = new Addition();

        Stack<String> stackOperation = new Stack<String>();
        stackOperation.push("+");
        stackOperation.push("4");
        stackOperation.push("4");

        Stack<String> result = addition.operate(stackOperation);
        result.pop().equals("8.0");
    }

    @Test(expected = InvalidOperator.class)
    public void should_throw_invalid_operator() throws Exception {
        Addition addition = new Addition();

        Stack<String> stackOperation = new Stack<String>();
        stackOperation.push("-");
        stackOperation.push("2");
        stackOperation.push("2");

        Stack<String> result = addition.operate(stackOperation);
    }

    @Test(expected = InvalidOperation.class)
    public void should_throw_invalid_operation() throws Exception {
        Addition addition = new Addition();

        Stack<String> stackOperation = new Stack<String>();
        stackOperation.push("+");
        stackOperation.push("a");
        stackOperation.push("2");

        Stack<String> result = addition.operate(stackOperation);
    }

    @Test(expected = InvalidOperation.class)
    public void should_throw_invalid_operation_if_only_one_number() throws Exception {
        Addition addition = new Addition();

        Stack<String> stackOperation = new Stack<String>();
        stackOperation.push("+");
        stackOperation.push("2");

        Stack<String> result = addition.operate(stackOperation);
    }
}
