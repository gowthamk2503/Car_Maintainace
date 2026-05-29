package car;

import java.sql.*;
import java.util.Scanner;

public class ServiceAppointment {

    // Method to schedule service appointment
    public static void scheduleAppointment(Connection conn, int carId, int serviceId, Date scheduledDate) throws SQLException {
        String query = "INSERT INTO MaintenanceRecords (car_id, service_id, scheduled_date, status) VALUES (?, ?, ?, 'Scheduled')";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, carId);
            stmt.setInt(2, serviceId);
            stmt.setDate(3, scheduledDate);
            stmt.executeUpdate();
            System.out.println("Service appointment scheduled successfully!");
        }
    }

    // Method to view appointments by car owner ID
    public static void viewAppointmentsByCarOwner(Connection conn, String carOwnerId) throws SQLException {
        String query = "SELECT * FROM MaintenanceRecords WHERE car_id IN (SELECT car_id FROM Cars WHERE customer_id = ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, carOwnerId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("Appointment ID: " + rs.getInt("record_id"));
                System.out.println("Service ID: " + rs.getInt("service_id"));
                System.out.println("Scheduled Date: " + rs.getDate("scheduled_date"));
                System.out.println("Status: " + rs.getString("status"));
                System.out.println("----------------------------------------");
            }
        }
    }
}
