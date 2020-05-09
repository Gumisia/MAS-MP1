import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Client implements Serializable {

    private String firstName;
    private ArrayList<String> lastName = new ArrayList<>(); //5. ATRYBUT POWTARZALNY NAZWISKO
    private String email;


    Client(String firstName, String lastName, String email) {

        this.firstName = firstName;
        this.lastName.add(lastName);
        this.email = email;
        addClient(this);
    }

    Client(String firstName, String lastName1, String lastName2, String email) {

        this.firstName = firstName;
        this.lastName.add(lastName1);
        this.lastName.add(lastName2);
        this.email = email;
        addClient(this);
    }

    //============================== EKSTENSJA KLASY
    private static List<Client> extent = new ArrayList<>();
    private static void addClient(Client client) {
        extent.add(client);
    }

    static void showExtend(){
        System.out.println("Extent of the class: " + Client.class.getName());

        for (Client client : extent) {
            System.out.println(client);
        }
    }

    ////2. TRWALOSC EKSTENSJI
    static void writeExtent(ObjectOutputStream stream) throws IOException {
        stream.writeObject(extent);
    }

    static void readExtent(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        extent = (ArrayList<Client>) stream.readObject();
    }
    //==============================

    @Override
    public String toString() {
        return "Client{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}