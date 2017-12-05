import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.math.BigDecimal;

public class BigDecimalCreator {

    public static List<BigDecimal> create(int size){
        List<BigDecimal> bigDecimals = new ArrayList<>();

        Random random = new Random();

        for (int i = 0; i < size; i++){
            bigDecimals.add(new BigDecimal(random.nextInt() + "." + Math.abs(random.nextInt())));
        }

        return bigDecimals;
    }

    public static List<BigDecimal> create(int size, String value){
        List<BigDecimal> bigDecimals = new ArrayList<>();

        for (int i = 0; i < size; i++){
            bigDecimals.add(new BigDecimal(value));
        }

        return bigDecimals;
    }
}