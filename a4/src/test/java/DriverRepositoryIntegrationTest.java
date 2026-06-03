import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DriverRepositoryIntegrationTest {

    @Test
    public void ValidDriver(){

        //Setup repositories
        DriverRepository driverRepository = new DriverRepository();

        //Add driver database, 2 valid drivers in file
        driverRepository.readDatabaseTextFile("src/test/testfiles/driver_database_valid.txt");

        //There should be 2 drivers in repository
        assertEquals(2, driverRepository.getDriverCount());
    }

    @Test
    public void InvalidDriverIsSkipped(){
        //Setup repositories
        DriverRepository driverRepository = new DriverRepository();


        //Add driver database, 1 valid and 1 invalid driver in file
        driverRepository.readDatabaseTextFile("src/test/testfiles/driver_database_invalid.txt");

        //There should be 1 driver in repository
        assertEquals(1, driverRepository.getDriverCount());
    }

    @Test
    public void DriverIsUpdated() {
        //Setup repositories
        DriverRepository driverRepository = new DriverRepository();

        //Add driver database, 2 valid drivers.
        driverRepository.readDatabaseTextFile("src/test/testfiles/driver_database_toUpdate.txt");

        //Change Jane's licenseType from "Light" to "Heavy"
        driverRepository.Update("7511!*11DE", "Jane Doe", "Heavy", "11|Queen St|Melbourne|Victoria|Australia", "23-10-1965");

        //Save changes to file
        driverRepository.saveToFile("src/test/testfiles/driver_database_updated.txt");

        //
        DriverRepository driverRepositoryUpdated = new DriverRepository();

        driverRepositoryUpdated.readDatabaseTextFile("src/test/testfiles/driver_database_updated.txt");

        assertEquals("Heavy", driverRepositoryUpdated.getDriverById("7511!*11DE").getLicenseType());
    }

    @Test
    public void DriverRecordCountIsUpdated() {
        //Setup repositories
        DriverRepository driverRepository = new DriverRepository();

        //Add driver database, 2 valid drivers.
        driverRepository.readDatabaseTextFile("src/test/testfiles/driver_database_valid.txt");

        driverRepository.Add("3511!*11AB", "Darth Joe", 5, "Public Transport", "63|McCarthy Rd|Sydney|New South Wales|Australia", "03-06-2000");

        //Assert driver count is now 3
        assertEquals(3, driverRepository.getDriverCount());
    }
}
