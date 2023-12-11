
import java.util.Scanner;

public class Zadanie4 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите величену массива: ");
        int n = scanner.nextInt();
        if (n == 0) return;

        int[] b = new int[n];

        for (int i = 0; i < b.length; i++) {
            System.out.println("Введите элемент " + (i+1) + ": ");
            b[i] = scanner.nextInt();
        }

        int sum = 0;
        int j = b.length - 1;
        while (j > 0) {
            sum += b[j];
            j--;
        }

        int min = b[0];
        int max = b[0];

        for (int i = 0; i < b.length; i++) {
            if (b[i] < min) min = b[i];
        }

        for (int i = 0; i < b.length; i++) {
            if (b[i] > max) max = b[i];
        }

        System.out.println("Сумма: ");
        System.out.println(sum);

        System.out.println("Минимальное: ");
        System.out.println(min);

        System.out.println("Максимальное: ");
        System.out.println(max);
    }
}
