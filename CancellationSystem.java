//import java.sql.*;
//import java.util.Scanner;
//
//public class CancellationSystem {
//
//    public static void cancelTicket(String currentUser, Connection conn) {
//        try (Scanner sc = new Scanner(System.in)) {
//
//            System.out.print("Enter your PNR number: ");
//            int pnr = sc.nextInt();
//            sc.nextLine(); // flush
//
//            String sql = "SELECT * FROM reservations WHERE pnr = ?";
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setInt(1, pnr);
//            ResultSet rs = ps.executeQuery();
//
//            if (rs.next()) {
//                String bookedUser = rs.getString("username");
//
//                if (!bookedUser.equals(currentUser)) {
//                    System.out.println("❌ You cannot cancel this ticket. It belongs to another user.");
//                    return;
//                }
//
//                System.out.println("------ TICKET TO CANCEL ------");
//                System.out.println("PNR         : " + rs.getInt("pnr"));
//                System.out.println("Train No    : " + rs.getString("train_no"));
//                System.out.println("Train Name  : " + rs.getString("train_name"));
//                System.out.println("From        : " + rs.getString("from_station"));
//                System.out.println("To          : " + rs.getString("to_station"));
//                System.out.println("Seat No     : " + rs.getInt("seat_no"));
//                System.out.println("Berth Type  : " + rs.getString("berth_type"));
//                System.out.println("Coach       : " + rs.getString("coach_no"));
//                System.out.print("Confirm cancellation? (yes/no): ");
//                String confirm = sc.nextLine();
//
//                if (confirm.equalsIgnoreCase("yes")) {
//                    PreparedStatement del = conn.prepareStatement("DELETE FROM reservations WHERE pnr = ?");
//                    del.setInt(1, pnr);
//                    int deleted = del.executeUpdate();
//                    if (deleted > 0) {
//                        System.out.println("✅ Ticket cancelled successfully.");
//                    } else {
//                        System.out.println("❌ Cancellation failed.");
//                    }
//                } else {
//                    System.out.println("🚫 Cancellation aborted.");
//                }
//
//            } else {
//                System.out.println("❌ No ticket found with PNR " + pnr);
//            }
//
//        } catch (Exception e) {
//            System.out.println("❌ Error during cancellation.");
//            e.printStackTrace();
//        }
//    }
//}

import java.sql.*;
import java.util.Scanner;

public class CancellationSystem {
    public static void cancelTicket(String currentUser, Connection conn, Scanner sc) {
        try {
            System.out.print("Enter your PNR number: ");
            int pnr = sc.nextInt();
            sc.nextLine();

            String sql = "SELECT * FROM reservations WHERE pnr = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, pnr);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                if (!rs.getString("username").equals(currentUser)) {
                    System.out.println("\u274C You cannot cancel this ticket. It belongs to another user.");
                    return;
                }

                System.out.println("------ TICKET TO CANCEL ------");
                System.out.println("PNR         : " + rs.getInt("pnr"));
                System.out.println("Train No    : " + rs.getString("train_no"));
                System.out.println("Train Name  : " + rs.getString("train_name"));
                System.out.println("From        : " + rs.getString("from_station"));
                System.out.println("To          : " + rs.getString("to_station"));
                System.out.println("Seat No     : " + rs.getInt("seat_no"));
                System.out.println("Berth Type  : " + rs.getString("berth_type"));
                System.out.println("Coach       : " + rs.getString("coach_no"));
                System.out.print("Confirm cancellation? (yes/no): ");
                String confirm = sc.nextLine();

                if (confirm.equalsIgnoreCase("yes")) {
                    PreparedStatement del = conn.prepareStatement("DELETE FROM reservations WHERE pnr = ?");
                    del.setInt(1, pnr);
                    int deleted = del.executeUpdate();
                    if (deleted > 0) {
                        System.out.println("\u2705 Ticket cancelled successfully.");
                    } else {
                        System.out.println("\u274C Cancellation failed.");
                    }
                } else {
                    System.out.println("\u274C Cancellation aborted.");
                }

            } else {
                System.out.println("\u274C No ticket found with PNR " + pnr);
            }

        } catch (Exception e) {
            System.out.println("\u274C Error during cancellation.");
            e.printStackTrace();
        }
    }
}
