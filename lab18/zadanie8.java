package lab18;

import java.util.Scanner;

public class zadanie8 {

    // Шаг 1
    // Изменение функции getKey() как просят в задании

    public static void getKey() {
        Scanner myScanner = new Scanner( System.in );

        for (int i = 0; i < 1;) {
            String key = myScanner.nextLine();
            try {
                printDetails(key);
                i++;
            }
            catch ( Exception e) {
                System.out.println( "try again" );
            }
        }
    }

    public static void printDetails(String key) throws Exception {
        try {
            String message = getDetails(key);
            System.out.println( message );
        }
        catch ( Exception e) {
            throw e;
        }
    }

    private static String getDetails(String key) throws Exception {
        if(key == "") {
            throw new Exception( "Key set to empty string" );
        }
        return "data for " + key;
    }

    public static void main(String[] args) throws Exception {
        getKey();
    }

}
