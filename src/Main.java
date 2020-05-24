import java.io.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static String PATH = System.getProperty("user.home");
    private static String fileName = "mp01.bin";
    private static boolean showOptionNumerThree = false;

    public static void main(String[] args) throws Exception {
//      Asocjacja "Zwykła"
//        asocjacjaZwykla();

//      Asocjacja z atrybutem
        asocjacjaAtrybut();

//      Asocjacja kwalifikowana
//        asocjacjaKwalifikowana();
//      Kompozycja
//        kompozycja();
    }

    private static void asocjacjaAtrybut() {
        Agent agent1 = new Agent("James",  "Bond", "mail@mail.com", 38, "A546875");
        Agent agent2 = new Agent("Richard",  "Ericson", "mail@mail.com", 38, "A546875");
        Agent agent3 = new Agent("John",  "Trump", "mail@mail.com", 38, "A546875");
        Agency agency1 = new Agency("Agencja 1", "357167717", "5273583026", "+48568458769", "mail@agency.com");
        Agency agency2 = new Agency("Agencja 2", "357167717", "5273583026", "+48568458769", "mail@agency.com");
        Agency agency3 = new Agency("Agencja 3", "357167717", "5273583026", "+48568458769", "mail@agency.com");
        AgentAgency<Agent, Agency> aa = new AgentAgency(LocalDate.now().minusMonths(2), LocalDate.now(), agent1, agency1);
        AgentAgency aa2 = new AgentAgency(LocalDate.now().minusMonths(2), LocalDate.now(), agent2, agency2);
        AgentAgency aa3 = new AgentAgency(LocalDate.now().minusMonths(2), LocalDate.now(), agent1, agency1);

        System.out.println(aa);
    }

    private static void kompozycja() throws Exception {
        System.out.println("====Kompozycja====");
        Product p1 = new Product("158", "Lokatopolisa v3", "158_UBLIJ176", "MNI", true);
        Product p2 = new Product("156", "Lokatopolisa v2", "156_UBLIJ176", "MNI", true);

        p1.createParameter("minAge", "18");
        Product.Parameter x = p1.getParameter("minAge");
        p1.createParameter("maxAge", "76");
        p1.createParameter("nazwa_ubezpieczenia", "Lokatopolisa dla ułomnych");

        System.out.println(x == p1.getParameter("minAge"));

        System.out.println(p1);
        System.out.println(p1.getParameter("minAge"));
//        p1 = null;
//        System.out.println(p1);
        p1.removeParameter("maxAge");
        System.out.println(p1);
//        System.out.println(p1.getParameter("minAge"));
    }

    private static void asocjacjaKwalifikowana() throws Exception {
        System.out.println("====Asocjacja Kwalifikowana====");
        Form f1 = new Form(LocalDate.now(), "ACTIVE", "100000000");
        Form f2 = new Form(LocalDate.now(), "ACTIVE", "100000002");
        Form f3 = new Form(LocalDate.now(), "ACTIVE", "100000008");

        Client c1 = new Client("Johnny", "Bravo", "john.bravo@gmail.com", 20, "12345678901");
//        Client c2 = new Client("Mariusz", "Rodak", "mrodak@hotpotato.com", 47, "12345678905");
//        Client c3 = new Client("Henryk", "Polak", "insurance@hp.com", 88, "12345678909");

//        Order o1  = new Order("000111");
//        Order o2  = new Order("000115");
//        Order o3  = new Order("000129");
//
//        f1.addOrder(o1);
//        f1.addOrder(o2);

        f1.addClient(c1);
        f2.addClient(c1);
        f3.addClient(c1);

        System.out.println(f1);

        System.out.println(c1);

        System.out.println(c1.findFormQualif("100000000"));
    }

    private static void asocjacjaZwykla() throws Exception {
        System.out.println("====Asocjacja zwykła====");
        Form f1 = new Form(LocalDate.now(), "ACTIVE", "100000000");
//        Form f2 = new Form(LocalDate.now(), "ACTIVE", "100000002");
//        Form f3 = new Form(LocalDate.now(), "ACTIVE", "100000008");


        Order o1  = new Order("000111");
        Order o2  = new Order("000115");
        Order o3  = new Order("000129");

        f1.addOrder(o1);
        f1.addOrder(o2);
//        f1.addOrder(o3);
        o3.addForm(f1);

        System.out.println(f1);
        System.out.println(o2);
        f1.removeOrder(o2);
        System.out.println(f1);
        System.out.println(o2);

    }


}
