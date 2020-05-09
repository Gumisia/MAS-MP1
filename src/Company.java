import java.util.Calendar;

public class Company {

    String name;
    Address address; // ATRYBUT ZŁOŻONY
    int foundingYear;
    int minimumAge = 5; // ATRYBUT KLASOWY

    public Company(String name, Address address, int foundingYear) {
        if(checkAge(foundingYear))
        {
            this.name = name;
            this.address = address;
            this.foundingYear = foundingYear;

        } else System.out.println("UWAGA " +name+" firma jest zbyt młoda!");

    }


    boolean checkAge(int foundingYear){
        int year = Calendar.getInstance().get(Calendar.YEAR);
        if((year-foundingYear>=minimumAge)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", " + address +
                '}';
    }
}
