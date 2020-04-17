
public class Client extends Person {
    String maidenName;
    Address address; //Atrybut złożony

    public Client(String firstName, String lastName, String email, int age, String maidenName, Address address) {
        super(firstName, lastName, email, age);
        this.maidenName = maidenName;
        this.address = address;
    }

    @Override
    public String toString() {
        return super.toString() +
                ( maidenName.equals("") ? "" : "\n\tMaiden name: " + maidenName) +
                "\n" + this.address.toString();
    }

    //Getters
    public Address getAddress() {
        return address;
    }



}
