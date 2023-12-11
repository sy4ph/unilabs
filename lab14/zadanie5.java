package lab14;
import java.util.Scanner;
import java.util.regex.Pattern;

public class zadanie5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите дату в формате dd/mm/yyyy: ");
        String input = scanner.nextLine();

        String pattern = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(19[0-9]{2}|[2-9][0-9]{3})$";

        if ((input.substring(0,5).equals("29/02")) && (Integer.parseInt(input.substring(6,10)) % 4 == 1)) {
            System.out.println("Cтрока не является правильной датой.");
            return;
        }

        if (isValidDate(input, pattern)) {
            System.out.println("Cтрока является правильной датой.");
        } else {
            System.out.println("Cтрока не является правильной датой.");
        }
    }

    public static boolean isValidDate(String input, String pattern) {
        return Pattern.matches(pattern, input);
    }
}