package lab2;
public class Author {
    public String name;
    public String email;
    public String gender;

    public Author(String Name, String Email, String Gender) {
        name = Name;
        email = Email;
        gender = Gender;
    }

    public String getName() {
        return name;
    }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getGender() { return gender; }

    public String to_String() {
        return "Author { " +
                "name = " + name +
                ", email = " + email +
                ", gender = " + gender +" }";
    }
}
