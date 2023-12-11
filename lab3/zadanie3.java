package lab3;

import java.util.Arrays;
import java.util.Random;

public class zadanie3 {
    public static void main(String[] args) {

        int arrayLength = 4;
        int[] randomArray = new int[arrayLength];
        Random random = new Random();

        for (int i = 0; i < arrayLength; i++) {
            randomArray[i] = random.nextInt(10,100);
        }

        for (int num : randomArray) {
            System.out.print(num + " ");
        }

        boolean flag = true;
        for (int i = 0; i < arrayLength-1; i++) {
            if (randomArray[i] > randomArray[i+1]) flag = false;
        }

        if (flag) {
            System.out.println("\nCтрого возрастающая последовательность");
        }

    }
}
