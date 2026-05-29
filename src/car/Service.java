package car;

public class Service {
    private int serviceId;
    private String serviceName;
    private double serviceCost;
    private int duration;
    private String description;

    // Constructor, getters, and setters
    public Service(String serviceName, double serviceCost, int duration, String description) {
        this.serviceName = serviceName;
        this.serviceCost = serviceCost;
        this.duration = duration;
        this.description = description;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public double getServiceCost() {
        return serviceCost;
    }

    public int getDuration() {
        return duration;
    }

    public String getDescription() {
        return description;
    }
}

