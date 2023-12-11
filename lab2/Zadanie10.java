package lab2;

import java.util.Scanner;

public class Zadanie10 {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();
        if (str == "") return;

        int n = 1;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') n++;
        }

        System.out.println(n);
    }
}
