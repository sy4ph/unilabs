package lab14;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class zadanie3 {
    public static void main(String[] args) {
        List<String> text = new ArrayList<>();
        text.add("25.98 USD");
        text.add("44 ERR");
        text.add("1200.0 RUB");
        text.add("0.004 EU");
        text.add("15.50 USD");
        text.add ("100.0 RUB");

        List<String> validLines = extractValidPrices(text);

        for (String line : validLines) {
            System.out.println(line);
        }
    }

    public static List<String> extractValidPrices(List<String> text) {
        List<String> validLines = new ArrayList<>();
        String pattern = "\\d+\\.\\d+ (USD|RUB|EU)";

        for (String line : text) {

            String tline = "";

            for (int i = 0; i < line.length(); i++) {
                Character ch = line.charAt(i);
                if ("0123456789.".contains(ch.toString())) {
                    tline = tline + ch;
                }
            }

            if (Double.parseDouble(tline) * 1000 < 10) continue;

            Matcher matcher = Pattern.compile(pattern).matcher(line);
            if (matcher.find()) {
                validLines.add(line);
            }
        }

        return validLines;
    }
}
