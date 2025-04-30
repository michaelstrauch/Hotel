import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Room {

    private int roomNumber;
    private int numberOfBeds;
    private boolean hasBalcony;
    private boolean seaView;
    private int roomPrice;
    private List assignedGuest = new ArrayList<>();


    public Room(int roomNumber, int numberOfBeds, boolean hasBalcony, boolean seaView, int roomPrice) {
        this.roomNumber = roomNumber;
        this.numberOfBeds = numberOfBeds;
        this.hasBalcony = hasBalcony;
        this.seaView = seaView;
        this.roomPrice = roomPrice;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public boolean isHasBalcony() {
        return hasBalcony;
    }

    public void setHasBalcony(boolean hasBalcony) {
        this.hasBalcony = hasBalcony;
    }

    public boolean isSeaView() {
        return seaView;
    }

    public void setSeaView(boolean seaView) {
        this.seaView = seaView;
    }

    public int getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(int roomPrice) {
        this.roomPrice = roomPrice;
    }

}
