package lab21;

import java.util.Arrays;

public class zadanie2_3<T> {
    private final T[] array;

    public zadanie2_3(int size) {
        array = (T[]) new Object[size];
    }

    public void set(int index, T value) {
        if (index < 0 || index >= array.length) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        array[index] = value;
    }

    public T get(int index) {
        if (index < 0 || index >= array.length) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        return array[index];
    }

    public int size() {
        return array.length;
    }


    public static void main(String[] args) {
        zadanie2_3<Integer> intArray = new zadanie2_3<>(4);
        intArray.set(0,2);
        intArray.set(1,4);
        intArray.set(2,6);
        intArray.set(3,3);
        System.out.println(Arrays.toString(intArray.array));
        System.out.println(intArray.get(2));

        zadanie2_3<Double> intArray1 = new zadanie2_3<>(4);
        intArray1.set(0,2.);
        intArray1.set(1,4.);
        intArray1.set(2,6.);
        intArray1.set(3,3.);
        System.out.println(Arrays.toString(intArray1.array));
        System.out.println(intArray1.get(2));
    }
}