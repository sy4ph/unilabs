package lab23;

import java.util.InputMismatchException;
import java.util.Scanner;

interface ArrayQueueADT<T> {
    void enqueue(T item);
    T element();
    T dequeue();
    int size();
    boolean isEmpty();
    void clear();
}

class ArrayQueue<T> implements ArrayQueueADT<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] array;
    private int size;
    private int front;
    private int rear;

    public ArrayQueue() {
        array = new Object[DEFAULT_CAPACITY];
        size = 0;
        front = 0;
        rear = 0;
    }

    @Override
    public void enqueue(T item) {
        ensureCapacity();
        array[rear] = item;
        rear = (rear + 1) % array.length;
        size++;
    }

    @Override
    public T element() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return (T) array[front];
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T item = (T) array[front];
        array[front] = null;
        front = (front + 1) % array.length;
        size--;
        return item;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
        size = 0;
        front = 0;
        rear = 0;
    }

    private void ensureCapacity() {
        if (size == array.length) {
            array = java.util.Arrays.copyOf(array, array.length * 2);
        }
    }
}

public class QueueDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayQueue<String> queue = new ArrayQueue<>();

        while (true) {
            System.out.println("1. Add an element  2. Show first element  3. Delete an element 4. Output length  5. Empty check  6. Clear  7. Quit");
            System.out.print("Choose an action: ");

            try {
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Input an element: ");
                        String item = scanner.next();
                        queue.enqueue(item);
                        break;
                    case 2:
                        try {
                            System.out.println("First element: " + queue.element());
                        } catch (IllegalStateException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;
                    case 3:
                        try {
                            System.out.println("Delete an element: " + queue.dequeue());
                        } catch (IllegalStateException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;
                    case 4:
                        System.out.println("Queue size: " + queue.size());
                        break;
                    case 5:
                        System.out.println(queue.isEmpty());
                        break;
                    case 6:
                        queue.clear();
                        System.out.println("Cleared");
                        break;
                    case 7:
                        scanner.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Incorrect input");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Incorrect input");
                scanner.next(); // Clear the invalid input from the scanner
            }
        }
    }
}
