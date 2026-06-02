

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

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
        LocalDate birthday = LocalDate.parse(birthdate, dtf);

        long duration = ChronoUnit.DAYS.between(birthday, LocalDate.now());
        double age = duration/ 365.2425; //365 days in a year (accounting for Leap years)
        return age;
    }

    public String getDriverId() {
        return driverId;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public String getLicenseType() {
        return licenseType;
    }

}
