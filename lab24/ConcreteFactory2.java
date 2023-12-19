package lab24;

// ConcreteFactory2.java
public class ConcreteFactory2 implements ComplexAbstractFactory {
    @Override
    public Complex createComplex(double real, double image) {
        return new ConcreteComplex2(real, image);
    }
}
