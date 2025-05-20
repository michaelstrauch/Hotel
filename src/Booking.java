import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
