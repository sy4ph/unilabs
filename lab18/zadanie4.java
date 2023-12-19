package lab18;

import java.util.Scanner;

public class zadanie4 {

    public static void exceptionDemo() {
        Scanner myScanner = new Scanner( System.in);
        System.out.print( "Enter an integer ");
        String intString = myScanner.next();

        try {
            int i = Integer.parseInt(intString);
            System.out.println(2 / i);
        }
        catch (NumberFormatException e) {
            System.out.println("not an integer");
        }
        catch (ArithmeticException e) {
            System.out.println("zero division");
        }
        finally {
            System.out.println("this text is in finally block!");
        }
    }

    public static void main(String[] args) {
        exceptionDemo();
    }
}
