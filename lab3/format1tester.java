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

        System.out.println("Enter rubles amount: ");
        format1tester ruble = new format1tester(source.nextDouble());
        source.close();
        System.out.printf("USD: %.2f\nEUR: %.2f\nGBP: %.2f", ruble.getInDollars(), ruble.getInEuro(), ruble.getInIbs());
    }
}