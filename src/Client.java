import java.util.Optional;

public class Client extends Person {
    Optional<String> maidenName = Optional.empty();
    Address address;

    public Client(String firstName, String lastName, String email, Optional<String> maidenName, Address address) {
        super(firstName, lastName, email);
        this.address = address;
    }
}
