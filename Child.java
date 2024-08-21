import java.util.ArrayList;

public class Child {
    private String name;
    private int age;
    private String gender;
    private ArrayList<Appointment> appointments;

    public Child(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.appointments = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    public void displayAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments found.");
            return;
        }
        for (Appointment appointment : appointments) {
            System.out.println(appointment);
        }
    }
}
