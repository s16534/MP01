
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
    public String getAddress() {
        return "Street " + this.address.getStreet() + " " + this.address.getBuildNo() + (this.address.getFlatNo().isEmpty() ? "" : this.address.getFlatNo() +
                "\n" + this.address.getPostalCode() + " " + this.address.getCity() + ", " + this.address.getCountry()
        );
    }



}
