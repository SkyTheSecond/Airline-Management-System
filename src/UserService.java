import java.sql.*;

public class UserService {

    public static boolean registerUser(String userID, String password, String role) {
        String query = "INSERT INTO users (username, password, role) VALUES (?, ?, ?)";

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
        String query = "SELECT role FROM users WHERE username = ? AND password = ?";

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
