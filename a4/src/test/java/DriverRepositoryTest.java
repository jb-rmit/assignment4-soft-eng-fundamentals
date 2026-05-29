import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class DriverRepositoryTest {
    
    @Test
    void driverIDNotUniqueFail(){
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

    @Test
    void DriverIDFirstCharacterLessThan2Fails(){
        var dr = new DriverRepository();
        String id = "13$$1111AA";
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
    void DriverIDSecondCharacterLessThan2Fails(){
        var dr = new DriverRepository();
        String id = "31$$1111AA";
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
    void DriverIDFirstTwoCharactersEqualTwoPass(){
        var dr = new DriverRepository();
        String id = "33$$1111AA";
        String name = "John Doe";
        int experienceYears = 1;
        String licenseType = "Light";
        String address = "1|Sesame St.|Melbourne|Victoria|Australia";
        String birthdate = "01-01-2000";

        assertDoesNotThrow(() -> {
        dr.Add(id, name, experienceYears, licenseType, address, birthdate);
        });

    }

    @Test
    void DriverIDFirstTwoCharactersEqualNinePass(){
        var dr = new DriverRepository();
        String id = "99$$1111AA";
        String name = "John Doe";
        int experienceYears = 1;
        String licenseType = "Light";
        String address = "1|Sesame St.|Melbourne|Victoria|Australia";
        String birthdate = "01-01-2000";

        assertDoesNotThrow(() -> {
        dr.Add(id, name, experienceYears, licenseType, address, birthdate);
        });

    }

    @Test
    void DriverIDNoSpecialCharactersFail(){
        var dr = new DriverRepository();
        String id = "33111111AA";
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
