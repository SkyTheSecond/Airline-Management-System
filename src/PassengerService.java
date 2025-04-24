
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class PassengerService {
    public static void addPassenger(Passenger p) {
        String sql = "INSERT INTO passenger (passengerID, name, passportNumber, age, contact, email) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, p.getPassengerID());
            stmt.setString(2, p.getName());
            stmt.setString(3, p.getPassportNumber());
            stmt.setInt(4, p.getAge());
            stmt.setString(5, p.getContact());
            stmt.setString(6, p.getEmail());
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Passenger registered successfully.");
            } else {
                System.out.println("Error occurred while adding passenger to the database.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error occurred while adding passenger to the database.");
        }
    }
    public static void updatePassenger(String passengerID, String field, String newValue) {
        String sql = "";
        switch (field.toLowerCase()) {
            case "name":
                sql = "UPDATE passenger SET name = ? WHERE passengerID = ?";
                break;
            case "passportnumber":
                sql = "UPDATE passenger SET passportNumber = ? WHERE passengerID = ?";
                break;
            case "age":
                sql = "UPDATE passenger SET age = ? WHERE passengerID = ?";
                break;
            case "contact":
                sql = "UPDATE passenger SET contact = ? WHERE passengerID = ?";
                break;
            case "email":
                sql = "UPDATE passenger SET email = ? WHERE passengerID = ?";
                break;
            default:
                System.out.println("Invalid field.");
                return;
        }
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            if (field.equalsIgnoreCase("age")) {
                stmt.setInt(1, Integer.parseInt(newValue)); // Age is an integer
            } else {
                stmt.setString(1, newValue); // Other fields are strings
            }
            stmt.setString(2, passengerID); // Set the passengerID to identify which passenger to update
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Passenger's " + field + " updated successfully.");
            } else {
                System.out.println("No passenger found with ID: " + passengerID);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error occurred while updating passenger information.");
        }
    }
}
