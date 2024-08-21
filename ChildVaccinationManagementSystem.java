import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ChildVaccinationManagementSystem {
    private ArrayList<Child> children;
    private Scanner scanner;
    private SimpleDateFormat dateFormat;

    public ChildVaccinationManagementSystem() {
        this.children = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        this.dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    }

    public static void main(String[] args) {
        ChildVaccinationManagementSystem system = new ChildVaccinationManagementSystem();
        system.run();
    }

    public void run() {
        while (true) {
            System.out.println("Child Vaccination Management System");
            System.out.println("1. Add Child");
            System.out.println("2. Schedule Vaccination");
            System.out.println("3. View Appointments");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addChild();
                    break;
                case 2:
                    scheduleVaccination();
                    break;
                case 3:
                    viewAppointments();
                    break;
                case 4:
                    System.out.println("Exiting the system.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addChild() {
        System.out.print("Enter child's name: ");
        String name = scanner.nextLine();
        System.out.print("Enter child's age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter child's gender: ");
        String gender = scanner.nextLine();

        Child child = new Child(name, age, gender);
        children.add(child);

        System.out.println("Child added successfully.");
    }

    private void scheduleVaccination() {
        System.out.print("Enter child's name: ");
        String name = scanner.nextLine();

        Child child = findChildByName(name);
        if (child == null) {
            System.out.println("Child not found.");
            return;
        }

        System.out.print("Enter vaccine name: ");
        String vaccine = scanner.nextLine();
        System.out.print("Enter appointment date (yyyy-mm-dd): ");
        String dateInput = scanner.nextLine();
        Date date = null;

        try {
            date = dateFormat.parse(dateInput);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please enter the date in yyyy-mm-dd format.");
            return;
        }

        Appointment appointment = new Appointment(date, vaccine);
        child.addAppointment(appointment);

        System.out.println("Appointment scheduled successfully.");
    }

    private void viewAppointments() {
        System.out.print("Enter child's name: ");
        String name = scanner.nextLine();

        Child child = findChildByName(name);
        if (child == null) {
            System.out.println("Child not found.");
            return;
        }

        System.out.println("Appointments for " + child.getName() + ":");
        child.displayAppointments();
    }

    private Child findChildByName(String name) {
        for (Child child : children) {
            if (child.getName().equalsIgnoreCase(name)) {
                return child;
            }
        }
        return null;
    }
}