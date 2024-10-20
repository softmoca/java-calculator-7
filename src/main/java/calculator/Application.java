package calculator;


import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        String delimiter;

        if (isCustomDelimiterPattern(input)) {
            delimiter = getCustomDelimiter(input);


           System.out.println("Yes"+delimiter);
        }

    }
    private static boolean isCustomDelimiterPattern(String input) {
        Pattern pattern = Pattern.compile("//(.)\\\\n.*");
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }


    private static String getCustomDelimiter(String input) {
        Pattern pattern = Pattern.compile("//(.)\\\\n.*");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            String delimiter = matcher.group(1);
            if (delimiter.matches("[0-9]")) {
                throw new IllegalArgumentException("숫자는 구분자로 사용할 수 없습니다.");
            }
            return delimiter;
        }

        throw new IllegalArgumentException("올바른 커스텀 구분자가 없습니다.");
    }


}