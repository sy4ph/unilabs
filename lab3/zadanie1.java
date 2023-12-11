package lab3;

import java.util.Arrays;
import java.util.Random;

public class zadanie1 {
    public static void main(String[] args) {
        int arrayLength = 10;
        double[] randomArray = new double[arrayLength];
        Random random = new Random();

        for (int i = 0; i < arrayLength; i++) {
            randomArray[i] = random.nextDouble();
        }

        System.out.println("Неотсортированный массив:");
        for (double num : randomArray) {
            System.out.println(num);
        }

        Arrays.sort(randomArray);

        System.out.println("\nОтсортированный массив:");
        for (double num : randomArray) {
            System.out.println(num);
        }



        for (int i = 0; i < arrayLength; i++) {
            randomArray[i] = Math.random();
        }

        System.out.println("\nМассив:");
        for (double num : randomArray) {
            System.out.println(num);
        }

        Arrays.sort(randomArray);

        System.out.println("\nОтсортированный массив:");
        for (double num : randomArray) {
            System.out.println(num);
        }
    }
}
