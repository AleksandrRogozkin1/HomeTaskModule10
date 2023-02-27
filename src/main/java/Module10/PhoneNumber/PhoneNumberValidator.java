package Module10.PhoneNumber;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PhoneNumberValidator {
    public static void validator(String phoneNumber){
        Pattern pattern1 =Pattern.compile("^\\d{3}[-]?\\d{3}[-]?\\d{4}$");
        Pattern pattern2 =Pattern.compile("^((\\(\\d{3}\\))|\\d{3})[- ]?\\d{3}[-]?\\d{4}$");
        Matcher matcher1 = pattern1.matcher(phoneNumber);
        Matcher matcher2 = pattern2.matcher(phoneNumber);
        if(matcher1.matches() || matcher2.matches()){
            System.out.println(phoneNumber);
        }
    }


}
