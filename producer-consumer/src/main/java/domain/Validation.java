package domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

    public static boolean isValid(String string){
        String namePattern = "[a-zA-z]+";
        String CNPPattern = "[12345678]([1-9][0-9]|0[1-9])(0[1-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[01])(0[1-9]|[1-3][0-9]|4[0-6]|5[12])([0-9][0-9][1-9]|[0-9][1-9][0-9]|[1-9][0-9][0-9])[0-9]";
        String emailPattern = "[a-zA-Z._]+@[a-z]+.com";

        Pattern pattern = Pattern.compile(namePattern + "~" + namePattern + "~" + namePattern + "~" + CNPPattern + "~" + emailPattern);

        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }

}
