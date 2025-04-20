public class Flight {
    private String flightID;
    private String origin;
    private String destination;
    private String departureTime;
    private String arrivalTime;
    private int totalSeats;
    private int availableSeats;

    public Flight(String flightID, String origin, String destination, String departureTime, String arrivalTime, int totalSeats) {
        this.flightID = flightID;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats; // Initially, all seats are available
    }

    // Method to fetch flight details
    public void fetchDetails() {
        System.out.println("Flight ID: " + flightID);
        System.out.println("From: " + origin + " To: " + destination);
        System.out.println("Departure: " + departureTime + " Arrival: " + arrivalTime);
        System.out.println("Available Seats: " + availableSeats + "/" + totalSeats);
    }

    // Method to book a seat
    public void bookSeat() {
        if (availableSeats > 0) {
            availableSeats--;
            System.out.println("Seat booked successfully. Seats left: " + availableSeats);
        } else {
            System.out.println("No available seats on this flight.");
        }
    }

    // Method to cancel a seat
    public void cancelSeat() {
        if (availableSeats < totalSeats) {
            availableSeats++;
            System.out.println("Seat cancellation successful. Seats left: " + availableSeats);
        } else {
            System.out.println("All seats are already available.");
        }
    }
}
