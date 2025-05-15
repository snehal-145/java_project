import java.util.*;

class Participant {
    private String name;
    private boolean hasPaid;

    public Participant(String name, boolean hasPaid) {
        this.name = name;
        this.hasPaid = hasPaid;
    }

    public String getName() {
        return name;
    }

    public boolean hasPaid() {
        return hasPaid;
    }
}

class Event {
    private String id, name, date, venue, description;
    private double fee;
    private List<Participant> participants;

    public Event(String id, String name, String date, String venue, String description, double fee) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.venue = venue;
        this.description = description;
        this.fee = fee;
        this.participants = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void addParticipant(String name, boolean hasPaid) {
        participants.add(new Participant(name, hasPaid));
    }

    public void displayDetails() {
        System.out.println("\nEvent ID   : " + id);
        System.out.println("Name       : " + name);
        System.out.println("Date       : " + date);
        System.out.println("Venue      : " + venue);
        System.out.println("Fee        : ₹" + fee);
        System.out.println("Description: " + description);
        System.out.println("Total Registered: " + participants.size());
    }

    public void displayParticipants() {
        if (participants.isEmpty()) {
            System.out.println("No participants yet.");
            return;
        }
        for (Participant p : participants) {
            System.out.println("- " + p.getName() + " | Paid: " + (p.hasPaid() ? "Yes" : "No"));
        }
    }
}

public class EventManagementSystem {
    static Scanner sc = new Scanner(System.in);
    static Map<String, Event> eventMap = new HashMap<>();
    static final String ADMIN_USERNAME = "admin";
    static final String ADMIN_PASSWORD = "admin123";

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n=== College Fest Event Management ===");
            System.out.println("1. Admin Login");
            System.out.println("2. Student Access");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = getIntInput();

            switch (choice) {
                case 1:
                    adminLogin();
                    break;
                case 2:
                    studentMenu();
                    break;
                case 3:
                    System.out.println("Thank you. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 3);
    }

    static void adminLogin() {
        System.out.print("Enter admin username: ");
        String username = sc.nextLine();
        System.out.print("Enter admin password: ");
        String password = sc.nextLine();

        if (username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD)) {
            adminMenu();
        } else {
            System.out.println("Invalid credentials!");
        }
    }

    static void adminMenu() {
        int choice;
        do {
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1. Add Event");
            System.out.println("2. View All Events");
            System.out.println("3. View Event Participants");
            System.out.println("4. Logout");
            System.out.print("Enter your choice: ");
            choice = getIntInput();

            switch (choice) {
                case 1:
                    addEvent();
                    break;
                case 2:
                    viewAllEvents();
                    break;
                case 3:
                    viewParticipants();
                    break;
                case 4:
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 4);
    }

    static void addEvent() {
        System.out.print("Enter Event ID: ");
        String id = sc.nextLine();

        if (eventMap.containsKey(id)) {
            System.out.println("Event ID already exists.");
            return;
        }

        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Date (dd-mm-yyyy): ");
        String date = sc.nextLine();
        System.out.print("Enter Venue: ");
        String venue = sc.nextLine();
        System.out.print("Enter Description: ");
        String description = sc.nextLine();
        System.out.print("Enter Entry Fee (₹): ");
        double fee = getDoubleInput();

        Event event = new Event(id, name, date, venue, description, fee);
        eventMap.put(id, event);
        System.out.println("Event added successfully.");
    }

    static void viewAllEvents() {
        if (eventMap.isEmpty()) {
            System.out.println("No events available.");
            return;
        }

        for (Event e : eventMap.values()) {
            e.displayDetails();
        }
    }

    static void viewParticipants() {
        System.out.print("Enter Event ID: ");
        String id = sc.nextLine();

        Event e = eventMap.get(id);
        if (e != null) {
            e.displayParticipants();
        } else {
            System.out.println("Event not found.");
        }
    }

    static void studentMenu() {
        int choice;
        do {
            System.out.println("\n--- Student Menu ---");
            System.out.println("1. View Events");
            System.out.println("2. Register for Event");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = getIntInput();

            switch (choice) {
                case 1:
                    viewAllEvents();
                    break;
                case 2:
                    registerStudent();
                    break;
                case 3:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 3);
    }

    static void registerStudent() {
        System.out.print("Enter Event ID: ");
        String id = sc.nextLine();

        Event e = eventMap.get(id);
        if (e == null) {
            System.out.println("Event not found.");
            return;
        }

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Do you want to pay now? (yes/no): ");
        boolean hasPaid = sc.nextLine().equalsIgnoreCase("yes");

        e.addParticipant(name, hasPaid);
        System.out.println("Registration complete. Payment: " + (hasPaid ? "Received" : "Pending"));
    }

    static int getIntInput() {
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            return -1;
        }
    }

    static double getDoubleInput() {
        try {
            return Double.parseDouble(sc.nextLine());
        } catch (Exception e) {
            return 0.0;
        }
    }
}
