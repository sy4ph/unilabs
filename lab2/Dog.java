package lab2;
public class Dog {
    private String name;
    private int age;
    public void humanyear()
    {
        int c = age * 8;
        System.out.println( c );
    }
    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /*public static void main(String[] args){
        Dog shy = new Dog('shy', 3);
        Dog pew = new Dog('pew', 5);
    }*/
    public void humanyoar(){
        System.out.println( );
    }
    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
