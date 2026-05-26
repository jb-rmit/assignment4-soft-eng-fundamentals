package org.a4;

import java.util.List;

public class BusRepository {
    private List<Bus> buses;

    public void Add(String id, int capacity, double fuelLevel, String fuelType) {

        //DRIVER ID VALIDATION CHECK
        for (Bus currentBus : buses) {
            if (id.equals(currentBus.getBusId())) {
                throw new IllegalArgumentException("Driver already exists");
            }
        }


        Bus newBus = new Bus(id, capacity, fuelLevel, fuelType);
    }

}
