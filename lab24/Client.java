package lab24;

// Client.java
public class Client {
    public static void main(String[] args) {
        // Используем ConcreteFactory1
        ComplexAbstractFactory factory1 = new ConcreteFactory1();
        Complex complex1 = factory1.createComplex(1, 2);
        System.out.println("Complex 1: " + complex1);

        // Используем ConcreteFactory2
        ComplexAbstractFactory factory2 = new ConcreteFactory2();
        Complex complex2 = factory2.createComplex(1, 2);
        System.out.println("Complex 2: " + complex2);
    }
}
