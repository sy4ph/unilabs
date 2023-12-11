
public class Factorial {

    public static int factorial(int n) {
        if (n == 0) return 0;

        int b = 1;
        for (int i = 0; i < n; i++) {
            b = b * (i+1);
        }
        return b;
    }

}
