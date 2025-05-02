import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Reservation {
    private Guest guest;
    private Room room;
    private LocalDate startDate;
    private LocalDate endDate;

    public Reservation(Guest guest, Room room, LocalDate startDate, LocalDate endDate) {
        this.guest = guest;
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return  "Guest: " + guest + "\n" +
                "Room: " + room.getRoomNumber() + "\n" +
                "Has seaview ? " + room.isSeaView() + "\n" +
                "Has balcony ? " + room.isHasBalcony() + "\n" +
                "Price : " + room.getRoomPrice() + "\n" +
                "From: " + startDate.format(formatter) +"\n" +
                "To: " + endDate.format(formatter) + "\n";
    }
}
