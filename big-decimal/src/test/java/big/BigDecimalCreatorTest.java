package big;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.List;
import java.math.BigDecimal;

public class BigDecimalCreatorTest {

    @Test
    public void testCreate() {
        assertEquals(50, BigDecimalCreator.create(50).size());
    }

    @Test
    public void testSizeForCreateWithValue() {
        assertEquals(50, BigDecimalCreator.create(50, "1.1").size());
    }

    @Test
    public void testElementsForCreateWithValue() {
        List<BigDecimal> bigDecimals = BigDecimalCreator.create(50, "1.1");

        for (BigDecimal bigDecimal : bigDecimals) {
            assertEquals("1.1", bigDecimal.toString());
        }
    }
}