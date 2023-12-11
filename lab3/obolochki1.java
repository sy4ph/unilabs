package lab3;

import java.util.Scanner;

public class obolochki1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Double a = Double.valueOf(5);
        Double b = Double.valueOf(6.3);
        Double c = Double.valueOf(-10.37);

        System.out.println("Введите число: ");
        String str = scanner.nextLine();

        String result = "";

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (Character.isDigit(ch))
                result = result + ch;
            else
                result = result + (int)ch;
        }

        double val = Double.parseDouble(result);
        System.out.println(val);

        double x = 10.5;
        float x1 = (float)x;
        long x2 = (long)x;
        int x3 = (int)x;
        System.out.println(x);

        String d = Double.toString(3.14);
        System.out.println(d);
    }
}