package lab18;

public class zadanie5 {

    // Шаг 1
    public static void getDetails(String key) {
        if(key == null) {
            throw new NullPointerException("null key in getDetails");
        }
    }

    public static void main(String[] args) {

        // Шаг 2
        try {
            getDetails(null);
        }
        catch (NullPointerException e) {
            System.out.println("null argument");
        }

    }
}
