package expressions;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import expressions.exceptions.ArithmeticException;

public class AdditionTest {

    private Expression first;
    private Expression second;
    private double delta;

    @Before
    public void setUp() {
        this.delta = 0.001;
    }

    @Test
    public void testAdditionWithPositiveNumbers() {
        first = new Constant(2);
        second = new Constant(2);

        try {
            assertEquals(new Addition(first, second).evaluate(), 4, delta);
        } catch (ArithmeticException exception) {
            fail("Unexpected ArithmeticException");
        }
    }

    @Test
    public void testAdditionWithNegativeNumbers() {
        first = new Constant(-1);
        second = new Constant(-1);

        try {
            assertEquals(new Addition(first, second).evaluate(), -2, delta);
        } catch (ArithmeticException exception) {
            fail("Unexpected ArithmeticException");
        }
    }

    @Test
    public void testAdditionWithExpressions() {
        first = new Addition(new Constant(1), new Constant(1));
        second = new Addition(new Constant(2), new Constant(2));

        try {
            assertEquals(new Addition(first, second).evaluate(), 6, delta);
        } catch (ArithmeticException exception) {
            fail("Unexpected ArithmeticException");
        }
    }

    @Test
    public void testCommutativeProperty() {
        first = new Constant(1);
        second = new Constant(2);

        try {
            assertEquals(new Addition(first, second).evaluate(), new Addition(second, first).evaluate(), delta);
        } catch (ArithmeticException exception) {
            fail("Unexpected ArithmeticException");
        }
    }

    @Test
    public void testIdentityProperty() {
        first = new Constant(1);
        second = new Constant(0);

        try {
            assertEquals(new Addition(first, second).evaluate(), first.evaluate(), delta);
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

    @Test
    public void testAssociativeProperty() {
        first = new Constant(1);
        second = new Constant(2);
        Expression third = new Constant(3);

        try {
            assertEquals(new Addition(new Addition(first, second), third).evaluate(), new Addition(first, new Addition(second, third)).evaluate(), delta);
        } catch (ArithmeticException exception) {
            fail("Unexpected ArithmeticException");
        }
    }
}