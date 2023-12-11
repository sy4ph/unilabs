package lab6and7;


public class test {
    MathCalculable mc1 = new MathFunc();
    public static void main(String[] args) {
        test t1 = new test();
        System.out.println(t1.mc1.calculatePower(2, 3));
        System.out.println(t1.mc1.complexAbs(3, 4));
        System.out.println(t1.mc1.lengthCircle(3.));

    }
}
