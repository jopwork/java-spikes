import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {

    @Test
    public void regexParse() {
        Pattern pattern = Pattern.compile("(\\d+(!?|\\*\\d+)[naxyzced])|//|[,:\\[\\]/]|(?<![a-zA-Z])N|[a-zA-Z]+");
        Matcher matcher = pattern.matcher(":4!c//8!n6!n[,3n][/[N]2!n[2!n]]\n");
        while(matcher.find()){
            System.out.println(matcher.group());
        }
    }
}
