
import java.util.Scanner;

public class task4 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter array length: ");
        int n = scanner.nextInt();
        if (n == 0) {
            scanner.close();
            return;
        }
        int[] b = new int[n];

        for (int i = 0; i < b.length; i++) {
            System.out.println("Enter a number " + (i+1) + ": ");
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

        System.out.println("Sum: ");
        System.out.println(sum);

        System.out.println("Minimum: ");
        System.out.println(min);

        System.out.println("Maximum: ");
        System.out.println(max);
        scanner.close();
    }
}
