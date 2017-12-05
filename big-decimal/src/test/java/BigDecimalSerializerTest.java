import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(Parameterized.class)
public class BigDecimalSerializerTest {

    private Integer size;

    public BigDecimalSerializerTest(Integer size) {
        this.size = size;
    }

    @Parameterized.Parameters
    public static List<Integer> size() {
        return Arrays.stream(new int[] {10, 100, 1000, 10000, 100000, 1000000}).boxed().collect(Collectors.toList());

    }

    @Test
    public void testSerializeAndDeserializeBigDecimals() {
        BigDecimalSerializer.serializeBigDecimals(BigDecimalCreator.create(size), "src/main/resources/big_decimals.json");
        List<BigDecimal> bigDecimals = BigDecimalSerializer.deserializeBigDecimals("src/main/resources/big_decimals.json");

        assertEquals((int) size, bigDecimals.size());
    }

    @Test
    public void testSerializeAndDeserializeBigDecimalsForValues() {
        BigDecimalSerializer.serializeBigDecimals(BigDecimalCreator.create(size, "1.1"), "src/main/resources/big_decimals.json");
        List<BigDecimal> bigDecimals = BigDecimalSerializer.deserializeBigDecimals("src/main/resources/big_decimals.json");

        for (BigDecimal bigDecimal : bigDecimals) {
            assertEquals("1.1", bigDecimal.toString());
        }
    }
}