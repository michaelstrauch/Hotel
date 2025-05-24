import java.util.ArrayList;
import java.util.List;


public class BookingManager {
    private final List<Booking> reservations;

    public BookingManager() {
        reservations = new ArrayList<>();
    }

    public void addBooking(Booking reservation) {
        reservations.add(reservation);
    }

    public Booking getBooking(int index) {
        return reservations.get(index);
    }

    public List<Booking> getBookings() {
        return new ArrayList<>(reservations);
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
        return count;

    }

    public double getAverageGuests() {
        int averageGuests = 0;
        for (Booking reservation : reservations) {
            averageGuests += reservation.getGuestCount();
        }
        return (double) averageGuests / reservations.size();

    }

    public List<Booking> getTopNHolidayBookings() {
        List<Booking> holidayBookingList = new ArrayList<>();
        for (Booking booking: reservations) {
            if (! booking.isWorkBooking() && holidayBookingList.size() <8) {
                holidayBookingList.add(booking);
            }
        }
        return holidayBookingList;
    }

    public void printGuestStatistics() {
        int singleGuest = 0;
        int doubleGuest = 0;
        int multipleGuest = 0;
        for (Booking statistics : reservations) {
            if (statistics.getGuestCount() == 1) {
                singleGuest++;
            }
            if (statistics.getGuestCount() == 2) {
                doubleGuest++;
            }
            if (statistics.getGuestCount() > 2) {
                multipleGuest++;
            }
        }
        System.out.println("Statistiky hostů:");
        System.out.println("Počet rezervací s jedním hostem: " + singleGuest);
        System.out.println("Počet rezervací se dvěma hosty: " + doubleGuest);
        System.out.println("Počet rezervací s více hosty: "+ multipleGuest + "\n");
    }

}
