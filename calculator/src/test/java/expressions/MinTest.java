package expressions;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import expressions.exceptions.ArithmeticException;

public class MinTest {

    private Expression first;
    private Expression second;
    private double delta;

    @Before
    public void setUp() {
        this.delta = 0.001;
    }

    @Test
    public void testMinWithPositiveNumbers() {
        first = new Constant(1);
        second = new Constant(2);

        try {
            assertEquals(new Min(first, second).evaluate(), 1, delta);
        } catch (ArithmeticException exception) {
            fail("Unexpected ArithmeticException");
        }
    }

    @Test
    public void testMinWithNegativeNumbers() {
        first = new Constant(-1);
        second = new Constant(-2);

        try {
            assertEquals(new Min(first, second).evaluate(), -2, delta);
        } catch (ArithmeticException exception) {
            fail("Unexpected ArithmeticException");
        }
    }

    @Test
    public void testMinWithExpressions() {
        first = new Min(new Constant(1), new Constant(2));
        second = new Min(new Constant(3), new Constant(4));

        try {
            assertEquals(new Min(first, second).evaluate(), 1, delta);
        } catch (ArithmeticException exception) {
            fail("Unexpected ArithmeticException");
        }
    }

    @Test
    public void testCommutativeProperty() {
        first = new Constant(1);
        second = new Constant(2);

        try {
            assertEquals(new Min(first, second).evaluate(), new Min(second, first).evaluate(), delta);
        } catch (ArithmeticException exception) {
            fail("Unexpected ArithmeticException");
        }
    }

    @Test
    public void testDistributiveProperty() {
        first = new Constant(1);
        second = new Constant(2);
        Expression factor = new Constant(3);

        try {
            assertEquals(new Multiplication(factor, new Min(first, second)).evaluate(), new Min(new Multiplication(factor, first), new Multiplication(factor, second)).evaluate(), delta);
        } catch (ArithmeticException exception) {
            fail("Unexpected ArithmeticException");
        }
    }

    @Test
    public void testAssociativeProperty() {
        first = new Constant(1);
        second = new Constant(2);
        Expression third = new Constant(3);

        try {
            assertEquals(new Min(new Min(first, second), third).evaluate(), new Min(first, new Min(second, third)).evaluate(), delta);
        } catch (ArithmeticException exception) {
            fail("Unexpected ArithmeticException");
        }
    }
}