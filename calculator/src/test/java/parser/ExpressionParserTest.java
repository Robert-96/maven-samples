package parser;

import org.junit.Before;
import org.junit.Test;

import parser.exceptions.SyntaxErrorException;
import expressions.exceptions.ArithmeticException;

import static org.junit.Assert.*;

public class ExpressionParserTest {

    private ExpressionParser parser;

    @Before
    public void setUp() {
        parser = new ExpressionParser();
    }

    @Test
    public void testParserForAddition() {
        try {
            assertEquals(parser.parserExpression("1 + 2").evaluate(), 3, 0.001);
        } catch (SyntaxErrorException exception) {
            fail("Unexpected Syntax Error.");
        } catch (ArithmeticException exception) {
            fail("Unexpected Arithmetic Error.");
        }
    }

    @Test
    public void testParserForSubtraction() {
        try {
            assertEquals(parser.parserExpression("1 - 2").evaluate(), -1, 0.001);
        } catch (SyntaxErrorException exception) {
            fail("Unexpected Syntax Error.");
        } catch (ArithmeticException exception) {
            fail("Unexpected Arithmetic Error.");
        }
    }

    @Test
    public void testParserForMultiplication() {
        try {
            assertEquals(parser.parserExpression("1 * 2").evaluate(), 2, 0.001);
        } catch (SyntaxErrorException exception) {
            fail("Unexpected Syntax Error.");
        } catch (ArithmeticException exception) {
            fail("Unexpected Arithmetic Error.");
        }
    }

    @Test
    public void testParserForDivision() {
        try {
            assertEquals(parser.parserExpression("1 / 2").evaluate(), 0.5, 0.001);
        } catch (SyntaxErrorException exception) {
            fail("Unexpected Syntax Error.");
        } catch (ArithmeticException exception) {
            fail("Unexpected Arithmetic Error.");
        }
    }

    @Test
    public void testForNonRegisteredExpression() {
        try {
            assertEquals(parser.parserExpression("1 & 2").evaluate(), 0.5, 0.001);
            fail("Expect Syntax Error");
        } catch (SyntaxErrorException exception) {
        } catch (ArithmeticException exception) {
            fail("Unexpected Arithmetic Error.");
        }
    }

    @Test
    public void testWithoutExpressionSign() {
        try {
            assertEquals(parser.parserExpression("1 2").evaluate(), 0.5, 0.001);
            fail("Expect Syntax Error");
        } catch (SyntaxErrorException exception) {
        } catch (ArithmeticException exception) {
            fail("Unexpected Arithmetic Error.");
        }
    }
}