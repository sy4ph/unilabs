package lab18;

public class zadanie6 {
    public static void printMessage(String key) {

        // Шаг 3
        try {
            String message = getDetails(key);
            System.out.println(message);
        }
        catch (NullPointerException e) {
            System.out.println("null argument");
        }

    }

    public static String getDetails(String key) {
        if(key == null) {
            throw new NullPointerException("null key in getDetails");
        }
        return "data for " + key;
    }

    public static void main(String[] args) {

        // Шаг 1 и 2
        printMessage("something");
        printMessage(null);

    }
}