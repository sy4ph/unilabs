package lab19;

public class BadFIO extends RuntimeException{
    public BadFIO(String errorMessage) {
        super(errorMessage);
    }
}