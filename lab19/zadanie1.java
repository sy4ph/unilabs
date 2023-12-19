package lab19;

import java.util.InputMismatchException;
import java.util.Scanner;

public class zadanie1 {
    public static void main(String[] args) {
        validFIO();
        validINN();
        System.out.println("Good job mate!");
    }

    public static void validFIO() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input your full name: ");
        String fio;
        try{
            fio = sc.nextLine();
            if (fio.split(" ").length != 3) {
                throw new BadFIO("Come on, there are three words there.");
            }
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println("error mate, you failed");
        } catch (BadFIO badFIOArgumentsException) {
            System.out.println(badFIOArgumentsException.getMessage());
            validFIO();
        }
    }

    public static void validINN() {
        Scanner sc = new Scanner(System.in);
        String inn;
        System.out.println("Enter your ITN: ");
        try{
            inn = sc.nextLine();
            try{
                Long.parseLong(inn);
            } catch (NumberFormatException numberFormatException) {
                throw new BadINN("ITN should be a number.");
            }
            if (inn.length() != 12) {
                throw new BadINN("ITN should be 12 symbols long.");
            }

        } catch (InputMismatchException inputMismatchException) {
            System.out.println("Input a numper, please.");
        } catch (BadINN badINNArgumentsException) {
            System.out.println(badINNArgumentsException.getMessage());
            validINN();
        }
    }

}