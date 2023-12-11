package lab6and7;

public class ConverterTest {
    public static void main(String[] args){
        double celsiusTemperature = 0;

        Convertable celToKel = new CelToKel();
        Convertable сelToFar = new CelToFar();

        double kelvinTemperature = celToKel.convert(celsiusTemperature);
        double fahrenheitTemperature = сelToFar.convert(celsiusTemperature);

        System.out.println(celsiusTemperature + " по цельсию = " + kelvinTemperature + " по кельвину");
        System.out.println(celsiusTemperature + " по цельсию = " + fahrenheitTemperature + " по фаренгейту");
    }
}
