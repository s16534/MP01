import java.io.*;
import java.util.Scanner;

public class Main {
    private static String PATH = System.getProperty("user.home");
    private static String fileName = "mp01.bin";
    private static boolean showOptionNumerThree = false;

    public static void main(String[] args) throws Exception {
//        Ekstensja                     [DONE] - Extenstion class
//        Ekst. - trwałość              [DONE] - Extenstion class - serializacja
//        Atr. złożony                  [DONE] - Client class
//        Atr. opcjonalny               [DONE] - Address class
//        Atr. powt.                    [DONE] - Address class
//        Atr. klasowy                  [DONE] - bonusForSelling variable in Agent class
//        Atr. pochodny                 [DONE] - getIncome() in Agent class.
//        Met. klasowa                  [DONE] - findTheHighestSalary() in Agent class
//        Przesłonięcie                 [DONE] - toString methods
//        przeciążenie                  [DONE] - setFlatNo() in Address class

        menu();
//        File file = new File(PATH + "\\\\" + fileName);
//        System.out.println("[INFO] Sprawdzenie czy plik istnieje...");
//        Boolean isFileExist = file.exists();
//        System.out.println("[INFO] Wynik sprawdzenia: " + (isFileExist ? "Plik istnieje" : "Plik nieistnieje"));
//        if(!isFileExist) {
//            createSamples();
//            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file));
//            Extenstion.writeExtents(outputStream);
//            outputStream.close();
//        } else {
//            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file));
//            Extenstion.readExtents(inputStream);
//            inputStream.close();
//        }

//        System.out.println(Agent.findTheHighestPaidAgent());
//        Client c = null;
//        Iterable<Client> clients = Extenstion.getExtent(Client.class);
//        for (Client client : clients) {
//            if(client.getLastName().equals("Gawryś")) c = client;
//        }
//        System.out.println(c.getAddress());

    }

    public static void menu() throws Exception {
        File file = new File(PATH + "\\\\" + fileName);
        Boolean isFileExist = file.exists();
        Scanner s = new Scanner(System.in);
        int choice = 0;
        System.out.println("[MENU]");
        System.out.println("[ 1 ] Wczytaj dane z pliku");
        System.out.println("[ 2 ] Utwórz przykłady i zapisz do pliku");
        if(showOptionNumerThree)
            System.out.println("[ 3 ] Znajdź największą pensję wśród agentów");
        choice = s.nextInt();
        boolean differentserialVersionUID = false;
        switch (choice) {
            case 1:
                if(!isFileExist) {
                    System.out.println("[INFO] Plik nie istnieje.");
                    menu();
                }
                ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file));
                try {
                    Extenstion.readExtents(inputStream);
                    showOptionNumerThree = true;
                } catch (InvalidClassException e) {
                    System.out.println("[INFO] Odczytana wartość serialVersionUID się różni.");
                    differentserialVersionUID = true;
                }
                inputStream.close();

                if(differentserialVersionUID) {
                    System.out.println(file.delete() ? "[INFO] Plik został usunięty, prosimy o wygenerowanie przykładowych danych od nowa." : "[INFO] Nie udało się usunąć pliku. Prosimy o usunięcie ręczne pliku.");
                } else {
                    showSamples();
                }
                break;
            case 2:
                createSamples();
                ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file));
                Extenstion.writeExtents(outputStream);
                outputStream.close();
                showOptionNumerThree = true;
                break;
            case 3:
                if(showOptionNumerThree) System.out.println(
                        "[INFO] Największa pensja wśród agentów: " + Agent.findTheHighestSalary()
                );
                break;
            default:
                System.out.println("");
        }
        menu();
    }

    public static void showSamples() throws Exception {
        System.out.println("Clients");
        Extenstion.showExtent(Client.class);

        System.out.println("Agents");
        Extenstion.showExtent(Agent.class);
    }

    public static void createSamples() {
        Address address001 = new Address("Przyokopowa", "32", "", "", "Warszawa", "Polska");
//        Address address002 = new Address("Okopowa", "55", "", "", "Warszawa", "Polska");
        Address address003 = new Address("Zaokopowa", "44", "", "", "Warszawa", "Polska");

        Client client001 = new Client("Jarosław", "Gawryś", "jgawrys@bigcompany.com", 22, "Ziemniak", address001);
        Client client002 = new Client("Jakub", "Radwański", "jradwanski@flippers.com", 23, "", address003);
//        Agent agent001 = new Agent("Maksymilian", "Bosakowski", "mbosakowski@bigpharma.com", 21, 2400.00);
//        Agent agent002 = new Agent("Anton", "Drogow", "mbosakowski@bigpharma.com", 21, 1200.00);
//        Agent agent003 = new Agent("Vitali", "Schodow", "mbosakowski@bigpharma.com", 21, 3700.00);

        System.out.println("[INFO] Utworzone przykładowe dane.");
    }
}
