import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Guest {
    private String firstName;
    private String secondName;
    private LocalDate birthDate;

    public Guest(String firstName, String secondName, LocalDate birthDate) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy");
        return getFirstName() + " " + getSecondName() + " " + "(" + getBirthDate().format(formatter)+ ")";
    }
}

