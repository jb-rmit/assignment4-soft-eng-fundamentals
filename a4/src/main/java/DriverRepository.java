

import java.util.ArrayList;
import java.util.List;

public class DriverRepository {
    private List<Driver> drivers = new ArrayList<>();

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

                //D5
                currentDriver.setName(currentDriver.getName());

                //TODO: UPDATE CODE
                currentDriver.setLicenseType(licenseType);
                currentDriver.setAddress(address);
                currentDriver.setBirthdate(birthdate);

            } else {
                throw new IllegalArgumentException("Driver doesn't exist.");
            }
        }
    }

}
