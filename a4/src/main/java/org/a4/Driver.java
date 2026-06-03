package org.a4;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Driver {
    private String driverId;
    private String name;
    private int experienceYears;
    private String licenseType; //Light, Medium, Heavy, PublicTransport
    private String address;
    private String birthdate;

    Driver(String driverId, String name, int experienceYears, String licenseType, String address, String birthdate) {
        this.driverId = driverId;
        this.name = name;
        this.experienceYears = experienceYears;
        this.licenseType = licenseType;
        this.address = address;
        this.birthdate = birthdate;

    }

    public double getAge() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDateTime birthday = LocalDateTime.parse(birthdate, dtf);

        Duration duration = Duration.between(birthday, LocalDateTime.now());
        double age = duration.toHours() / 8760.0; //8760 hours in a year
        return age;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public String getLicenseType() {
        return licenseType;
    }

    public void setLicenseType(String licenseType) {
        this.licenseType = licenseType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }



}
