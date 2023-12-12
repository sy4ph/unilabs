package lab2;

public class task1 {
    public static void main(String[] args) {
        Author bob = new Author("Bob", "bob@ru", "male");

        System.out.println(bob.getName());
        System.out.println(bob.getEmail());
        bob.setEmail("kimgowin@.ru");
        System.out.println(bob.getEmail());
        System.out.println(bob.getGender());
        System.out.println(bob.to_String());
    }
}
