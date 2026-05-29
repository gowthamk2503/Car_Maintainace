package car;

public class Car {
    private int carId;
    private int customerId;
    private String licensePlate;
    private String make;
    private String model;
    private int year;
    private String vin;

    // Constructor, getters, and setters
    public Car(int customerId, String licensePlate, String make, String model, int year, String vin) {
        this.customerId = customerId;
        this.licensePlate = licensePlate;
        this.make = make;
        this.model = model;
        this.year = year;
        this.vin = vin;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getVin() {
        return vin;
    }
}
