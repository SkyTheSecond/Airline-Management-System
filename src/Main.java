import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserService userService = new UserService(); // Assuming you have this

        System.out.println("Welcome to Airline Management System");
        System.out.println("Select User Type:");
        System.out.println("1. Passenger");
        System.out.println("2. Staff");
        System.out.print("Enter your choice (1 or 2): ");
        int userType = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (userType == 1) {
            System.out.println("1. Login as Passenger");
            System.out.println("2. Signup as Passenger");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 1) {
                if (userService.loginPassenger(scanner)) {
//                    passengerDashboard(scanner, userService);
                    System.out.println("success");
                }
            } else {
                userService.signupPassenger(scanner);
            }

        } else if (userType == 2) {
            System.out.println("1. Login as Staff");
            System.out.println("2. Signup as Staff");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 1) {
                if (userService.loginStaff(scanner)) {
//                    staffDashboard(scanner, userService);
                    System.out.println("success");
                }
            } else {
                userService.signupStaff(scanner);
            }
        } else {
            System.out.println("Invalid input. Exiting...");
        }

        scanner.close();
    }

//     Passenger dashboard
//    private static void passengerDashboard(Scanner scanner, UserService userService) {
//        while (true) {
//            System.out.println("\n--- Passenger Dashboard ---");
//            System.out.println("1. Book Flight");
//            System.out.println("2. Cancel Flight");
//            System.out.println("3. View Booking Data");
//            System.out.println("4. Exit");
//            System.out.print("Enter your choice: ");
//
//            int option = scanner.nextInt();
//            scanner.nextLine(); // Consume newline
//
//            switch (option) {
//                case 1:
//                    userService.bookFlight(scanner);
//                    break;
//                case 2:
//                    userService.cancelFlight(scanner);
//                    break;
//                case 3:
//                    userService.fetchBookingData(scanner);
//                    break;
//                case 4:
//                    System.out.println("Logging out...");
//                    return;
//                default:
//                    System.out.println("Invalid choice!");
//            }
//        }
//    }
//
//    // Staff dashboard
//    private static void staffDashboard(Scanner scanner, UserService userService) {
//        while (true) {
//            System.out.println("\n--- Staff Dashboard ---");
//            System.out.println("1. View Assigned Flights");
//            System.out.println("2. Take Leave");
//            System.out.println("3. Fetch Work Data");
//            System.out.println("4. Exit");
//            System.out.print("Enter your choice: ");
//
//            int option = scanner.nextInt();
//            scanner.nextLine(); // Consume newline
//
//            switch (option) {
//                case 1:
//                    userService.viewAssignedFlights(scanner);
//                    break;
//                case 2:
//                    userService.takeLeave(scanner);
//                    break;
//                case 3:
//                    userService.fetchWorkData(scanner);
//                    break;
//                case 4:
//                    System.out.println("Logging out...");
//                    return;
//                default:
//                    System.out.println("Invalid choice!");
//            }
//        }
//    }
}
