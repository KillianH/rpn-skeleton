package rpn.Operator;

import org.junit.Test;
import rpn.exceptions.InvalidOperation;
import rpn.exceptions.InvalidOperator;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class SubstractionTest {
    @Test
    public void should_substract_two_number() throws Exception{
        Substraction substract = new Substraction();

        ArrayList<String> stackOperation = new ArrayList<String>();
        stackOperation.add("4");
        stackOperation.add("4");
        stackOperation.add("-");

        ArrayList<String> toCompare = new ArrayList<String>();
        toCompare.add("0.0");

        assertEquals(toCompare, substract.operate(stackOperation, 2));
    }

    @Test(expected = InvalidOperator.class)
    public void should_throw_invalid_operator() throws Exception {
        Substraction substract = new Substraction();

        ArrayList<String> stackOperation = new ArrayList<String>();
        stackOperation.add("2");
        stackOperation.add("2");
        stackOperation.add("+");

        substract.operate(stackOperation, 2);
    }

    @Test(expected = InvalidOperation.class)
    public void should_throw_invalid_operation() throws Exception {
        Substraction substract = new Substraction();

        ArrayList<String> stackOperation = new ArrayList<String>();
        stackOperation.add("a");
        stackOperation.add("2");
        stackOperation.add("-");

        substract.operate(stackOperation, 2);
    }

    @Test
    public void should_return_negative_if_only_one_number() throws Exception {
        Substraction substract = new Substraction();

        ArrayList<String> stackOperation = new ArrayList<String>();
        stackOperation.add("2");
        stackOperation.add("-");

        ArrayList<String> toCompare = new ArrayList<>();
        toCompare.add("-2.0");

        assertEquals(toCompare, substract.operate(stackOperation, 1));
    }
}
