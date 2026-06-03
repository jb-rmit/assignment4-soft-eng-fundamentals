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
        driverRepository.readDatabaseTextFile("src/test/testfiles/driver_database_update.txt");


    }
}
