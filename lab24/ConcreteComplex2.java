package lab24;

// ConcreteComplex2.java
public class ConcreteComplex2 implements Complex {
    private final double real;
    private final double image;

    public ConcreteComplex2(double real, double image) {
        this.real = real;
        this.image = image;
    }

    @Override
    public double getReal() {
        return real;
    }

    @Override
    public double getImage() {
        return image;
    }

    @Override
    public String toString() {
        return real + " - " + image + "i";
    }
}
