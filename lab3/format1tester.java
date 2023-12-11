package lab3;

import java.util.Scanner;

public class format1tester {
    private double x;

    public format1tester(double x) {this.x = x;}

    public double getInDollars() {return x/96.04;}

    public double getInEuro() {return x/102.25;}

    public double getInIbs() {return x/118.02;}

    public static void main(String[] args) {
        Scanner source = new Scanner(System.in);

        System.out.println("Введите количество самой стабильной валюты в мире: ");
        format1tester ruble = new format1tester(source.nextDouble());

        System.out.printf("Доллары: %.2f\nЕвро: %.2f\nФунты стерлингов: %.2f", ruble.getInDollars(), ruble.getInEuro(), ruble.getInIbs());
    }
}