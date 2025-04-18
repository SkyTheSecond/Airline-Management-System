import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/?user=root", "root", "#Hanu4321#");
            System.out.println("Connection successful!");
            conn.close();
        } catch (SQLException e) {
            System.out.println("Connection failed:");
            e.printStackTrace();
        }
    }
}   