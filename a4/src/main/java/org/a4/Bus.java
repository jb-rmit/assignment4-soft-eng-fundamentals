package org.a4;

public class Bus {
    private String busId;
    private int capacity;
    private double fuelLevel;
    private String fuelType; //Diesel, Hybrid, Electricity

    Bus(String busId, int capacity, double fuelLevel, String fuelType) {
        this.busId = busId;
        this.capacity = capacity;
        this.fuelLevel = fuelLevel;
        this.fuelType = fuelType;
    }

    public String getBusId() {
        return busId;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getFuelLevel() {
        return fuelLevel;
    }

    public String getFuelType() {
        return fuelType;
    }

}
