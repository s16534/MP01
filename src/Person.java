
public class Person extends Extenstion {
    String firstName;
    String lastName;
    String pesel;

    public Person(String firstName, String lastName, String pesel) {
        if(firstName == null || firstName.isEmpty()) throw new NullPointerException("firstName can't be empty.");
        if(lastName  == null || lastName.isEmpty())  throw new NullPointerException("lastName can't be empty.");
        if(pesel     == null || pesel.isEmpty())     throw new NullPointerException("pesel can't be empty.");
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
    }


}
