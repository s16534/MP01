import java.util.Map;
import java.util.TreeMap;

public class Client extends Person {
    String maidenName = null;
    private String pesel;
//    Address address; //Atrybut złożony
    private Map<String, Form> formsQualif = new TreeMap<>();

    public Client(String firstName, String lastName, String email, int age, String pesel) throws Exception {
        super(firstName, lastName, email, age);
        validatePesel(pesel);
        this.pesel = pesel;
    }

    public Client(String firstName, String lastName, String email, int age, String pesel, String maidenName) throws Exception {
        super(firstName, lastName, email, age);
        validatePesel(pesel);
        this.pesel = pesel;
        this.maidenName = maidenName;
    }


    public void addFormQualif(Form newForm) {
        if(!formsQualif.containsKey(newForm.document_no)) {
            formsQualif.put(newForm.document_no, newForm);

            newForm.addClient(this);
        }
    }

    public Form findFormQualif(String doc_no) throws Exception {
        if(!formsQualif.containsKey(doc_no)) {
            throw new Exception("Unable to find a form: " + doc_no);
        }

        return formsQualif.get(doc_no);
    }

    private void validatePesel(String pesel) throws Exception {
        if(pesel.length() != 11) {
            throw new Exception("[INFO] pesel length is incorrect. Should be 11 chars.");
        }
    }

    public String getPesel() {
        return pesel;
    }


    @Override
    public String toString() {
        String info = "Client: " + this.firstName + " " + this.lastName + "\n";
        for(Form f : formsQualif.values()) {
            info += "   " + f.document_no + "\n";
        }
        return info;
    }




}
