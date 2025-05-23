import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;


public class Booking {
    private List<Guest> assignedGuest = new ArrayList<>();
    private Room room;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean isWorkBooking;
    private int guestCount;

    public Booking(Guest guest, Room room, LocalDate startDate, LocalDate endDate, boolean isWorkBooking) {
        assignedGuest.add(guest);
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isWorkBooking = isWorkBooking;

    }

    public void addGuest(Guest guest) {
        assignedGuest.add(guest);
    }

    public boolean isWorkBooking() {
        return isWorkBooking;
    }

    public int getGuestCount() {
        return assignedGuest.size();
    }

    public String getGuest() {
        String guestNames = "";

        for (int i = 0; i < assignedGuest.size(); i++) {
            if (i > 0){
                guestNames = guestNames + ",";
            }
            guestNames = guestNames + assignedGuest.get(i).toString();

        }
        return guestNames;
    }

    private long totalNightsCalculation() {
        return ChronoUnit.DAYS.between(startDate, endDate);
    }

    public long getBookingLength() {
        long bookedNights = ChronoUnit.DAYS.between(startDate, endDate);
        System.out.println("Total nights: "+ bookedNights);
        return bookedNights;
    }

    public BigDecimal getTotalPrice() {
        long nights = totalNightsCalculation() ;
        BigDecimal nightsBD = BigDecimal.valueOf(nights);
        BigDecimal totalPrice = room.getRoomPrice().multiply(nightsBD);
        System.out.println("Price for this reservation is: "+ totalPrice +" Currency");
        return totalPrice;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return  "Guest: " + getGuest() + "\n" +
                "Room: " + room.getRoomNumber() + "\n" +
                "Has seaview ? " + room.isSeaView() + "\n" +
                "Has balcony ? " + room.isHasBalcony() + "\n" +
                "Price : " + room.getRoomPrice() + "\n" +
                "From: " + startDate.format(formatter) +"\n" +
                "To: " + endDate.format(formatter) + "\n";
    }
}
