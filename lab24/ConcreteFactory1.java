package lab24;

// ConcreteFactory1.java
public class ConcreteFactory1 implements ComplexAbstractFactory {
    @Override
    public Complex createComplex(double real, double image) {
        return new ConcreteComplex1(real, image);
    }
}
