package rpn.Operator;

import org.junit.Test;
import rpn.exceptions.InvalidOperation;
import rpn.exceptions.InvalidOperator;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class DivisionTest {
    @Test
    public void should_divide_two_number() throws Exception{
        Division division                = new Division();

        ArrayList<String> stackOperation = new ArrayList<String>();
        stackOperation.add("4");
        stackOperation.add("4");
        stackOperation.add("/");

        ArrayList<String> toCompare = new ArrayList<String>();
        toCompare.add("1.0");

        assertEquals(toCompare, division.operate(stackOperation, 2));
    }

    @Test(expected = InvalidOperator.class)
    public void should_throw_invalid_operator() throws Exception {
        Division division = new Division();

        ArrayList<String> stackOperation = new ArrayList<String>();
        stackOperation.add("2");
        stackOperation.add("2");
        stackOperation.add("+");

        division.operate(stackOperation, 2);
    }

    @Test(expected = InvalidOperation.class)
    public void should_throw_invalid_operation() throws Exception {
        Division division = new Division();

        ArrayList<String> stackOperation = new ArrayList<String>();
        stackOperation.add("a");
        stackOperation.add("2");
        stackOperation.add("/");

        division.operate(stackOperation, 2);
    }

    @Test(expected = InvalidOperation.class)
    public void should_throw_invalid_operation_if_only_one_number() throws Exception {
        Division division = new Division();

        ArrayList<String> stackOperation = new ArrayList<String>();
        stackOperation.add("2");
        stackOperation.add("/");

        division.operate(stackOperation, 1);
    }

    @Test(expected = ArithmeticException.class)
    public void should_throw_an_error()throws Exception{
        Division division = new Division();

        ArrayList<String> stackOperation = new ArrayList<String>();
        stackOperation.add("2");
        stackOperation.add("0");
        stackOperation.add("/");

        division.operate(stackOperation, 2);
    }
}
