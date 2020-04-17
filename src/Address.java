import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Address extends Extenstion{
    private String street;
    private String buildNo;
    private String flatNo;              //Atrybut opcjonalny
    private String postalCode;
    private String city;
    private String country;
    List<String> countries = new ArrayList<String>();//Atrybut powtarzalny

    public Address(String street, String buildNo, String flatNo, String postalCode, String city, String country) {
        this.street = street;
        this.buildNo = buildNo;
        this.flatNo = flatNo != null ? flatNo : "";
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
        addCountriesToList();
    }

    @Override
    public String toString() {
        return    "\tStreet: " + getStreet() + " " + getBuildNo() + (getFlatNo().isEmpty() ? "" : " m." + getFlatNo())  +
                "\n\tCity: " + getPostalCode() + " " + getCity() +
                "\n\tCountry: "+ getCountry();
    }

    public void addCountriesToList() {
        String[] con = Locale.getISOCountries();
        for(String country : con) {
            countries.add(new Locale("", country).getDisplayCountry());
        }
    }
//Getters
    public String getCountry() {
        return country;
    }

    public String getStreet() {
        return street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    public String getBuildNo() {
        return buildNo;
    }

    public String getFlatNo() {
        return flatNo;
    }

//    public String getCountry(String code) {
//        return new Locale("", code).getDisplayCountry();
//    }

//   Setters


    public void setFlatNo() {
        this.flatNo = "";
    }

    public void setFlatNo(String flatNo) {
        this.flatNo = flatNo;
    }


    public void setBuildNo(String buildNo) {
        this.buildNo = buildNo;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
