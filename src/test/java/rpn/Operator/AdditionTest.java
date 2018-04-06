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
        stackOperation.push("4");
        stackOperation.push("4");
        stackOperation.push("+");

        Stack<String> result = addition.operate(stackOperation);
        result.pop().equals("8");
    }

    @Test(expected = InvalidOperator.class)
    public void should_throw_invalid_operator() throws Exception {
        Addition addition = new Addition();

        Stack<String> stackOperation = new Stack<String>();
        stackOperation.push("-");

        Stack<String> result = addition.operate(stackOperation);
    }

    @Test(expected = InvalidOperation.class)
    public void should_throw_invalid_operation() throws Exception {
        Addition addition = new Addition();

        Stack<String> stackOperation = new Stack<String>();
        stackOperation.push("2");
        stackOperation.push("a");
        stackOperation.push("+");

        Stack<String> result = addition.operate(stackOperation);
    }

    @Test(expected = InvalidOperation.class)
    public void should_throw_invalid_operation_if_only_one_number() throws Exception {
        Addition addition = new Addition();

        Stack<String> stackOperation = new Stack<String>();
        stackOperation.push("2");
        stackOperation.push("+");

        Stack<String> result = addition.operate(stackOperation);
    }
}
