package lab8;
import java.util.Scanner;

public class zadanie7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;

        while (n <= 1) {
            System.out.print("Введите натуральное число больше 1: ");
            n = scanner.nextInt();
        }

        System.out.print("Простые множители числа " + n + ": ");

        for (int divisor = 2; divisor <= n; divisor++) {
            while (n % divisor == 0) {
                System.out.print(divisor + " ");
                n /= divisor;
            }
        }
    }
}
