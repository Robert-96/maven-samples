package expressions;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import expressions.exceptions.ArithmeticException;

public class DivisionTest {

    private Expression first;
    private Expression second;
    private double delta;

    @Before
    public void setUp() {
        this.delta = 0.001;
    }

    @Test
    public void testDivisionByZero() {
        first = new Constant(1);
        second = new Constant(0);

        try {
            new Division(first, second).evaluate();
            fail("Expect ArithmeticException");
        } catch (ArithmeticException exception) {}
    }

    @Test
    public void testDivideZero() {
        first = new Constant(0);
        second = new Constant(2);

        try {
            assertEquals(new Division(first, second).evaluate(), 0, delta);
        } catch (ArithmeticException exception) {
            fail("Unexpected ArithmeticException");
        }
    }

    @Test
    public void testDivisionWithPositiveNumbers() {
        first = new Constant(4);
        second = new Constant(2);

        try {
            assertEquals(new Division(first, second).evaluate(), 2, delta);
        } catch (ArithmeticException exception) {
            fail("Unexpected ArithmeticException");
        }
    }

    @Test
    public void testDivisionWithNegativeNumbers() {
        first = new Constant(-1);
        second = new Constant(-1);

        try {
            assertEquals(new Division(first, second).evaluate(), 1, delta);
        } catch (ArithmeticException exception) {
            fail("Unexpected ArithmeticException");
        }
    }

    @Test
    public void testDivisionWithExpressions() {
        first = new Division(new Constant(1), new Constant(1));
        second = new Division(new Constant(2), new Constant(2));

        try {
            assertEquals(new Division(first, second).evaluate(), 1, delta);
        } catch (ArithmeticException exception) {
            fail("Unexpected ArithmeticException");
        }
    }

    @Test
    public void testIdentityProperty() {
        first = new Constant(2);
        second = new Constant(1);

        try {
            assertEquals(new Division(first, second).evaluate(), first.evaluate(), delta);
        } catch (ArithmeticException exception) {
            fail("Unexpected ArithmeticException");
        }
    }
}