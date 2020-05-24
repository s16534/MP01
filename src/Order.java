import java.util.ArrayList;

public class Order {
    public String document_no;
    public Form form; //Liczność 1

    public Order(String document_no) {
        if(document_no.length() != 6) {
            throw new NullPointerException("Document length should has 6 chars.");
        }
        this.document_no = document_no;

    }

    public void addForm(Form newForm) {
        if(form != null) {
            if (!form.getDocument_no().equals(newForm.getDocument_no())) {
                System.out.println("[INFO] Dude, we already have form object for this order." +
                        " The order which you have is different from is exist now. It's bad. Delete old form first before add.");
            }
        } else {
            form = newForm;
            form.addOrder(this);
        }
    }

    public void removeForm(Form newForm) {
        if(form == null) return;
        if(form.getDocument_no().equals(newForm.getDocument_no())) form = null;
    }

    @Override
    public String toString() {
        return "Order{" +
                "document_no='" + document_no + '\'' + (form != null ?
                ", form=" + form.getDocument_no() : "") +
                '}';
    }

}
