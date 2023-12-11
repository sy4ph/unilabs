package lab4;
import java.util.Scanner;

public class magazin {

    public static class Product {
        public String nameProduct;
        double cost;

        Product(String nameProduct, double cost) {
            this.nameProduct = nameProduct;
            this.cost = cost;
        }
    }

    public static class Category {
        String nameCategory;
        Product[] products;

        Category(String nameCategory, Product[] products) {
            this.nameCategory = nameCategory;
            this.products = products;
        }
    }

    public static class Basket {
        Product[] purchased;

        Basket(Product[] purchased) {
            this.purchased = purchased;
        }
    }

    public static class User {
        public User(String login, String password) {
            this.login = login;
            this.password = password;
        }
        public String login, password;
        public Basket purchased;

        boolean isAuth(String login, String password) {
            return this.login.equals(login) && this.password.equals(password);
        }
    }

    public static void getMenu() {
        System.out.println("\n Меню");
        System.out.println("1.Категории товаров");
        System.out.println("2.Корзина");
        System.out.println("3.Оплатить");
        System.out.println("0.Выход");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        switch(number) {
            case 1:
                getCategory(all);
                break;
            case 2:
                getBasket();
                break;
            case 3:
                Buy();
                break;
            case 0:
                break;
        }
    }

    public static void Buy() {
        client.purchased = new Basket(card);
        System.out.println("Товарный чек");
        for(int i = 0; i < client.purchased.purchased.length; ++i) {
            if(client.purchased.purchased[i] == null) break;
            System.out.println((i+1) + ". " + client.purchased.purchased[i].nameProduct + " " + client.purchased.purchased[i].cost + "р");
        }
        double gc = getCash(client.purchased.purchased);
        System.out.print("Общая сумма покупок составляет - " + gc);

    }
    public static double getCash(Product[] p) {
        double cash = 0.0;
        for (Product product : p) {
            if (product == null) break;
            cash += product.cost;
        }
        return cash;
    }
    public static void getCategory(Category[] c) {
        for(int i = 0; i < c.length; ++i)System.out.println("№"+ (i+1) + " " + c[i].nameCategory);
        System.out.println("0.Назад");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        if(number == 0)getMenu();
        else seeProduct(all[number-1]);

    }
    public static void getBasket() {
        sortBascket();
        System.out.println("Назад");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        if(number == 0)getMenu();
    }

    public static void seeProduct(Category cat) {
        for(int i = 0; i < cat.products.length; ++i) {
            System.out.println((i+1) + ". " + cat.products[i].nameProduct + " " + cat.products[i].cost  + "р");

        }
        System.out.println("0.Назад");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        if(number == 0)getCategory(all);
        else buyProduct(cat.products[number-1]);
    }

    private static void buyProduct(Product p) {
        System.out.println("Продукт " + p.nameProduct + " за " + p.cost + "p был добавлен в вашу корзину");
        for(int i = 0; i < card.length; ++i) {
            if(card[i] == null) {
                card[i] = p;
                break;
            }
            else {
                if(i+1 == card.length && card[i] == null) {
                    System.out.println("Корзина заполнена");
                    break;
                }
            }
        }

        getCategory(all);
    }

    static Product bread = new Product("Хлеб", 34.0);
    static Product buscuit = new Product("Пирожок", 60.0);
    static Product cookies = new Product("Печенье", 75.0);

    static Product milk = new Product("Молоко", 123.0);
    static Product kefir = new Product("Кефир", 86.0);
    static Product curd = new Product("Творог", 75.0);

    static Product[] Bakery = { bread, buscuit, cookies };
    static Product[] Diary = { milk, kefir, curd };

    static Category bakery = new Category("Хлебобулочные изделия", Bakery);
    static Category diary = new Category("Молочные изделия", Diary);

    static Category[] all = { bakery, diary };
    static Product[] card;

    static void sortBascket() {
        int hl = 0;
        int pi = 0;
        int pe = 0;
        int mo = 0;
        int ke = 0;
        int tv = 0;

        for (int i = 0; i < card.length; i++) {
            try {
                switch (card[i].nameProduct) {
                    case ("Хлеб") -> hl++;
                    case ("Пирожок") -> pi++;
                    case ("Печенье") -> pe++;
                    case ("Молоко") -> mo++;
                    case ("Кефир") -> ke++;
                    case ("Творог") -> tv++;
                }
            }
            catch (NullPointerException e) {
            }
        }

        if (hl > 0) {
            System.out.println("Хлеб х" + hl);
        }
        if (pi > 0) {
            System.out.println("Пирожок х" + pi);
        }
        if (pe > 0) {
            System.out.println("Печенье х" + pe);
        }
        if (mo > 0) {
            System.out.println("Молоко х" + mo);
        }
        if (ke > 0) {
            System.out.println("Кефир х" + ke);
        }
        if (tv > 0) {
            System.out.println("Творог х" + tv);
        }
    }

    static User client;

    public static void main(String[] args) {
        client = new User("123","123");

        Scanner scanner = new Scanner(System.in);
        card = new Product[10];
        System.out.println("Авторизация \n Введите логин и пароль пользователя:");
        String login = scanner.nextLine();
        String password = scanner.nextLine();
        if (client.isAuth(login, password)) {
            getMenu();
        }

    }

}