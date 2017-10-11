package expressions;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import expressions.exceptions.ArithmeticException;

public class SqrtTest {

    private Expression term;
    private double delta;

    @Before
    public void setUp() {
        this.delta = 0.001;
    }

    @Test
    public void testSqrtOfZero() {
        term = new Constant(0);

        try {
            assertEquals(new Sqrt(term).evaluate(), 0, delta);
        } catch (ArithmeticException exception) {
            fail("Unexpected ArithmeticException");
        }
    }

    @Test
    public void testSqrtOfPositiveNumber() {
        term = new Constant(4);

        try {
            assertEquals(new Sqrt(term).evaluate(), 2, delta);
        } catch (ArithmeticException exception) {
            fail("Unexpected ArithmeticException");
        }
    }

    @Test
    public void testSqrtOfNegativeNumber() {
        term = new Constant(-1);

        try {
            new Sqrt(term).evaluate();
            fail("Unexpected ArithmeticException");
        } catch (ArithmeticException exception) {}
    }

    @Test
    public void testSqrtOfExpression() {
        term = new Sqrt(new Constant(16));

        try {
            assertEquals(new Sqrt(term).evaluate(), 2, delta);
        } catch (ArithmeticException exception) {
            fail("Unexpected ArithmeticException");
        }
    }
}