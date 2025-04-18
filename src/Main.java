import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("\n1. Signup\n2. Login\n3. Exit");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            if (choice == 1) {
                System.out.print("Enter Passenger/Staff ID (this will be your username): ");
                String userID = sc.nextLine();
                System.out.print("Enter password: ");
                String password = sc.nextLine();
                System.out.print("Are you passenger or staff? ");
                String role = sc.nextLine().toLowerCase();

                UserService.registerUser(userID, password, role);
            }
            else if (choice == 2) {
                System.out.print("Enter your ID (Passenger/Staff): ");
                String userID = sc.nextLine();
                System.out.print("Enter password: ");
                String password = sc.nextLine();

                String role = UserService.loginUser(userID, password);

                if (role != null) {
                    if (role.equals("passenger")) {
                        System.out.println("passenger");
                    } else if (role.equals("staff")) {
                        System.out.println("staff");
                    }
                }
            }
            else{
                sc.close();
            }

        }

    }
}

