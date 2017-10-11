package expressions;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import expressions.exceptions.ArithmeticException;

public class MultiplicationTest {

    private Expression first;
    private Expression second;
    private double delta;

    @Before
    public void setUp() {
        this.delta = 0.001;
    }

    @Test
    public void testMultiplicationWithZero() {
        first = new Constant(2);
        second = new Constant(0);

        try {
            assertEquals(new Multiplication(first, second).evaluate(), 0, delta);
        } catch (ArithmeticException exception) {
            fail("Unexpected ArithmeticException");
        }
    }

    @Test
    public void testMultiplicationWithPositiveNumbers() {
        first = new Constant(2);
        second = new Constant(2);

        try {
            assertEquals(new Multiplication(first, second).evaluate(), 4, delta);
        } catch (ArithmeticException exception) {
            fail("Unexpected ArithmeticException");
        }
    }

    @Test
    public void testMultiplicationWithNegativeNumbers() {
        first = new Constant(-1);
        second = new Constant(-1);

        try {
            assertEquals(new Multiplication(first, second).evaluate(), 1, delta);
        } catch (ArithmeticException exception) {
            fail("Unexpected ArithmeticException");
        }
    }

    @Test
    public void testMultiplicationWithExpressions() {
        first = new Multiplication(new Constant(2), new Constant(2));
        second = new Multiplication(new Constant(3), new Constant(3));

        try {
            assertEquals(new Multiplication(first, second).evaluate(), 36, delta);
        } catch (ArithmeticException exception) {
            fail("Unexpected ArithmeticException");
        }
    }

    @Test
    public void testIdentityProperty() {
        first = new Constant(2);
        second = new Constant(1);

        try {
            assertEquals(new Multiplication(first, second).evaluate(), first.evaluate(), delta);
        } catch (ArithmeticException exception) {
            fail("Unexpected ArithmeticException");
        }
    }

    @Test
    public void testCommutativeProperty() {
        first = new Constant(2);
        second = new Constant(1);

        try {
            assertEquals(new Multiplication(first, second).evaluate(), new Multiplication(second, first).evaluate(), delta);
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
            assertEquals(new Multiplication(new Multiplication(first, second), third).evaluate(), new Multiplication(first, new Multiplication(second, third)).evaluate(), delta);
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
            assertEquals(new Multiplication(factor, new Addition(first, second)).evaluate(), new Addition(new Multiplication(factor, first), new Multiplication(factor, second)).evaluate(), delta);
        } catch (ArithmeticException exception) {
            fail("Unexpected ArithmeticException");
        }
    }
}