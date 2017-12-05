package big;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.math.BigDecimal;

public class BigDecimalOperations {

    public static BigDecimal sum(List<BigDecimal> bigDecimals){
        return bigDecimals.stream().reduce(BigDecimal::add).get();
    }

    public static BigDecimal average(List<BigDecimal> bigDecimals){
        return sum(bigDecimals).divide(new BigDecimal(String.valueOf(bigDecimals.size())));
    }

    public static List<BigDecimal> topTen(List<BigDecimal> list){
        return list.stream()
                .sorted(Comparator.reverseOrder())
                .limit(list.size()/10)
                .collect(Collectors.toList());
    }
}