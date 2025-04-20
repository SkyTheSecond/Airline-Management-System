import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class UserService {



    // ---------- PASSENGER METHODS ----------

    public boolean loginPassenger(Scanner scanner) {
        System.out.print("Enter Passenger ID: ");
        String passengerID = scanner.nextLine();
        System.out.print("Enter Passport Number: ");
        String passportNumber = scanner.nextLine();

        String sql = "SELECT * FROM Passenger WHERE passengerID = ? AND passportNumber = ?";

        try (
                Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setString(1, passengerID);
            stmt.setString(2, passportNumber);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println("Login successful for Passenger: " + passengerID);
                return true;
            } else {
                System.out.println("Invalid credentials.");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public void signupPassenger(Scanner scanner) {
        System.out.print("Enter Passenger ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Passport Number: ");
        String passport = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Contact: ");
        String contact = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        String sql = "INSERT INTO Passenger (passengerID, name, passportNumber, age, contact, email) VALUES (?, ?, ?, ?, ?, ?)";

        try (
                Connection conn = DBConnection.getConnection();

                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setString(1, id);
            stmt.setString(2, name);
            stmt.setString(3, passport);
            stmt.setInt(4, age);
            stmt.setString(5, contact);
            stmt.setString(6, email);
            stmt.executeUpdate();
            System.out.println("Passenger registered successfully: " + name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void signupStaff(Scanner scanner) {
        System.out.print("Enter Staff ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Role (e.g., Pilot, Attendant): ");
        String role = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Contact: ");
        String contact = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        String sql = "INSERT INTO Staff (staffID, name, role, age, contact, email) VALUES (?, ?, ?, ?, ?, ?)";

        try (
                Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setString(1, id);
            stmt.setString(2, name);
            stmt.setString(3, role);
            stmt.setInt(4, age);
            stmt.setString(5, contact);
            stmt.setString(6, email);
            stmt.executeUpdate();
            System.out.println("Staff registered successfully: " + name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public boolean loginStaff(Scanner scanner) {
        System.out.print("Enter Staff ID: ");
        String staffID = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        String sql = "SELECT * FROM Staff WHERE staffID = ? AND email = ?";

        try (
                Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setString(1, staffID);
            stmt.setString(2, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println("Login successful for Staff: " + staffID);
                return true;
            } else {
                System.out.println("Invalid credentials.");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
