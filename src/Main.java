import java.io.*;
import java.util.Iterator;

public class Main {
    private static String PATH = System.getProperty("user.home");
    private static String fileName = "mp01.bin";

    public static void main(String[] args) throws Exception {
//        Ekstensja                     [DONE]
//        Ekst. - trwałość              [DONE]
//        Atr. złożony                  [DONE]  - Client class
//        Atr. opcjonalny               [DONE]  - Address class
//        Atr. powt.                    [DONE]  - Address class
//        Atr. klasowy                  [DONE]  - bonusForSelling variable in Agent class
//        Atr. pochodny                 [MAYBE] - getIncome() in Agent class.
//        Met. klasowa                  [DONE]  - findTheHighestPaidAgent() in Agent class
//        Przesłonięcie, przeciążenie   [DONE]  - setFlatNo() in Address class


        System.out.println("[INFO] Uruchomienie programu.");
        File file = new File(PATH + "\\\\" + fileName);
        System.out.println("[INFO] Sprawdzenie czy plik istnieje...");
        Boolean isFileExist = file.exists();
        System.out.println("[INFO] Wynik sprawdzenia: " + (isFileExist ? "Plik istnieje" : "Plik nieistnieje"));
        if(!isFileExist) {
            createSamples();
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file));
            Extenstion.writeExtents(outputStream);
            outputStream.close();
        } else {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file));
            Extenstion.readExtents(inputStream);
            inputStream.close();
        }

        System.out.println(Agent.findTheHighestPaidAgent());
//        Client c = null;
//        Iterable<Client> clients = Extenstion.getExtent(Client.class);
//        for (Client client : clients) {
//            if(client.getLastName().equals("Gawryś")) c = client;
//        }

    }

    public static void createSamples() {
        Address address001 = new Address("Przyokopowa", "32", "", "", "Warszawa", "Polska");
        Address address002 = new Address("Okopowa", "55", "", "", "Warszawa", "Polska");
        Address address003 = new Address("Zaokopowa", "44", "", "", "Warszawa", "Polska");

        Client client001 = new Client("Jarosław", "Gawryś", "jgawrys@bigcompany.com", 22, "Ziemniak", address001);
        Client client002 = new Client("Jakub", "Radwański", "jradwanski@flippers.com", 23, "", address003);
        Agent agent001 = new Agent("Maksymilian", "Bosakowski", "mbosakowski@bigpharma.com", 21, 2400.00);
        Agent agent002 = new Agent("Anton", "Drogow", "mbosakowski@bigpharma.com", 21, 1200.00);
        Agent agent003 = new Agent("Vitali", "Schodow", "mbosakowski@bigpharma.com", 21, 3600.00);

        System.out.println("[INFO] Utworzone przykładowe dane.");
    }
}
