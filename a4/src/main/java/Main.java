import java.io.File;                  // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner;             // Import the Scanner class to read text files


public class Main {
    static void main() {

            //Setup repositories
            DriverRepository driverRepository = new DriverRepository();
            BusRepository busRepository = new BusRepository();

            //Add driver database
            driverRepository.readDatabaseTextFile("database_files/driver_database.txt");

            //Tell bus repository where the driver repository is
            busRepository.setDriverRepository(driverRepository);

            //Add bus database
            busRepository.readDatabaseTextFile("database_files/bus_database.txt");

            System.out.println("Driver Count: " + driverRepository.getDriverCount());
            System.out.println("Bus Count: " + busRepository.Count());

            driverRepository.saveToFile("database_files/driver_database_copy.txt");
            busRepository.saveToFile("database_files/bus_database_copy.txt");

        }
    }
