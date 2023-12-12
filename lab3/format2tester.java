package lab3;


public class format2tester {
    public static void main(String[] args) {

        format2 market = new format2(45000, 25000, 2000);

        market.addComputer();
        System.out.println("КComputer = " + market.finalCost() + " rub");
        market.addMobilePhone();
        System.out.println("+ Phone = " + market.finalCost() + " rub");
        market.addKeyBoard();
        System.out.println("+ Keyboard = " + market.finalCost() + " rub");

        format1 ruble = new format1(market.finalCost());
        System.out.printf("\nSumг:\nUSD: %.2f\nEUR: %.2f\nGBP: %.2f", ruble.getInDollars(), ruble.getInEuro(), ruble.getInIbs());
    }
}
