package lab24;

// ConcreteComplex1.java
public class ConcreteComplex1 implements Complex {
    private final double real;
    private final double image;

    public ConcreteComplex1(double real, double image) {
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
        return real + " + " + image + "i";
    }
}
