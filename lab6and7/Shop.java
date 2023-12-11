package lab6and7;

class Shop implements Printable {
    private String name;
    private String location;

    public Shop(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public void print() {
        System.out.println("Название: " + name);
        System.out.println("Расположение: " + location);
    }
}