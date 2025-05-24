import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;


public class Booking {
    private final List<Guest> assignedGuest = new ArrayList<>();
    private final Room room;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final boolean isWorkBooking;


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

    public long getBookingLength() {
        return ChronoUnit.DAYS.between(startDate, endDate);
    }

    public BigDecimal getTotalPrice() {
        long nights = getBookingLength() ;
        BigDecimal nightsBD = BigDecimal.valueOf(nights);
        return room.getRoomPrice().multiply(nightsBD);
    }

    public String getFormattedSummary() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy");
        Guest firstGuest =assignedGuest.getFirst();
        return startDate.format(formatter) + " až " + endDate.format(formatter) + ": " + firstGuest.getFirstName() + " " + firstGuest.getSecondName() +" "+"(" + firstGuest.getBirthDate().format(formatter) + ")"+"["+ assignedGuest.size() + ", " + (room.isSeaView()? "ano" : "ne") +"]"+" za "+ getTotalPrice() +" Kč";
    }


    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        Guest firstGuest = assignedGuest.getFirst();
        return "Rezervace pro: " + firstGuest.getFirstName() + " " + firstGuest.getSecondName() +" "+ "("+ firstGuest.getBirthDate().format(formatter)+")"+" Termín: "+ startDate.format(formatter) +" - "+ endDate.format(formatter) + " pracovní pobyt: "+ (isWorkBooking? "ano":"ne");
    }
}
