package lab3;


public class format2tester {
    public static void main(String[] args) {

        format2 market = new format2(45000, 25000, 2000);

        market.addComputer();
        System.out.println("Компьютер = " + market.finalCost() + " руб");
        market.addMobilePhone();
        System.out.println("+ Телефон = " + market.finalCost() + " руб");
        market.addKeyBoard();
        System.out.println("+ Клавиатура = " + market.finalCost() + " руб");

        format1 ruble = new format1(market.finalCost());
        System.out.printf("\nИтог:\nДоллары: %.2f\nЕвро: %.2f\nФунты стерлингов: %.2f", ruble.getInDollars(), ruble.getInEuro(), ruble.getInIbs());
    }
}
