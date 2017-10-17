package parser;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import expressions.Addition;

import java.util.HashSet;
import java.util.Set;

public class ExpressionsListTest {

    private ExpressionsList expressions;

    @Before
    public void setUp() {
        expressions = new ExpressionsList();
    }

    @Test
    public void testRegisterExpression() {
        expressions.registerExpression("+", Addition.class);
        assertTrue(expressions.isRegistered(Addition.class));
    }

    @Test
    public void testGetExpression() {
        expressions.registerExpression("+", Addition.class);
        assertEquals(expressions.getExpression("+"), Addition.class);
    }

    @Test
    public void testGetSigns() {
        expressions.registerExpression("+", Addition.class);
        expressions.registerExpression("-", Addition.class);

        Set<String> set = new HashSet<>();
        set.add("+");
        set.add("-");

        assertEquals(expressions.getSigns(), set);
    }
}