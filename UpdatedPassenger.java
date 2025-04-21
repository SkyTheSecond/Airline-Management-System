public class Passenger {
    private String passengerID;
    private String name;
    private String passportNumber;
    private int age;
    private String contact;
    private String email;
    public Passenger(String passengerID, String name, String passportNumber, int age, String contact, String email) {
        this.passengerID = passengerID;
        this.name = name;
        this.passportNumber = passportNumber;
        this.age = age;
        this.contact = contact;
        this.email = email;
    }
    public void fetch(String passengerID) {
        System.out.println("Passenger's Name: " + name);
        System.out.println("Passenger's Age: " + age);
        System.out.println("Passenger's Email: " + email);
    }
    public void bookFlight(String flightID) {
        System.out.println("Booking flight with ID: " + flightID + " for passenger: " + name);
    }
    public void cancelFlight(String flightID) {
        System.out.println("Cancelling flight with ID: " + flightID + " for passenger: " + name);
    }
    public void fetchBookingData() {
        System.out.println("Fetching booking data for passenger: " + name);
    }
    public String getPassengerID() { return passengerID; }
    public String getName() { return name; }
    public String getPassportNumber() { return passportNumber; }
    public int getAge() { return age; }
    public String getContact() { return contact; }
    public String getEmail() { return email; }
}
