package lab2;

import java.util.Scanner;

public class task8 {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt() + 1;

        String[] a = {};

        for (int i = 0; i < n; i++) {
            String str = scanner.nextLine();
            String[] newArr = new String[a.length + 1];
            for (i = 0; i < a.length; i++) {
                newArr[i] = a[i];
            }
            newArr[newArr.length - 1] = str + " ";
            a = newArr;
        }

        String temp;

        for (int i = 0; i < a.length/2; i++) {
            temp = a[a.length-i-1];
            a[a.length-i-1] = a[i];
            a[i] = temp;
        }

        for (int i=0; i<a.length; i++){
            System.out.print(a[i]);
        }
        scanner.close();
    }
}
