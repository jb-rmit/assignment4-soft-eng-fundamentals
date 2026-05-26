package org.a4;

import java.util.List;

public class DriverRepository {
    private List<Driver> drivers;

    public void Add(String id, String name, int experienceYears, String licenseType, String address, String birthdate) {

        //DRIVER ID VALIDATION CHECK
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
    }

}
