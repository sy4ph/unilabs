package lab6and7;


public class ProcessStrings implements StrInterface {
    public int count(String str) {
        return str.length();
    }

    public String odd_only(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            if (i % 2 == 0) {
                result += str.charAt(i);
            }
        }
        return result;
    }

    public String reverse(String str) {
        String result = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            result += str.charAt(i);
        }
        return result;
    }

    
}