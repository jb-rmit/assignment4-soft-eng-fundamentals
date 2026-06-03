

public class Bus {
    private String busId;
    private int capacity;
    private double fuelLevel;
    private String fuelType; //Diesel, Hybrid, Electricity
    private Driver driver;

    Bus(String busId, int capacity, double fuelLevel, String fuelType, Driver driver) {
        this.busId = busId;
        this.capacity = capacity;
        this.fuelLevel = fuelLevel;
        this.fuelType = fuelType;
        this.driver = driver;
    }

    public String getBusId() {
        return busId;
    }

    public void setBusId(String busId) { this.busId = busId; }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getFuelLevel() {
        return fuelLevel;
    }

    public void setFuelLevel(double fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
    public Driver getDriver() {
        return driver;
    }

}
