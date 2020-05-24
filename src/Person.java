
public class Person extends ObjectPlusPlus  {
    String firstName;
    String lastName;
    String email;
    private int age;
    private static int minimalAge = 18; //Atrybut klasowy

    public Person(String firstName, String lastName, String email, int age) {
        super();
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
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }

    //Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
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
