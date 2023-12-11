package lab9;

import java.util.Arrays;

public class MyComparable implements Comparable<MyComparable> {
    private String name;
    private int age;

    public MyComparable(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(MyComparable otherPerson) {
        int ageComparison = Integer.compare(this.age, otherPerson.age);

        if (ageComparison != 0) {
            return ageComparison;
        } else {
            return this.name.compareTo(otherPerson.name);
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        MyComparable person1 = new MyComparable("Alice", 25);
        MyComparable person2 = new MyComparable("Bob", 30);
        MyComparable person3 = new MyComparable("Charlie", 25);
        MyComparable person4 = new MyComparable("Alice", 25);

        MyComparable[] people = {person1, person2, person3, person4};
        Arrays.sort(people);

        for (MyComparable person : people) {
            System.out.println(person);
        }

        System.out.println(people[0].compareTo(people[1]));
        System.out.println(people[0].compareTo(people[2]));
        System.out.println(people[0].compareTo(people[3]));
    }
}
