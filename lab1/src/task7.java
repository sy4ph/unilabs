
import java.util.Scanner;
public class task7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input a number: ");
        int n = scanner.nextInt();
        scanner.close();
        if (n == 0) return;

        System.out.println(Factorial.factorial(n));

        scanner.close(); // Close the Scanner object
    }
}
