public class Staff {
    private String staffID;
    private String name;
    private String role; // e.g., Pilot, Air Hostess, Ground Staff
    private int age;
    private String contact;
    private String email;

    public Staff(String staffID, String name, String role, int age, String contact, String email){
        this.staffID = staffID;
        this.name = name;
        this.role = role;
        this.age = age;
        this.contact = contact;
        this.email = email;
    }

    // Method to fetch staff details
    public void fetch(String staffID){
        System.out.println("Staff Name: " + name);
        System.out.println("Role: " + role);
        System.out.println("Email: " + email);
    }

    // Method to assign a flight
    public void assignedFlight(String flightID){
        System.out.println("Assigning flight with ID: " + flightID + " to staff: " + name + " (" + role + ")");
        // Add logic to assign flight
    }

    // Method to take leave
    public void takeLeave(String date){
        System.out.println("Staff " + name + " has requested leave on: " + date);
        // Add logic to request leave
    }

    // Method to fetch work data
    public void fetchWorkData(){
        System.out.println("Fetching work data for staff: " + name);
        // Add logic to fetch assigned flights, leaves, etc.
    }
}
