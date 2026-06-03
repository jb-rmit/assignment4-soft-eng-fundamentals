

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class BusRepository {
    private List<Bus> buses = new ArrayList<>();
    private DriverRepository driverRepository = new DriverRepository();

    public void setDriverRepository(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public void readDatabaseTextFile(String busDatabaseFilePath) {

        File busDatabaseFile = new File(busDatabaseFilePath);
        //code adapted from W3Schools: https://www.w3schools.com/java/java_files_read.asp
        // try-with-resources: Scanner will be closed automatically
        try (Scanner myReader = new Scanner(busDatabaseFile)) {

            //count line for logging
            int lineNumber = 0;

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                //split line on comma, used for separating fields
                String[] busFields = data.split(",");

                //if there are not exactly 5 fields, the line is malformed. Skip.
                if (busFields.length != 5) {
                    System.out.println("Invalid data format at line " + lineNumber + ". Skipping.");
                    continue;
                }


                //check if driver exists
                Driver driver = driverRepository.getDriverById(busFields[4]);

                if (driver == null) {
                    throw new IllegalArgumentException("Driver does not exist in Bus entry line " + lineNumber + ".");
                }

                //all is well, so run validation checks in Add method.
                this.Add(busFields[0], Integer.parseInt(busFields[1]), Double.parseDouble(busFields[2]), busFields[3], driver);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File " + busDatabaseFilePath + " not found.");
        }
    }

    public void Add(String id, int capacity, double fuelLevel, String fuelType, Driver driver) {

        //BUS ID VALIDATION CHECK
        for (Bus currentBus : buses) {
            if (id.equals(currentBus.getBusId())) {
                throw new IllegalArgumentException("Bus already exists");
            }
        }
        //B1 - Max length: 8, numbers only digits
        if (id.length() != 8 || !id.matches("[0-9]+")) {
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
