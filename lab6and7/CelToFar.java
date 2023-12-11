package lab6and7;

class CelToFar implements Convertable {
    public double convert(double celsius) {
        return (celsius * 9/5) + 32;
    }
}
