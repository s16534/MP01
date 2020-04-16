import java.util.Locale;
import java.util.Optional;

public class Address extends Extenstion{
    private String street;
    private String buildNo;
    private Optional<String> flatNo = Optional.empty();
    private String postalCode;
    private String city;
    private String country;
    String[] countries = Locale.getISOCountries();

    public Address(String street, String buildNo, Optional<String> flatNo, String postalCode, String city, String country) {
        this.street = street;
        this.buildNo = buildNo;
        this.flatNo = flatNo;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public String getCountry(String code) {
        return new Locale("", code).getDisplayCountry();
    }
}
