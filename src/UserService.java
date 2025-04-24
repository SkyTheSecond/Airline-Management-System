import java.sql.*;
public class UserService {
    public static boolean registerUser(String userID, String password, String role) {
        String query = "INSERT INTO user (username, password, role) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, userID); // same as username
            stmt.setString(2, password);
            stmt.setString(3, role);
            stmt.executeUpdate();
            System.out.println("User registered successfully.");
            return true;
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("UserID already exists.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static String loginUser(String userID, String password) {
        String query = "SELECT role FROM user WHERE username = ? AND password = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, userID);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String role = rs.getString("role");
                System.out.println("Login successful as " + role + ". Your ID: " + userID);
                return role;
            } else {
                System.out.println("Invalid userID or password.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}




// import java.util.Scanner;
// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;


// public class UserService {



//     // ---------- PASSENGER METHODS ----------

//     public boolean loginPassenger(Scanner scanner) {
//         System.out.print("Enter Passenger ID: ");
//         String passengerID = scanner.nextLine();
//         System.out.print("Enter Passport Number: ");
//         String passportNumber = scanner.nextLine();

//         String sql = "SELECT * FROM Passenger WHERE passengerID = ? AND passportNumber = ?";

//         try (
//                 Connection conn = DBConnection.getConnection();
//                 PreparedStatement stmt = conn.prepareStatement(sql)
//         ) {
//             stmt.setString(1, passengerID);
//             stmt.setString(2, passportNumber);
//             ResultSet rs = stmt.executeQuery();
//             if (rs.next()) {
//                 System.out.println("Login successful for Passenger: " + passengerID);
//                 return true;
//             } else {
//                 System.out.println("Invalid credentials.");
//                 return false;
//             }
//         } catch (Exception e) {
//             e.printStackTrace();
//             return false;
//         }
//     }


//     public void signupPassenger(Scanner scanner) {
//         System.out.print("Enter Passenger ID: ");
//         String id = scanner.nextLine();
//         System.out.print("Enter Name: ");
//         String name = scanner.nextLine();
//         System.out.print("Enter Passport Number: ");
//         String passport = scanner.nextLine();
//         System.out.print("Enter Age: ");
//         int age = scanner.nextInt();
//         scanner.nextLine();
//         System.out.print("Enter Contact: ");
//         String contact = scanner.nextLine();
//         System.out.print("Enter Email: ");
//         String email = scanner.nextLine();

//         String sql = "INSERT INTO Passenger (passengerID, name, passportNumber, age, contact, email) VALUES (?, ?, ?, ?, ?, ?)";

//         try (
//                 Connection conn = DBConnection.getConnection();

//                 PreparedStatement stmt = conn.prepareStatement(sql)
//         ) {
//             stmt.setString(1, id);
//             stmt.setString(2, name);
//             stmt.setString(3, passport);
//             stmt.setInt(4, age);
//             stmt.setString(5, contact);
//             stmt.setString(6, email);
//             stmt.executeUpdate();
//             System.out.println("Passenger registered successfully: " + name);
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }


//     public void signupStaff(Scanner scanner) {
//         System.out.print("Enter Staff ID: ");
//         String id = scanner.nextLine();
//         System.out.print("Enter Name: ");
//         String name = scanner.nextLine();
//         System.out.print("Enter Role (e.g., Pilot, Attendant): ");
//         String role = scanner.nextLine();
//         System.out.print("Enter Age: ");
//         int age = scanner.nextInt();
//         scanner.nextLine();
//         System.out.print("Enter Contact: ");
//         String contact = scanner.nextLine();
//         System.out.print("Enter Email: ");
//         String email = scanner.nextLine();

//         String sql = "INSERT INTO Staff (staffID, name, role, age, contact, email) VALUES (?, ?, ?, ?, ?, ?)";

//         try (
//                 Connection conn = DBConnection.getConnection();
//                 PreparedStatement stmt = conn.prepareStatement(sql)
//         ) {
//             stmt.setString(1, id);
//             stmt.setString(2, name);
//             stmt.setString(3, role);
//             stmt.setInt(4, age);
//             stmt.setString(5, contact);
//             stmt.setString(6, email);
//             stmt.executeUpdate();
//             System.out.println("Staff registered successfully: " + name);
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }


//     public boolean loginStaff(Scanner scanner) {
//         System.out.print("Enter Staff ID: ");
//         String staffID = scanner.nextLine();
//         System.out.print("Enter Email: ");
//         String email = scanner.nextLine();

//         String sql = "SELECT * FROM Staff WHERE staffID = ? AND email = ?";

//         try (
//                 Connection conn = DBConnection.getConnection();
//                 PreparedStatement stmt = conn.prepareStatement(sql)
//         ) {
//             stmt.setString(1, staffID);
//             stmt.setString(2, email);
//             ResultSet rs = stmt.executeQuery();
//             if (rs.next()) {
//                 System.out.println("Login successful for Staff: " + staffID);
//                 return true;
//             } else {
//                 System.out.println("Invalid credentials.");
//                 return false;
//             }
//         } catch (Exception e) {
//             e.printStackTrace();
//             return false;
//         }
//     }


//    public void bookFlight(Scanner scanner) {
//        System.out.print("Enter Passenger ID: ");
//        String passengerID = scanner.nextLine();
//
//        System.out.print("Enter Flight ID to book: ");
//        String flightID = scanner.nextLine();
//
//        try (Connection conn = DBConnection.getConnection()) {
//
//            // 1. Check if flight exists and has available seats
//            String checkFlightQuery = "SELECT availableSeats FROM Flight WHERE flightID = ?";
//            PreparedStatement checkStmt = conn.prepareStatement(checkFlightQuery);
//            checkStmt.setString(1, flightID);
//            ResultSet rs = checkStmt.executeQuery();
//
//            if (rs.next()) {
//                int availableSeats = rs.getInt("availableSeats");
//                if (availableSeats > 0) {
//
//                    // 2. Insert into Passenger_Flight
//                    String insertBooking = "INSERT INTO Passenger_Flight (passengerID, flightID) VALUES (?, ?)";
//                    PreparedStatement insertStmt = conn.prepareStatement(insertBooking);
//                    insertStmt.setString(1, passengerID);
//                    insertStmt.setString(2, flightID);
//                    insertStmt.executeUpdate();
//
//                    // 3. Update available seats in Flight
//                    String updateSeats = "UPDATE Flight SET availableSeats = availableSeats - 1 WHERE flightID = ?";
//                    PreparedStatement updateStmt = conn.prepareStatement(updateSeats);
//                    updateStmt.setString(1, flightID);
//                    updateStmt.executeUpdate();
//
//                    System.out.println("✅ Flight booked successfully for passenger: " + passengerID);
//                } else {
//                    System.out.println("❌ No seats available for flight ID: " + flightID);
//                }
//            } else {
//                System.out.println("❌ Flight ID not found.");
//            }
//
//        } catch (SQLException e) {
//            System.out.println("❌ Error booking flight: " + e.getMessage());
//        }
//    }

}
