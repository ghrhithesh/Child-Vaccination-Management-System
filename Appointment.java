import java.util.Date;

public class Appointment {
    private Date date;
    private String vaccine;

    public Appointment(Date date, String vaccine) {
        this.date = date;
        this.vaccine = vaccine;
    }

    public Date getDate() {
        return date;
    }

    public String getVaccine() {
        return vaccine;
    }

    @Override
    public String toString() {
        return "Appointment on " + date + " for vaccine: " + vaccine;
    }
}
