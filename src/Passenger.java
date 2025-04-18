public class Passenger {
    private String passengerID;
    private String name;
    private String passportNumber;
    private int age;
    private String contact;
    private String email;

    public Passenger(String passendgerID, String name, String passportNumber, int age, String contact, String email){
        this.passengerID = passendgerID;
        this.name = name;
        this.passportNumber = passportNumber;
        this.age = age;
        this.contact = contact;
        this.email = email;
    }

    public void fetch(String passengerID){
        System.out.println("Passenger's Name"+name);
        System.out.println("Passenger's age"+age);
        System.out.println("Passenger's email"+email);
    }

    // Method to book a flight
    public void bookFlight(String flightID) {
        System.out.println("Booking flight with ID: " + flightID + " for passenger: " + name);
        // Add logic to book the flight
    }

    // Method to cancel a flight
    public void cancelFlight(String flightID) {
        System.out.println("Cancelling flight with ID: " + flightID + " for passenger: " + name);
        // Add logic to cancel the flight
    }

    // Method to fetch booking data
    public void fetchBookingData() {
        System.out.println("Fetching booking data for passenger: " + name);
        // Add logic to fetch booking data
    }
}
