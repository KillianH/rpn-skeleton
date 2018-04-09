package rpn;

import org.junit.Test;
import rpn.exceptions.InvalidOperation;
import rpn.exceptions.InvalidOperator;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    @Test
    public void should_calculate_2_plus_2() throws InvalidOperator, InvalidOperation {
        Calculator calculator = new Calculator();

        assertEquals("4.0", calculator.calculate("2 2 +"));
    }

    @Test
    public void should_calculate_2_minus_2() throws InvalidOperator, InvalidOperation {
        Calculator calculator = new Calculator();

        assertEquals("0.0", calculator.calculate("2 2 -"));
    }

    @Test
    public void should_calculate_2_multiply_by_2() throws InvalidOperator, InvalidOperation {
        Calculator calculator = new Calculator();

        assertEquals("4.0", calculator.calculate("2 2 *"));
    }

    @Test
    public void should_calculate_2_divided_by_2() throws InvalidOperator, InvalidOperation {
        Calculator calculator = new Calculator();

        assertEquals("1.0", calculator.calculate("2 2 /"));
    }


    @Test
    public void should_calculate_2_plus_2_plus_2() throws InvalidOperator, InvalidOperation {
        Calculator calculator = new Calculator();

        assertEquals("6.0", calculator.calculate("2 2 + 2 +"));
    }
}
