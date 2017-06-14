package textfiles;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexModule {

    public static boolean regexContains(String pattern, String input) {
        boolean ContainsResult = false;
            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(input);
            if (m.find()){
                ContainsResult = true;
            }
        return ContainsResult; 
        }
    public static String regexMatching(String pattern, String input) {
        String RegexResult = " ";
            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(input);
            if (m.find()){
                RegexResult = "match";
            }
        return RegexResult; 
        }
}
