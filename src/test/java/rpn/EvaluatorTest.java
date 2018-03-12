package rpn;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import rpn.exceptions.InvalidExpression;
import rpn.exceptions.WrongOperatorException;

import java.util.Arrays;
import java.util.Collection;

import static jdk.nashorn.internal.objects.Global.Infinity;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(value = Parameterized.class)
public class EvaluatorTest {

    @Parameter(value = 0)
    public String[] array;

    @Parameter(value = 1)
    public Double result;

    @Parameter(value = 2)
    public Class<? extends Exception> expectedException;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Parameters(name = "{index}: testEvaluate({0}) = {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new String[]{"5"}, 5.0, null},
                {new String[]{"17"}, 17.0, null},
                {new String[]{"17", "5", "+"}, 22.0, null},
                {new String[]{"2", "3", "5", "+", "+"}, 10.0, null},
                {new String[]{"20", "5", "/"}, 4.0, null},
                {new String[]{"5", "2", "3", "+", "-"}, 0.0, null},
                {new String[]{"4", "2", "+", "3", "-"}, 3.0, null},
                {new String[]{"3", "5", "8", "*", "7", "+", "*"}, 141.0, null},
                {new String[]{"2", "1", "*"}, 2.0, null},
                {new String[]{"2", "1", "'*'"}, 2.0, null},
                {new String[]{"2", "1.5", "'*'"}, 3.0, null},
                {new String[]{"2", "-1", "'*'"}, -2.0, null},
                {new String[]{"2", "-1.5", "'*'"}, -3.0, null},
                {new String[]{"2", "0", "/"}, Infinity, null},
                {new String[]{"7", "2", "4"}, null, InvalidExpression.class},
                {new String[]{"7", "2", "-", "3", "4"}, null, InvalidExpression.class},
                {new String[]{"7", "2"}, null, InvalidExpression.class},
                {new String[]{"7", "2", ""}, null, WrongOperatorException.class},
                {new String[]{"7", "2", "_"}, null, WrongOperatorException.class},
                {new String[]{"+", "2", "+"}, null, NumberFormatException.class},
        });
    }

    @Test
    public void test_massExpression() throws InvalidExpression, WrongOperatorException {

        if (expectedException != null) {
            thrown.expect(expectedException);
        }

        assertThat(new Evaluator().evaluate(array), is(result));
    }

}
