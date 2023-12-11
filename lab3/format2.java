package lab3;

public class format2 {

    private double computer;

    private double mobilePhone;

    private double keyBoard;

    private double basket = 0;

    public format2(double computer, double mobilePhone, double keyBoard) {
        this.computer = computer;
        this.mobilePhone = mobilePhone;
        this.keyBoard = keyBoard;
    }

    public void addComputer() {this.basket += computer;}

    public void addMobilePhone() {this.basket += mobilePhone;}

    public void addKeyBoard() {this.basket += keyBoard;}

    public double finalCost() {return basket;}

    public void cleanBasket() {
        System.out.println("\nКорзина очищена.");
        this.basket = 0;
    }
}
