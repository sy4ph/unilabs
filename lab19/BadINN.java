package lab19;

public class BadINN extends RuntimeException{
    public BadINN(String errorMessage) {
        super(errorMessage);
    }
}