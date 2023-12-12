package lab3;

import java.util.Scanner;

public class format3tester {
    public static void getReport(format3[] x){
        for (int i = 0; i < x.length; i++) {
            System.out.printf("\n%3s %10.2f", x[i].getFullName(), x[i].getSallary());
        }
    }

    public static void main(String[] args) {
        String x;
        double y;
        int n;

        Scanner source = new Scanner(System.in);

        System.out.println("Employees: ");
        n = source.nextInt();
        source.nextLine();
        source.close();
        format3[] emList = new format3[n];

        for (int i = 0; i < n; i++) {
            System.out.printf("User name %d: ", i+1);
            x = source.nextLine();
            System.out.printf("User salary %d: ", i+1);
            y = source.nextDouble();
            format3 emp = new format3(x, y);
            emList[i] = emp;
            source.nextLine();
        }

        getReport(emList);
    }
}