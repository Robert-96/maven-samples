package big;

import static org.junit.Assert.*;

import org.junit.runners.Parameterized;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(Parameterized.class)
public class BigDecimalOperationsTest {

    private Integer size;

    public BigDecimalOperationsTest(Integer size) {
        this.size = size;
    }

    @Parameterized.Parameters
    public static List<Integer> size() {
        return Arrays.stream(new int[] {10, 100, 1000, 10000, 100000, 1000000}).boxed().collect(Collectors.toList());

    }

    @Test
    public void testSum() {
        assertEquals(size.toString(), BigDecimalOperations.sum(BigDecimalCreator.create(size, "1")).toString());
    }

    @Test
    public void testAverage() {
        assertEquals("1", BigDecimalOperations.average(BigDecimalCreator.create(size, "1")).toString());
    }

    @Test
    public void testTopTenSize() {
        assertEquals(size / 10, BigDecimalOperations.topTen(BigDecimalCreator.create(size, "1")).size());
    }
}