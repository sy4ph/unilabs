package lab8;
import java.util.Scanner;

public class zadanie5 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int N = 0;

        while (N <= 1) {
            System.out.print("Введите натуральное число больше 1: ");
            N = scanner.nextInt();
        }

        int sum = Calculator(N);
        System.out.println("Сумма цифр числа " + N + " = " + sum);
    }

    public static int Calculator(int num) {
        if (num < 10) {
            return num;
        } else {
            int lastDig = num % 10;
            int remDig = num / 10;
            int sumRemDig = Calculator(remDig);
            return lastDig + sumRemDig;
        }
    }
}
