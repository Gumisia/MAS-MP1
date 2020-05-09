import java.io.*;

public class App {

    public static void main(String[] args) {

        final String extentFile = "src\\extent.bin";

        Client client1 = new Client("Jan", "Kowalski", "kowalskijan@op.pl");
        Client client2 = new Client("Marry", "Jackson", "merkihj@gmail.com");

        //5. ATRYBUT POWTARZALNY NAZWISKO
        Client client3 = new Client("Tom", "Jackson", "Kowalski", "kjjd@gmail.com");


        //2. TRWALOSC EKSTENSJI (SERIALIZACJA)
        try {
            //ZAPISANIE OBIEKTÓW CLIENT DO STRUMIENIA
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(extentFile));
            Client.writeExtent(output);
            output.close();

            //ODCZYTANIE OBIEKTÓW CLIENT ZE STRUMIENIA
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(extentFile));
            Client.readExtent(input);
            input.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        //1. EKSTENSJA KLASY
        Client.showExtend();

        //4. ATRYBUT OPCJONALNY - NUMER POKOJU
        System.out.println("\nAtrybut opcjonalny w adresie - numer pokoju");
        Address address1 = new Address("Marszałkowska", 158, "Warsaw"); //8.PRZECIĄŻENIE METOD - KONSTRUKTORY
        Address address2 = new Address("Aleja Róż", 236 , 56, "Krakow");

        Address.showExtend();

        String newCity = "Gdańsk";
        System.out.println("\nPrzeniesienie firm adresow do: "+newCity);

        Address.changeCity(newCity); // 7.METODA KLACOWA - PRZENIESIENIE WSZYSTKICH FIRM DO NOWEGO MIASTA
        Address.showExtend();

        address1.setCity("Warszawa");
        System.out.println("\nPrzeniesienie firm adresow do: "+address1.getCity());

        Address.changeCity(address1); // 9.PRZESŁONIECIE METODY KLASOWEJ
        Address.showExtend();

        //3. ATRYBUT ZLOZONY - ADDRESS W COMPANY
        Company company1 = new Company("Netflix", address1, 2000);
        Company company2 = new Company("HBO", address2, 1990);
        System.out.println("\n"+company1);

        //6.ATRYBUT KLASOWY - Minimalny wiek firmy
        Company company3 = new Company("LUX", new Address("Polna", 18, "Warszawa"), 2019);




    }
}
