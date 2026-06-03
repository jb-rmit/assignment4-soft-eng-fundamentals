import java.io.File;                  // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner;             // Import the Scanner class to read text files


public class Main {
    static void main() {

            //Find database .txt files
            File driverDatabase = new File("database_files/driver_database.txt");

            //Setup repositories
            DriverRepository driverRepository = new DriverRepository();


            //Add driver database
            //code adapted from w3schools: https://www.w3schools.com/java/java_files_read.asp
            // try-with-resources: Scanner will be closed automatically
            try (Scanner myReader = new Scanner(driverDatabase)) {

                int lineNumber = 0;

                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    String[] driverFields = data.split(",");

                    if (driverFields.length != 6) {
                        System.out.println("Invalid data format at line " + lineNumber + ". Skipping.");
                        continue;
                    }

                    driverRepository.Add(driverFields[0], driverFields[1], Integer.parseInt(driverFields[2]), driverFields[3], driverFields[4], driverFields[5]);
                }
            } catch (FileNotFoundException e) {
                System.out.println("File driver_database.txt not found.");
            }

            System.out.println("Driver Count: " + driverRepository.getDriverCount());

        }
    }
