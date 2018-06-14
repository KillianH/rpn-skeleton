package rpn.Operator;

import org.junit.Test;
import rpn.exceptions.InvalidOperation;
import rpn.exceptions.InvalidOperator;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class MultiplicationTest {
    @Test
    public void should_multiply_two_number() throws Exception{
        Multiplication multiplication = new Multiplication();

        ArrayList<String> stackOperation = new ArrayList<String>();
        stackOperation.add("4");
        stackOperation.add("4");
        stackOperation.add("*");

        ArrayList<String> toCompare = new ArrayList<String>();
        toCompare.add("16.0");

        assertEquals(toCompare, multiplication.operate(stackOperation, 2));
    }

    @Test(expected = InvalidOperator.class)
    public void should_throw_invalid_operator() throws Exception {
        Multiplication multiplication = new Multiplication();

        ArrayList<String> stackOperation = new ArrayList<String>();
        stackOperation.add("2");
        stackOperation.add("2");
        stackOperation.add("+");

        multiplication.operate(stackOperation, 2);
    }

    @Test(expected = InvalidOperation.class)
    public void should_throw_invalid_operation() throws Exception {
        Multiplication multiplication = new Multiplication();

        ArrayList<String> stackOperation = new ArrayList<String>();
        stackOperation.add("a");
        stackOperation.add("2");
        stackOperation.add("*");

        multiplication.operate(stackOperation, 2);
    }

    @Test(expected = InvalidOperation.class)
    public void should_throw_invalid_operation_if_only_one_number() throws Exception {
        Multiplication multiplication = new Multiplication();

        ArrayList<String> stackOperation = new ArrayList<String>();
        stackOperation.add("2");
        stackOperation.add("*");

        multiplication.operate(stackOperation, 1);
    }
}
