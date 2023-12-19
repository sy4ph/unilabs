package lab18;

import java.util.Scanner;

public class zadanie3 {

    // Шаг 1
    // Добавление нового пункта catch, чтобы поймать общее исключение класса Exception
    public static void exceptionDemo() {
        Scanner myScanner = new Scanner( System.in);
        System.out.print( "Enter an integer ");
        String intString = myScanner.next();

        try {
            int i = Integer.parseInt(intString);
            System.out.println(2 / i);
        }
        catch (Exception e) {
            System.out.println("error");
        }
//        catch (NumberFormatException e) {
//            System.out.println("Введено не integer значение");
//        }
//        catch (ArithmeticException e) {
//            System.out.println("Попытка деления на 0");
//        }
    }


    // Шаг 2
    // При добавлении нового пункта catch с исключением класса Exception в последующих пунктах выбрасываются ошибки:
    // exception java.lang.NumberFormatException has already been caught
    // exception java.lang.ArithmeticException has already been caught
    //
    // То есть пункт catch с исключением класса Exception обрабатывает все виды исключений,
    // из-за чего последующие пункты catch становятся ненужными

    public static void main(String[] args) {
        exceptionDemo();
    }
}
