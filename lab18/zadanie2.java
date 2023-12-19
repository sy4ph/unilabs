package lab18;

import java.util.Scanner;

public class zadanie2 {

    // Шаг 1
//    public static void exceptionDemo() {
//        Scanner myScanner = new Scanner( System.in);
//        System.out.print( "Enter an integer ");
//        String intString = myScanner.next();
//        int i = Integer.parseInt(intString);
//        System.out.println( 2/i );
//    }


    // Шаг 2
//     Выбрасываются ошибки:
//     NumberFormatException: For input string: "Qwerty"
//     ArithmeticException: / by zero
//     NumberFormatException: For input string: "1.2"
//     При вводе "1" ошибки нет и выводится "2"


    // Шаг 3
    // В блок try заключаем код с исключением, а в блок catch заключаем код с обработкой исключения
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
            System.out.println("zero division attempt");
        }
    }

    public static void main(String[] args) {
        exceptionDemo();
    }
}
