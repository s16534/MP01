
public class Person extends Extenstion {
    String firstName;
    String lastName;
    String email;
    private int age;
    private static int minimalAge = 18; //Atrybut klasowy

    public Person(String firstName, String lastName, String email, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        if(age < 18) {
            throw new NullPointerException("Person must have 18 or more years old.");
        }
        this.age = age;
    }

    @Override
    public String toString() {
        return    "\tFirst name: " + firstName +
                "\n\tLast name: " + lastName +
                "\n\tEmail: " + email +
                "\n\tAge: " + age;
    }

    //Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void sujdssada() {

    }

    public String getEmail() {
        return email;
    }

    //Setters
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }

//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }

    public void setEmail(String email) {
        this.email = email;
    }
}
