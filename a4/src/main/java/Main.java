import java.io.File;                  // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner;             // Import the Scanner class to read text files


public class Main {
    static void main() {

            File database = new File("bus_database.txt");


            //code adapted from w3schools: https://www.w3schools.com/java/java_files_read.asp
            // try-with-resources: Scanner will be closed automatically
            try (Scanner myReader = new Scanner(database)) {
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    System.out.println(data);
                }
            } catch (FileNotFoundException e) {
                System.out.println("File bus_database.txt not found.");
            }

        }
    }
