package car;

import java.sql.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            // Connect to the database
            Connection conn = DatabaseHelper.getConnection();

            // Main menu with options
            while (true) {
                System.out.println("\n=== Car Maintenance and Service Management System ===");
                System.out.println("1. Insert Customer");
                System.out.println("2. Insert Car");
                System.out.println("3. Insert Service");
                System.out.println("4. Insert Maintenance Record");
                System.out.println("5. Exit");
                System.out.print("Please choose an option: ");
                int choice = sc.nextInt();
                sc.nextLine(); // Consume newline character after nextInt

                switch (choice) {
                    case 1:
                        insertCustomer(conn, sc);
                        break;
                    case 2:
                        insertCar(conn, sc);
                        break;
                    case 3:
                        insertService(conn, sc);
                        break;
                    case 4:
                        insertMaintenanceRecord(conn, sc);
                        break;
                    case 5:
                        System.out.println("Exiting the system. Goodbye!");
                        DatabaseHelper.closeConnection(conn, null, null);
                        return; // Exit the program
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Method to insert customer into the Customers table with validation
    private static void insertCustomer(Connection conn, Scanner sc) throws SQLException {
        System.out.print("Enter customer name: ");
        String name = sc.nextLine();
        if (name.isEmpty()) {
            System.out.println("Error: Name cannot be empty.");
            return;
        }

        System.out.print("Enter contact number: ");
        String contactNumber = sc.nextLine();
        if (!contactNumber.matches("\\d{10}")) { // Example validation for 10-digit contact numbers
            System.out.println("Error: Contact number must be 10 digits.");
            return;
        }

        System.out.print("Enter email: ");
        String email = sc.nextLine();
        if (!isValidEmail(email)) {
            System.out.println("Error: Invalid email format.");
            return;
        }

        System.out.print("Enter address: ");
        String address = sc.nextLine();
        if (address.isEmpty()) {
            System.out.println("Error: Address cannot be empty.");
            return;
        }

        String query = "INSERT INTO Customers (name, contact_number, email, address) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setString(2, contactNumber);
            stmt.setString(3, email);
            stmt.setString(4, address);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Customer added successfully.");
            } else {
                System.out.println("Error: Customer could not be added.");
            }
        }
    }

    // Method to insert car into the Cars table with validation
    private static void insertCar(Connection conn, Scanner sc) throws SQLException {
        System.out.print("Enter customer ID for the car: ");
        int customerId = sc.nextInt();
        sc.nextLine(); // Consume newline character
        if (!isCustomerIdValid(conn, customerId)) {
            System.out.println("Error: Invalid Customer ID.");
            return;
        }

        System.out.print("Enter car license plate: ");
        String licensePlate = sc.nextLine();
        if (licensePlate.isEmpty()) {
            System.out.println("Error: License plate cannot be empty.");
            return;
        }

        System.out.print("Enter car make: ");
        String make = sc.nextLine();
        if (make.isEmpty()) {
            System.out.println("Error: Car make cannot be empty.");
            return;
        }

        System.out.print("Enter car model: ");
        String model = sc.nextLine();
        if (model.isEmpty()) {
            System.out.println("Error: Car model cannot be empty.");
            return;
        }

        System.out.print("Enter car year: ");
        int year = sc.nextInt();
        sc.nextLine(); // Consume newline character
        if (year < 1900 || year > 2024) {
            System.out.println("Error: Invalid car year.");
            return;
        }

        System.out.print("Enter car VIN: ");
        String vin = sc.nextLine();
        if (vin.isEmpty()) {
            System.out.println("Error: VIN cannot be empty.");
            return;
        }

        String query = "INSERT INTO Cars (customer_id, license_plate, make, model, year, vin) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, customerId);
            stmt.setString(2, licensePlate);
            stmt.setString(3, make);
            stmt.setString(4, model);
            stmt.setInt(5, year);
            stmt.setString(6, vin);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Car added successfully.");
            } else {
                System.out.println("Error: Car could not be added.");
            }
        }
    }

    // Method to insert service into the Services table with validation
    private static void insertService(Connection conn, Scanner sc) throws SQLException {
        System.out.print("Enter service name: ");
        String serviceName = sc.nextLine();
        if (serviceName.isEmpty()) {
            System.out.println("Error: Service name cannot be empty.");
            return;
        }

        System.out.print("Enter service cost: ");
        double serviceCost = sc.nextDouble();
        if (serviceCost <= 0) {
            System.out.println("Error: Service cost must be a positive number.");
            return;
        }

        System.out.print("Enter service duration (in minutes): ");
        int duration = sc.nextInt();
        if (duration <= 0) {
            System.out.println("Error: Duration must be a positive number.");
            return;
        }
        sc.nextLine(); // Consume newline character

        System.out.print("Enter service description: ");
        String description = sc.nextLine();
        if (description.isEmpty()) {
            System.out.println("Error: Service description cannot be empty.");
            return;
        }

        String query = "INSERT INTO Services (service_name, service_cost, duration, description) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, serviceName);
            stmt.setDouble(2, serviceCost);
            stmt.setInt(3, duration);
            stmt.setString(4, description);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Service added successfully.");
            } else {
                System.out.println("Error: Service could not be added.");
            }
        }
    }

    // Method to insert maintenance record into the MaintenanceRecords table with validation
    private static void insertMaintenanceRecord(Connection conn, Scanner sc) throws SQLException {
        System.out.print("Enter car ID for the maintenance record: ");
        int carId = sc.nextInt();
        if (!isCarIdValid(conn, carId)) {
            System.out.println("Error: Invalid Car ID.");
            return;
        }

        System.out.print("Enter service ID for the maintenance record: ");
        int serviceId = sc.nextInt();
        if (!isServiceIdValid(conn, serviceId)) {
            System.out.println("Error: Invalid Service ID.");
            return;
        }
        sc.nextLine(); // Consume newline character

        System.out.print("Enter scheduled date (YYYY-MM-DD): ");
        String scheduledDate = sc.nextLine();
        Date scheduledDateValue = Date.valueOf(scheduledDate);

        if (scheduledDateValue.before(new Date(System.currentTimeMillis()))) {
            System.out.println("Error: Scheduled date must be in the future.");
            return;
        }

        String query = "INSERT INTO MaintenanceRecords (car_id, service_id, scheduled_date) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, carId);
            stmt.setInt(2, serviceId);
            stmt.setDate(3, scheduledDateValue);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Maintenance record added successfully.");
            } else {
                System.out.println("Error: Maintenance record could not be added.");
            }
        }
    }

    // Helper method to check if customer ID is valid
    private static boolean isCustomerIdValid(Connection conn, int customerId) throws SQLException {
        String query = "SELECT COUNT(*) FROM Customers WHERE customer_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, customerId);
            ResultSet rs = stmt.executeQuery();
            return rs.next() && rs.getInt(1) > 0;
        }
    }

    // Helper method to check if car ID is valid
    private static boolean isCarIdValid(Connection conn, int carId) throws SQLException {
        String query = "SELECT COUNT(*) FROM Cars WHERE car_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, carId);
            ResultSet rs = stmt.executeQuery();
            return rs.next() && rs.getInt(1) > 0;
        }
    }

    // Helper method to check if service ID is valid
    private static boolean isServiceIdValid(Connection conn, int serviceId) throws SQLException {
        String query = "SELECT COUNT(*) FROM Services WHERE service_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, serviceId);
            ResultSet rs = stmt.executeQuery();
            return rs.next() && rs.getInt(1) > 0;
        }
    }

    // Helper method to validate email format
    private static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
