//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Username: ");
//        String username = sc.nextLine();
//        System.out.print("Password: ");
//        String password = sc.nextLine();
//
//        if (Loginsystem.login(username, password)) {
//            System.out.println("✅ Login successful!");
//            while (true) {
//                System.out.println("\n1. Reserve Ticket\n2. Cancel Ticket\n3. Exit");
//                System.out.print("Enter your choice: ");
//                int choice = sc.nextInt();
//                sc.nextLine(); // clear buffer
//
//                switch (choice) {
//                    case 1:
//                        ReservationSystem.reserveTicket(username);
//                        break;
//                    case 2:
//                        CancellationSystem.cancelTicket();
//                        break;
//                    case 3:
//                        System.out.println("👋 Thank you!");
//                        return;
//                    default:
//                        System.out.println("❌ Invalid choice!");
//                }
//            }
//        } else {
//            System.out.println("❌ Invalid credentials.");
//        }
//    }
//}


//import java.sql.Connection;
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        try (Connection conn = DBConnection.getConnection();
//             Scanner sc = new Scanner(System.in)) {
//
//            System.out.print("Username: ");
//            String username = sc.nextLine();
//
//            System.out.print("Password: ");
//            String password = sc.nextLine();
//
//            if (Loginsystem.login(username, password, conn)) {
//                System.out.println("✅ Login successful!");
//
//                while (true) {
//                    System.out.println("\n1. Reserve Ticket");
//                    System.out.println("2. Cancel Ticket");
//                    System.out.println("3. Exit");
//                    System.out.print("Enter your choice: ");
//                    int choice = sc.nextInt();
//                    sc.nextLine(); // flush newline
//
//                    switch (choice) {
//                        case 1 -> ReservationSystem.reserveTicket(username, conn);
//                        case 2 -> CancellationSystem.cancelTicket(username, conn);
//                        case 3 -> {
//                            System.out.println("👋 Exiting. Thank you!");
//                            return;
//                        }
//                        default -> System.out.println("❌ Invalid choice.");
//                    }
//                }
//            } else {
//                System.out.println("❌ Invalid credentials.");
//            }
//
//        } catch (Exception e) {
//            System.out.println("❌ System error.");
//            e.printStackTrace();
//        }
//    }
//}


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


