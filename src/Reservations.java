import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Reservations {
    private List<Reservation> reservations;

    public Reservations() {
        reservations = new ArrayList<>();
    }

    public void addReservation(Guest guest, Room room, LocalDate startDate, LocalDate endDate) {
        reservations.add(new Reservation(guest, room, startDate, endDate));
    }

    public void printReservations() {
        for (Reservation reservation : reservations) {
            System.out.println(reservation);
        }
    }
}
