import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BusRepositoryIntegrationTest {

    @Test
    public void ValidBus(){

        //Setup repositories
        DriverRepository driverRepository = new DriverRepository();
        BusRepository busRepository = new BusRepository();
        driverRepository.readDatabaseTextFile("src/test/testfiles/driver_database_valid.txt");

        //Add driver repo to bus repo
        busRepository.setDriverRepository(driverRepository);

        //Add bus database, 2 valid buses in file
        busRepository.readDatabaseTextFile("src/test/testfiles/bus_database_valid.txt");

        assertEquals(2, busRepository.Count());


    }

    @Test
    public void InvalidBus(){

        //Setup repositories
        DriverRepository driverRepository = new DriverRepository();
        BusRepository busRepository = new BusRepository();
        driverRepository.readDatabaseTextFile("src/test/testfiles/driver_database_valid.txt");

        //Add driver repo to bus repo
        busRepository.setDriverRepository(driverRepository);

        //Add bus database, 1 valid and 1 invalid bus in file (license type of bus driver is not valid)
        busRepository.readDatabaseTextFile("src/test/testfiles/bus_database_invalid.txt");

        //Check if the valid bus was added, and the invalid bus was skipped.
        assertEquals(1, busRepository.Count());
    }

    @Test
    public void BusIsUpdated() {

        //Setup repositories
        DriverRepository driverRepository = new DriverRepository();
        BusRepository busRepository = new BusRepository();
        driverRepository.readDatabaseTextFile("src/test/testfiles/driver_database_valid.txt");

        //Add driver repo to bus repo
        busRepository.setDriverRepository(driverRepository);

        //Add bus database, 2 valid buses in file
        busRepository.readDatabaseTextFile("src/test/testfiles/bus_database_toUpdate.txt");

        //Change capacity of 2nd bus to 80
        busRepository.Update("11112222", 80, 30.0, "Diesel", driverRepository.getDriverById("7511!*11DE"));

        //Save changes to separate file
        busRepository.saveToFile("src/test/testfiles/bus_database_updated.txt");

        //Setup new repository
        BusRepository updatedBusRepository = new BusRepository();
        updatedBusRepository.setDriverRepository(driverRepository);

        updatedBusRepository.readDatabaseTextFile("src/test/testfiles/bus_database_updated.txt");

        assertEquals(80, updatedBusRepository.getBusById("11112222").getCapacity());
    }

    @Test
    public void BusRecordCountIsUpdated() {
        //Setup repositories
        DriverRepository driverRepository = new DriverRepository();
        BusRepository busRepository = new BusRepository();
        driverRepository.readDatabaseTextFile("src/test/testfiles/driver_database_valid.txt");

        //Add driver repo to bus repo
        busRepository.setDriverRepository(driverRepository);

        //Add bus database, 2 valid buses in file
        busRepository.readDatabaseTextFile("src/test/testfiles/bus_database_valid.txt");

        //Add new bus to database
        Driver driver = driverRepository.getDriverById("3411**11AA");
        busRepository.Add("11113333", 130, 20.0, "Hybrid", driver);

        //Bus count should be 3
        assertEquals(3, busRepository.Count());
    }
}
