package lab6and7;


public class MathFunc implements MathCalculable {
    public double calculatePower(double base, double power) {
        return Math.pow(base, power);
    }
    public double complexAbs(double real, double imaginary) {
        return Math.sqrt(Math.pow(real, 2) + Math.pow(imaginary, 2));

    }
    public double lengthCircle(double radius) {
        return 2 * MathCalculable.pi * radius;
    }

}
