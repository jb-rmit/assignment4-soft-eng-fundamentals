

import java.util.List;


public class BusRepository {
    private List<Bus> buses;

    public void Add(String id, int capacity, double fuelLevel, String fuelType, Driver driver) {

        //BUS ID VALIDATION CHECK
        for (Bus currentBus : buses) {
            if (id.equals(currentBus.getBusId())) {
                throw new IllegalArgumentException("Bus already exists");
            }
        }
        //B1 - Max length: 8, numbers only digits
        if (id.length() != 8 || id.matches("[0-9]+")) {
            throw new IllegalArgumentException("Bus ID is invalid");
        }

        //B3 - Driver age check
        if (driver.getAge() > 50 && capacity > 50) {
            throw new IllegalArgumentException("Driver is too old to drive this bus.");
        }

        //B4 - Electricity restriction
        if (driver.getExperienceYears() < 5 && fuelType.equals("Electricity")) {
            throw new IllegalArgumentException("Driver does not have enough experience to drive Electric bus.");
        }

        //B5 - Heavy & Public transport
        if (fuelType.equals("Electricity") || fuelType.equals("Hybrid")) {
            if (driver.getLicenseType().equals("Light") || driver.getLicenseType().equals("Medium")) {
                throw new IllegalArgumentException("Driver does not have a heavy-enough license to drive this bus.");
            }
        }

        Bus newBus = new Bus(id, capacity, fuelLevel, fuelType, driver);
        buses.add(newBus);


    }

    public void Update(String id, int capacity, double fuelLevel, String fuelType, Driver driver) {



        for (Bus currentBus : buses) {
            if (id.equals(currentBus.getBusId())) {

                //B3 - Driver age check
                if (driver.getAge() > 50 && capacity > 50) {
                    throw new IllegalArgumentException("Driver is too old to drive this bus.");
                }

                //B4 - Electricity restriction
                if (driver.getExperienceYears() < 5 && fuelType.equals("Electricity")) {
                    throw new IllegalArgumentException("Driver does not have enough experience to drive Electric bus.");
                }

                //B5 - Heavy & Public transport
                if (fuelType.equals("Electricity") || fuelType.equals("Hybrid")) {
                    if (driver.getLicenseType().equals("Light") || driver.getLicenseType().equals("Medium")) {
                        throw new IllegalArgumentException("Driver does not have a heavy-enough license to drive this bus.");
                    }
                }


                //B2 - Only decrease allowed
                if (currentBus.getCapacity() >= capacity) {

                    //EVERYTHING IS OK, UPDATE BUS
                    currentBus.setCapacity(capacity);
                    currentBus.setFuelLevel(fuelLevel);
                    currentBus.setFuelType(fuelType);
                    currentBus.setDriver(driver);
                } else {
                    throw new IllegalArgumentException("Capacity cannot increase on update.");
                }
            } else {
                throw new IllegalArgumentException("Bus does not exist.");
            }
        }
    }

    public List<Bus> Retrieve() {
        return buses;
    }

    public int Count() {
        return buses.size();
    }



}
