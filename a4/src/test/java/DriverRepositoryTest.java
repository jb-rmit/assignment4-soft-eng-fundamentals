import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class DriverRepositoryTest {
    
    @Test
    void driverIDUniqueCheck(){
        var dr = new DriverRepository();
        String id = "33$$1111AA";
        String name = "John Doe";
        int experienceYears = 1;
        String licenseType = "Light";
        String address = "1|Sesame St.|Melbourne|Victoria|Australia";
        String birthdate = "01-01-2000";

        dr.Add(id, name, experienceYears, licenseType, address, birthdate);

        assertThrows(IllegalArgumentException.class, 
            () -> {
                dr.Add(id, name, experienceYears, licenseType, address, birthdate);
            });
    }

    @Test
    void DriverIDLength11Fails(){
        var dr = new DriverRepository();
        String id = "33$$11111AA";
        String name = "John Doe";
        int experienceYears = 1;
        String licenseType = "Light";
        String address = "1|Sesame St.|Melbourne|Victoria|Australia";
        String birthdate = "01-01-2000";

        assertThrows(IllegalArgumentException.class, 
            () -> {
                dr.Add(id, name, experienceYears, licenseType, address, birthdate);
            });

    }

    @Test
    void DriverIDLength9Fails(){
        var dr = new DriverRepository();
        String id = "33$$111AA";
        String name = "John Doe";
        int experienceYears = 1;
        String licenseType = "Light";
        String address = "1|Sesame St.|Melbourne|Victoria|Australia";
        String birthdate = "01-01-2000";

        assertThrows(IllegalArgumentException.class, 
            () -> {
                dr.Add(id, name, experienceYears, licenseType, address, birthdate);
            });

    }

}
