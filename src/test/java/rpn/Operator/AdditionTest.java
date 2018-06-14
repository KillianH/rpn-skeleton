package rpn.Operator;

import org.junit.Test;
import rpn.exceptions.InvalidOperation;
import rpn.exceptions.InvalidOperator;

import java.util.ArrayList;
import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class AdditionTest {
    @Test
    public void should_add_two_number() throws Exception{
        Addition addition = new Addition();

        ArrayList<String> stackOperation = new ArrayList<String>();
        stackOperation.add("4");
        stackOperation.add("4");
        stackOperation.add("+");

        ArrayList<String> toCompare = new ArrayList<String>();
        toCompare.add("8.0");

        assertEquals(toCompare, addition.operate(stackOperation, 2));
    }

    @Test(expected = InvalidOperator.class)
    public void should_throw_invalid_operator() throws Exception {
        Addition addition = new Addition();

        ArrayList<String> stackOperation = new ArrayList<String>();
        stackOperation.add("2");
        stackOperation.add("2");
        stackOperation.add("-");

        addition.operate(stackOperation, 2);
    }

    @Test(expected = InvalidOperation.class)
    public void should_throw_invalid_operation() throws Exception {
        Addition addition = new Addition();

        ArrayList<String> stackOperation = new ArrayList<String>();
        stackOperation.add("a");
        stackOperation.add("2");
        stackOperation.add("+");

        addition.operate(stackOperation, 2);
    }

    @Test(expected = InvalidOperation.class)
    public void should_throw_invalid_operation_if_only_one_number() throws Exception {
        Addition addition = new Addition();

        ArrayList<String> stackOperation = new ArrayList<String>();
        stackOperation.add("2");
        stackOperation.add("+");

        addition.operate(stackOperation, 1);
    }
}
