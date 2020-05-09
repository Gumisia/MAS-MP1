import java.util.*;

public class Address {
    private String street;
    private int number;
    Optional<Integer> roomNumber = Optional.empty(); //4. ATRYBUT OPCJONALNY - NUMER POKOJU
    String city;

    //---------------------- extensja
    private static List<Address> extent = new ArrayList<>();
    private static void addAddress(Address address) {
        extent.add(address);
    }

    static void showExtend(){
        System.out.println("Extent of the class: " + Address.class.getName());

        for (Address address : extent) {
            System.out.println(address);
        }
    }
    //-------------------------


    //8.PRZECIĄŻENIE METOD - KONSTRUKTORY
    public Address(String street, int number, String city) {
            this.street = street;
            this.number = number;
            this.city = city;
            addAddress(this);
    }

    public Address(String street, int number, int roomNumber, String city ) {
        this.street = street;
        this.number = number;
        this.roomNumber = Optional.of(roomNumber);
        this.city = city;
        addAddress(this);
    }

    // 7.METODA KLACOWA - PRZENIESIENIE WSZYSTKICH FIRM DO NOWEGO MIASTA
    public static void changeCity(String newCity){
        for (Address address : extent){
            address.setCity(newCity);
        }
    }

    public static void changeCity(Address cityFromAddress){
        String newCity = cityFromAddress.city;
        for (Address address : extent){
            address.setCity(newCity);
        }
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return String.format("Address: %s, %d, %s, %s ", getStreet(), getNumber(), getRoomNumber().isPresent() ? getRoomNumber().get():"(no number)",getCity());
    }

    public String getStreet() {
        return street;
    }

        public int getNumber() {
        return number;
    }

    public Optional<Integer> getRoomNumber() {
        return roomNumber;
    }

    public String getCity() {
        return city;
    }

}
