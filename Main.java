
import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = DBConnection.getConnection()) {

            Scanner sc = new Scanner(System.in);  // ✅ Shared Scanner for entire program

            System.out.print("Username: ");
            String username = sc.nextLine();

            System.out.print("Password: ");
            String password = sc.nextLine();

            if (Loginsystem.login(username, password, conn)) {
                System.out.println("✅ Login successful!");

                while (true) {
                    System.out.println("\n1. Reserve Ticket");
                    System.out.println("2. Cancel Ticket");
                    System.out.println("3. Exit");
                    System.out.print("Enter your choice: ");

                    if (!sc.hasNextInt()) break; // Handle stray newline or Ctrl+D
                    int choice = sc.nextInt();
                    sc.nextLine(); // Clear newline

                    switch (choice) {
                        case 1 -> ReservationSystem.reserveTicket(username, conn, sc);  //  pass Scanner
                        case 2 -> CancellationSystem.cancelTicket(username, conn, sc);  // pass Scanner
                        case 3 -> {
                            System.out.println("👋 Exiting. Thank you!");
                            return;
                        }
                        default -> System.out.println("❌ Invalid choice.");
                    }
                }
            } else {
                System.out.println("❌ Invalid credentials.");
            }

        } catch (Exception e) {
            System.out.println("❌ System error.");
            e.printStackTrace();
        }
    }
}



