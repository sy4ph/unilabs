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

        System.out.println("Кол-во сотрудников: ");
        n = source.nextInt();
        source.nextLine();

        format3[] emList = new format3[n];

        for (int i = 0; i < n; i++) {
            System.out.printf("Имя пользователя %d: ", i+1);
            x = source.nextLine();
            System.out.printf("Зарплата пользователя %d: ", i+1);
            y = source.nextDouble();
            format3 emp = new format3(x, y);
            emList[i] = emp;
            source.nextLine();
        }

        getReport(emList);
    }
}