
import java.util.Scanner;

public class task3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter array length: ");
        int n = scanner.nextInt();
        int[] b = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter a number " + (i+1) + ": ");
            b[i] = scanner.nextInt();
        }
        scanner.close();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += b[i];
        }

        double sred = sum / b.length;

        System.out.println("Sum: ");
        System.out.println(sum);
        System.out.println("Average: ");
        System.out.println(sred);

    }
}