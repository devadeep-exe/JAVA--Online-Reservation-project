
import java.sql.*;
import java.util.Random;
//import java.util.Scanner;
//
//public class ReservationSystem {
//
//    public static void reserveTicket(String currentUser, Connection conn) {
//        try (Scanner sc = new Scanner(System.in)) {
//
//            System.out.print("Train Number: ");
//            String trainNo = sc.nextLine();
//
//            System.out.print("Train Name: ");
//            String trainName = sc.nextLine();
//
//            System.out.print("Class Type (Sleeper/AC/General): ");
//            String classType = sc.nextLine();
//
//            System.out.print("Date of Journey (YYYY-MM-DD): ");
//            String doj = sc.nextLine();
//
//            System.out.print("From Station: ");
//            String fromStation = sc.nextLine();
//
//            System.out.print("To Station: ");
//            String toStation = sc.nextLine();
//
//            // Generate random seat and coach info
//            Random rand = new Random();
//            int seatNo = rand.nextInt(72) + 1;
//
//            String[] berthTypes = {"Lower", "Middle", "Upper", "Side Lower", "Side Upper"};
//            String berthType = berthTypes[rand.nextInt(berthTypes.length)];
//
//            String coachPrefix = switch (classType.toLowerCase()) {
//                case "sleeper" -> "S";
//                case "general" -> "D";
//                default -> "B"; // default to AC
//            };
//            String coachNo = coachPrefix + (rand.nextInt(12) + 1);
//
//            // Generate 6-digit unique PNR
//            int pnr = generateUniquePNR(conn);
//
//            String sql = "INSERT INTO reservations(pnr, username, train_no, train_name, class_type, doj, from_station, to_station, seat_no, berth_type, coach_no) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//            PreparedStatement ps = conn.prepareStatement(sql);
//
//            ps.setInt(1, pnr);
//            ps.setString(2, currentUser);
//            ps.setString(3, trainNo);
//            ps.setString(4, trainName);
//            ps.setString(5, classType);
//            ps.setDate(6, Date.valueOf(doj));
//            ps.setString(7, fromStation);
//            ps.setString(8, toStation);
//            ps.setInt(9, seatNo);
//            ps.setString(10, berthType);
//            ps.setString(11, coachNo);
//
//            int rowsInserted = ps.executeUpdate();
//            if (rowsInserted > 0) {
//                System.out.println("✅ Ticket reserved successfully!");
//                System.out.println("------ TICKET DETAILS ------");
//                System.out.println("PNR         : " + pnr);
//                System.out.println("User        : " + currentUser);
//                System.out.println("Train No    : " + trainNo);
//                System.out.println("Train Name  : " + trainName);
//                System.out.println("Class       : " + classType);
//                System.out.println("Date        : " + doj);
//                System.out.println("From        : " + fromStation);
//                System.out.println("To          : " + toStation);
//                System.out.println("Seat No     : " + seatNo);
//                System.out.println("Berth Type  : " + berthType);
//                System.out.println("Coach       : " + coachNo);
//                System.out.println("----------------------------");
//            }
//
//        } catch (Exception e) {
//            System.out.println("❌ Reservation failed.");
//            e.printStackTrace();
//        }
//    }
//
//    // Generates unique 6-digit PNR
//    private static int generateUniquePNR(Connection conn) throws SQLException {
//        Random rand = new Random();
//        int pnr;
//        while (true) {
//            pnr = 100000 + rand.nextInt(900000); // 6-digit
//            PreparedStatement check = conn.prepareStatement("SELECT pnr FROM reservations WHERE pnr = ?");
//            check.setInt(1, pnr);
//            ResultSet rs = check.executeQuery();
//            if (!rs.next()) break; // unique
//        }
//        return pnr;
//    }
//}

import java.sql.*;
import java.util.Random;
import java.util.Scanner;

public class ReservationSystem {
    public static void reserveTicket(String currentUser, Connection conn, Scanner sc) {
        try {
            System.out.print("Train Number: ");
            String trainNo = sc.nextLine();

            System.out.print("Train Name: ");
            String trainName = sc.nextLine();

            System.out.print("Class Type (Sleeper/AC/General): ");
            String classType = sc.nextLine();

            System.out.print("Date of Journey (YYYY-MM-DD): ");
            String doj = sc.nextLine();

            System.out.print("From Station: ");
            String fromStation = sc.nextLine();

            System.out.print("To Station: ");
            String toStation = sc.nextLine();

            Random rand = new Random();
            int seatNo = rand.nextInt(72) + 1;
            String[] berthTypes = {"Lower", "Middle", "Upper", "Side Lower", "Side Upper"};
            String berthType = berthTypes[rand.nextInt(berthTypes.length)];
            String coachPrefix = switch (classType.toLowerCase()) {
                case "sleeper" -> "S";
                case "general" -> "D";
                default -> "B";
            };
            String coachNo = coachPrefix + (rand.nextInt(12) + 1);
            int pnr = generateUniquePNR(conn);

            String sql = "INSERT INTO reservations(pnr, username, train_no, train_name, class_type, doj, from_station, to_station, seat_no, berth_type, coach_no) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, pnr);
            ps.setString(2, currentUser);
            ps.setString(3, trainNo);
            ps.setString(4, trainName);
            ps.setString(5, classType);
            ps.setDate(6, Date.valueOf(doj));
            ps.setString(7, fromStation);
            ps.setString(8, toStation);
            ps.setInt(9, seatNo);
            ps.setString(10, berthType);
            ps.setString(11, coachNo);

            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("\u2705 Ticket reserved successfully!");
                System.out.println("------ TICKET DETAILS ------");
                System.out.println("PNR         : " + pnr);
                System.out.println("User        : " + currentUser);
                System.out.println("Train No    : " + trainNo);
                System.out.println("Train Name  : " + trainName);
                System.out.println("Class       : " + classType);
                System.out.println("Date        : " + doj);
                System.out.println("From        : " + fromStation);
                System.out.println("To          : " + toStation);
                System.out.println("Seat No     : " + seatNo);
                System.out.println("Berth Type  : " + berthType);
                System.out.println("Coach       : " + coachNo);
                System.out.println("----------------------------");
            }

        } catch (Exception e) {
            System.out.println("\u274C Reservation failed.");
            e.printStackTrace();
        }
    }

    private static int generateUniquePNR(Connection conn) throws SQLException {
        Random rand = new Random();
        int pnr;
        while (true) {
            pnr = 100000 + rand.nextInt(900000);
            PreparedStatement check = conn.prepareStatement("SELECT pnr FROM reservations WHERE pnr = ?");
            check.setInt(1, pnr);
            ResultSet rs = check.executeQuery();
            if (!rs.next()) break;
        }
        return pnr;
    }
}


