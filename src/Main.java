import java.math.BigDecimal;
import java.time.LocalDate;


public class Main {

    public static BookingManager fillBookings() {
        Guest guest1 = new Guest("Karel","Dvořák", LocalDate.of(1990,5,15));
        Guest guest2 = new Guest("Karel","Dvořák",LocalDate.of(1979,1,3));
        Guest guest3 = new Guest("Karolína","Tmavá",LocalDate.of(2000,11,23));

        Room room2 = new Room(2,1,false,false,new BigDecimal(1000));
        Room room3 = new Room(3,3,true,true,new BigDecimal(2000));

        BookingManager reservations = new BookingManager();

        Booking reservation1 = new Booking(guest1,room3,LocalDate.of(2023,1,6),LocalDate.of(2023,7,6),true);
        Booking reservation2 = new Booking(guest2,room2,LocalDate.of(2023,7,18),LocalDate.of(2023,7,21),false);
        Booking reservation3 = new Booking(guest3,room3,LocalDate.of(2023,8,1),LocalDate.of(2023,8,31),true);
        reservation3.addGuest(guest1);

        reservations.addBooking(reservation1);
        reservations.addBooking(reservation2);
        reservations.addBooking(reservation3);


        LocalDate startDate = LocalDate.of(2023,8,1);
        for (int i = 0; i < 10; i++) {
            LocalDate endDate = startDate.plusDays(1);
            reservations.addBooking(new Booking(guest3,room2,startDate,endDate,false));
            startDate = startDate.plusDays(2);

        }

        return reservations;
    }


    public static void main(String[] args) {

        BookingManager reservations = fillBookings();

        System.out.println("Počet pracovních pobytů: " + reservations.getNumberOfWorkingBookings());
        System.out.println();

        System.out.println("Průměrný počet hostů na rezervaci: " + reservations.getAverageGuests());
        System.out.println();

        System.out.println("Prvních osm rekreačních rezervací:");
        for (Booking holidayBooking : reservations.getTopNHolidayBookings()) {
            System.out.println(holidayBooking);
        }
        System.out.println();

        reservations.printGuestStatistics();
        System.out.println();

        for (Booking booking: reservations.getBookings()) {
            System.out.println(booking.getFormattedSummary());
        }
        System.out.println();

        System.out.println("Celkový počet rezervací: " + reservations.getBookings().size());
        System.out.println();

        Booking secondBooking = reservations.getBooking(1);
        System.out.println("Rezervace č.2 je zarezervovaná na "+secondBooking.getBookingLength()+ " nocí.");

        //a nakonec
        reservations.clearBookings();
    }
}
