import com.sun.org.apache.xpath.internal.operations.Or;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Form extends ObjectPlusPlus {
    private LocalDate registerdate;
    private String status;
    public String document_no;
    final private int cLength = 9;


    private ArrayList<Order> orders  = new ArrayList<Order>(); //Liczność *
    private Client client; //Liczność 1

    public Form(LocalDate registerdate, String status, String document_no) throws Exception {
        this.registerdate = registerdate;
        this.status = status;
        if(document_no.length() != 9) {
            throw new Exception("Document length is not correct! Should be 9.");
        }
        this.document_no = document_no;
//        this.orders = ;
    }

    public String getDocument_no() {
        return document_no;
    }

    //TODO Asocjacja zwykła, wiele order do jednego form
    public void addOrder(Order order) {
        if(!orders.contains(order)) {
            orders.add(order);
            order.addForm(this);
        }
    }

    public void removeOrder(Order order) {
        if(!orders.contains(order)) return;
        orders.remove(order);
        order.removeForm(this);
    }

    public void addClient(Client newClient) {
        if(client != null) {
            if (!client.getPesel().equals(newClient.getPesel())) {
                System.out.println("[INFO] Dude, we already have client object for this order." +
                        " The order which you have is different from is exist now. It's bad. Delete old client first before add.");
            }
        } else {
            client = newClient;
            client.addFormQualif(this);
        }
    }

    public void removeClient(Client newClient) {
        if(client == null) return;
        if(client.getPesel().equals(newClient.getPesel())) client = null;
    }

    @Override
    public String toString() {
        String info = "Form: " + document_no + "\n";
        for(Order o : orders) {
            info += "   order " + o.document_no + "\n";
        }
        if(client !=null) {
            info += "   client " + client.firstName + " " + client.lastName + "\n";
        }

        return info;
    }
}
