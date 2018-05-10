import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
    private static final Pattern pattern = Pattern.compile(
            "(\\d+(!?|\\*\\d+)[naxyzced])|//|[,:\\[\\]/]|(?<![a-zA-Z])N|[a-zA-Z]+");

    @Test
    public void regexParse() throws Exception {
        List<String> list = parseSwiftField(":4!c//8!n6!n[,3n][/[N]2!n[2!n]]");
        for(String s : list){
            System.out.println(s);
        }
    }

    private List<String> parseSwiftField(String fieldText) throws Exception {
        List<String> result = new ArrayList<>();
        Matcher matcher = pattern.matcher(fieldText);
        while(matcher.find()){
            result.add(matcher.group());
        }
        return result;
    }
}
