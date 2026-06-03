

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class


public class DriverRepository {
    private List<Driver> drivers = new ArrayList<>();

    public void readDatabaseTextFile(String driverDatabaseFilePath) {

        File driverDatabaseFile = new File(driverDatabaseFilePath);
        //code adapted from w3schools: https://www.w3schools.com/java/java_files_read.asp
        // try-with-resources: Scanner will be closed automatically
        try (Scanner myReader = new Scanner(driverDatabaseFile)) {

            //count line for logging
            int lineNumber = 0;

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                //split line on comma, used for separating fields
                String[] driverFields = data.split(",");

                //if there are not exactly 6 fields, the line is malformed. Skip.
                if (driverFields.length != 6) {
                    System.out.println("Invalid data format at line " + lineNumber + ". Skipping.");
                    continue;
                }

                //all is well, so run validation checks in Add method.
                this.Add(driverFields[0], driverFields[1], Integer.parseInt(driverFields[2]), driverFields[3], driverFields[4], driverFields[5]);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File driver_database.txt not found.");
        }
    }

    public void Add(String id, String name, int experienceYears, String licenseType, String address, String birthdate) {

        //DRIVER ID VALIDATION CHECK - D1
        for (Driver currentDriver : drivers) {
            if (id.equals(currentDriver.getDriverId())) {
                throw new IllegalArgumentException("Driver already exists");
            }
        }

        if (id.length() != 10) {
            throw new IllegalArgumentException("Driver id length should be 10");
        }

        if (!Character.isDigit(id.charAt(0)) || !Character.isDigit(id.charAt(1))) {
            throw new IllegalArgumentException("Driver id should start with two digits");
        }

        if (Character.getNumericValue(id.charAt(0)) < 2 || Character.getNumericValue(id.charAt(0)) > 9 
            || Character.getNumericValue(id.charAt(1)) < 2 || Character.getNumericValue(id.charAt(1)) > 9) {
            throw new IllegalArgumentException("Driver id should start with two digits between 2 and 9");
        }

        int specialCharacterCount = 0;

        for (int i = 2; i < 8; i++) {
            if (!Character.isLetterOrDigit(id.charAt(i))) {
                specialCharacterCount++;
            }
        }

        if (specialCharacterCount < 2) {
            throw new IllegalArgumentException("Driver id must have two special characters between digit 3 and 8");
        }

        if (!Character.isUpperCase(id.charAt(8)) || !Character.isUpperCase(id.charAt(9))) {
            throw new IllegalArgumentException("Driver id should end with two capital letters");
        }

        //D2
        if (address.split("\\|").length != 5) {
            throw new IllegalArgumentException("Driver address should contain 5 separate fields");
        }

        //D3
        if (!birthdate.matches("^\\d{2}-\\d{2}-\\d{4}$")) {
            throw new IllegalArgumentException("Driver birthdate should be formatted DD-MM-YYYY");
        }

        Driver newDriver = new Driver(id, name, experienceYears, licenseType, address, birthdate);
        drivers.add(newDriver);
    }

    public void Update(String id, String name, String licenseType, String address, String birthdate) {
        for (Driver currentDriver : drivers) {
            if (id.equals(currentDriver.getDriverId())) {

                //D4 - not updatable license type if experience greater than 10 years
                if (currentDriver.getExperienceYears() > 10) {
                    licenseType = currentDriver.getLicenseType();
                }
                currentDriver.setLicenseType(licenseType);

                //D5 - name cannot be changed
                currentDriver.setName(currentDriver.getName());



                //D2 - 5 address format
                if (address.split("\\|").length != 5) {
                    throw new IllegalArgumentException("Driver address should contain 5 separate fields");
                }
                currentDriver.setAddress(address);


                //D3 - birthdate format checking
                if (!birthdate.matches("^\\d{2}-\\d{2}-\\d{4}$")) {
                    throw new IllegalArgumentException("Driver birthdate should be formatted DD-MM-YYYY");
                }
                currentDriver.setBirthdate(birthdate);

            } else {
                throw new IllegalArgumentException("Driver doesn't exist.");
            }
        }
    }

    public int getDriverCount() {
        return drivers.size();
    }

    public Driver getDriverById(String driverId) {
        for (Driver currentDriver : drivers) {
            if (driverId.equals(currentDriver.getDriverId())) {
                return currentDriver;
            }
        }

        return null;
    }

    public void saveToFile(String fileName) {

        try (FileWriter writer = new FileWriter(fileName)) {

            for (Driver currentDriver : drivers) {
                writer.write(currentDriver.getDriverId() + "," + currentDriver.getName() + "," + currentDriver.getExperienceYears() + "," + currentDriver.getLicenseType() +  "," + currentDriver.getAddress() + "," + currentDriver.getBirthdate() + "\n");
            }
            System.out.println("Successfully wrote to " + fileName + ".");

        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }

}
