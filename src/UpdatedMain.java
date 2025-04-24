import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Signup\n2. Login\n3. Update Passenger Info\n4. Exit");
            int choice = sc.nextInt();
            sc.nextLine();
            if (choice == 1) {
                System.out.print("Enter Passenger ID (this will be your username): ");
                String userID = sc.nextLine();
                System.out.print("Enter password: ");
                String password = sc.nextLine();
                System.out.print("Are you passenger? ");
                String role = sc.nextLine().toLowerCase();
                if (role.equals("passenger")) {
                    UserService.registerUser(userID, password, role);
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter passport number: ");
                    String passportNumber = sc.nextLine();
                    System.out.print("Enter age: ");
                    int age = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter contact number: ");
                    String contact = sc.nextLine();
                    System.out.print("Enter email: ");
                    String email = sc.nextLine();
                    Passenger p = new Passenger(userID, name, passportNumber, age, contact, email);
                    PassengerService.addPassenger(p); // Add passenger to the system
                }
            } else if (choice == 2) {
                System.out.print("Enter your ID (Passenger): ");
                String userID = sc.nextLine();
                System.out.print("Enter password: ");
                String password = sc.nextLine();
                String role = UserService.loginUser(userID, password);
                if (role != null && role.equals("passenger")) {
                    System.out.println("Logged in as Passenger");
                } else {
                    System.out.println("Invalid credentials or role.");
                }
            } else if (choice == 3) {
                System.out.print("Enter Passenger ID to update: ");
                String passengerID = sc.nextLine();
                System.out.print("Which field would you like to update? (name, passportnumber, age, contact, email): ");
                String field = sc.nextLine();
                System.out.print("Enter new value: ");
                String newValue = sc.nextLine();
                PassengerService.updatePassenger(passengerID, field, newValue);  // Pass the passengerID, field, and new value
            } else {
                System.out.println("Exiting... Goodbye!");
                sc.close();
                break;
            }
        }
    }
}
