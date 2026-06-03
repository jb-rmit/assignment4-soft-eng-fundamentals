import java.io.File;                  // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner;             // Import the Scanner class to read text files


public class Main {
    static void main() {

            //Setup repositories
            DriverRepository driverRepository = new DriverRepository();

            //Add driver database
            driverRepository.readDatabaseTextFile("database_files/driver_database.txt");


            System.out.println("Driver Count: " + driverRepository.getDriverCount());

        }
    }
