package big;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

public class BigDecimalSerializer {

    public static void serializeBigDecimals(List<BigDecimal> numbers, String fileName){

        try(ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)))) {

            out.writeObject(numbers.size());
            for(BigDecimal number: numbers){
                out.writeObject(number);
            }

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static List<BigDecimal> deserializeBigDecimals(String fileName){
        List<BigDecimal> bigDecimals = new ArrayList<>();

        try(ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileName)))) {

            try {
                Integer size = (Integer) in.readObject();

                while (size > 0) {
                    bigDecimals.add((BigDecimal) in.readObject());
                    size -= 1;
                }
            } catch(ClassNotFoundException e){
                e.printStackTrace();
            }

        } catch(IOException e){
            e.printStackTrace();
        }

        return bigDecimals;
    }
}