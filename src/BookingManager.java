import java.util.ArrayList;
import java.util.List;


public class BookingManager {
    private List<Booking> reservations;

    public BookingManager() {
        reservations = new ArrayList<>();
    }

    public void addBooking(Booking reservation) {
        reservations.add(reservation);
    }

    public void getBooking(int index) {
        if (index >= 0 && index < reservations.size()) {
            System.out.println(reservations.get(index));
        } else {
            System.out.println("No reservation found at index " + index);
        }
    }

    public void getBookings() {
        for (Booking reservation : reservations) {
            System.out.println(reservation);
        }
    }

    public void clearBookings() {
            reservations.clear();
    }

    public int getNumberOfWorkingBookings() {
        int count = 0;
        for (Booking reservation : reservations) {
            if (reservation.isWorkBooking()) {
                count++;
            }
        }
        System.out.println("Number of Work bookings: " +count);
        return count;

    }

    public double getAverageGuests() {
        int averageGuests = 0;
        for (Booking reservation : reservations) {
            averageGuests += reservation.getGuestCount();
        }
        System.out.println("Average guests per booking: " +(double) averageGuests/reservations.size());
        return (double) averageGuests / reservations.size();

    }


}
