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

    public double getAge() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDateTime birthday = LocalDateTime.parse(birthdate, dtf);

        Duration duration = Duration.between(birthday, LocalDateTime.now());
        double age = duration.toHours() / 8760.0; //8760 hours in a year
        return age;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public String getLicenseType() {
        return licenseType;
    }

}
