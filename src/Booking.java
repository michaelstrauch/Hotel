import java.time.LocalDate;



public class Booking {
    public static void main(String[] args) {

        Guest guest1 = new Guest("Adéla", "Malíková", LocalDate.of(1993,3,13));
        Guest guest2 = new Guest("Jan", "Dvořáček", LocalDate.of(1995, 5,5));

        guest2.setBirthDate(LocalDate.of(1995, 4, 5));
        System.out.println(guest2 + "\n");

        Room room1 = new Room(1,1,true,true,1000);
        Room room2 = new Room(1,1,true,true,1000);
        Room room3 = new Room(3,3,false,true,2400);

        Reservations reservations = new Reservations();

        reservations.addReservation(guest1, room1, LocalDate.of(2021,7,19),LocalDate.of(2021,7,26));
        reservations.addReservation(guest2, room3, LocalDate.of(2021,9,1),LocalDate.of(2021,9,14));
        reservations.addReservation(guest1, room3, LocalDate.of(2021,9,1),LocalDate.of(2021,9,14));
        reservations.addReservation(guest2, room1, LocalDate.of(2021,9,15),LocalDate.of(2021,9,29));
       
        reservations.printReservations();












    }
}
