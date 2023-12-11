
import java.util.Scanner;

public class Zadanie3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите величену массива: ");
        int n = scanner.nextInt();
        int[] b = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Введите элемент " + (i+1) + ": ");
            b[i] = scanner.nextInt();
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += b[i];
        }

        int sred = sum / b.length;

        System.out.println("Сумма: ");
        System.out.println(sum);
        System.out.println("Среднее значение: ");
        System.out.println(sred);

    }
}