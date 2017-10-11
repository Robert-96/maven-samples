package expressions;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import expressions.exceptions.ArithmeticException;

public class SubtractionTest {

    private Expression first;
    private Expression second;
    private double delta;

    @Before
    public void setUp() {
        this.delta = 0.001;
    }

    @Test
    public void testSubtractionZero() {
        first = new Constant(2);
        second = new Constant(0);

        try {
            assertEquals(new Subtraction(first, second).evaluate(), 2, delta);
        } catch (ArithmeticException exception) {
            fail("Unexpected ArithmeticException");
        }
    }

    @Test
    public void testSubtractionWithPositiveNumbers() {
        first = new Constant(4);
        second = new Constant(2);

        try {
            assertEquals(new Subtraction(first, second).evaluate(), 2, delta);
        } catch (ArithmeticException exception) {
            fail("Unexpected ArithmeticException");
        }
    }

    @Test
    public void testSubtractionWithNegativeNumbers() {
        first = new Constant(-1);
        second = new Constant(-1);

        try {
            assertEquals(new Subtraction(first, second).evaluate(), 0, delta);
        } catch (ArithmeticException exception) {
            fail("Unexpected ArithmeticException");
        }
    }

    @Test
    public void testSubtractionWithExpressions() {
        first = new Subtraction(new Constant(2), new Constant(1));
        second = new Subtraction(new Constant(4), new Constant(2));

        try {
            assertEquals(new Subtraction(first, second).evaluate(), -1, delta);
        } catch (ArithmeticException exception) {
            fail("Unexpected ArithmeticException");
        }
    }

    @Test
    public void testIdentityProperty() {
        first = new Constant(2);
        second = new Constant(0);

        try {
            assertEquals(new Subtraction(first, second).evaluate(), first.evaluate(), delta);
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
            assertEquals(new Multiplication(factor, new Subtraction(first, second)).evaluate(), new Subtraction(new Multiplication(factor, first), new Multiplication(factor, second)).evaluate(), delta);
        } catch (ArithmeticException exception) {
            fail("Unexpected ArithmeticException");
        }
    }
}