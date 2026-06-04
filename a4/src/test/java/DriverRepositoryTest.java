import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
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

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, 
            () -> {
                dr.Add(id, name, experienceYears, licenseType, address, birthdate);
            });

        System.out.println(exception);
    }

    @Test
    void driverIDUniquePass(){
        var dr = new DriverRepository();
        String id = "33$$1111AA";
        String name = "John Doe";
        int experienceYears = 1;
        String licenseType = "Light";
        String address = "1|Sesame St.|Melbourne|Victoria|Australia";
        String birthdate = "01-01-2000";

        dr.Add(id, name, experienceYears, licenseType, address, birthdate);

        String new_id = "23$$1111AA";

        assertDoesNotThrow(() -> {dr.Add(new_id, name, experienceYears, licenseType, address, birthdate);});
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

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, 
            () -> {
                dr.Add(id, name, experienceYears, licenseType, address, birthdate);
            });
        
        System.out.println(exception);
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

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, 
            () -> {
                dr.Add(id, name, experienceYears, licenseType, address, birthdate);
            });
        
        System.out.println(exception);
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

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, 
            () -> {
                dr.Add(id, name, experienceYears, licenseType, address, birthdate);
            });
        
        System.out.println(exception);

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

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, 
            () -> {
                dr.Add(id, name, experienceYears, licenseType, address, birthdate);
            });
        
        System.out.println(exception);
    }
    

    @Test
    void DriverIDFirstTwoCharactersEqualTwoPass(){
        var dr = new DriverRepository();
        String id = "22$$1111AA";
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

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, 
            () -> {
                dr.Add(id, name, experienceYears, licenseType, address, birthdate);
            });

        System.out.println(exception);
    }
    
    @Test
    void DriverIDOneSpecialCharacterFail(){
        var dr = new DriverRepository();
        String id = "33$11111AA";
        String name = "John Doe";
        int experienceYears = 1;
        String licenseType = "Light";
        String address = "1|Sesame St.|Melbourne|Victoria|Australia";
        String birthdate = "01-01-2000";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, 
            () -> {
                dr.Add(id, name, experienceYears, licenseType, address, birthdate);
            });

        System.out.println(exception);
    }

    @Test
    void DriverIDTwoSpecialCharactersPass(){
        var dr = new DriverRepository();
        String id = "33$1111%AA";
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
    void DriverIDMoreThanTwoSpecialCharactersPass(){
        var dr = new DriverRepository();
        String id = "33$#^11%AA";
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
    void DriverIDEndsWithTwoDigitsFail() {
        var dr = new DriverRepository();
        String id = "33$$111111";
        String name = "John Doe";
        int experienceYears = 1;
        String licenseType = "Light";
        String address = "1|Sesame St.|Melbourne|Victoria|Australia";
        String birthdate = "01-01-2000";

       IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, 
            () -> {
                dr.Add(id, name, experienceYears, licenseType, address, birthdate);
            });

        System.out.println(exception);

    }

    @Test
    void DriverIDEndsWithTwoLowercaseFail() {
        var dr = new DriverRepository();
        String id = "33$$1111aa";
        String name = "John Doe";
        int experienceYears = 1;
        String licenseType = "Light";
        String address = "1|Sesame St.|Melbourne|Victoria|Australia";
        String birthdate = "01-01-2000";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, 
            () -> {
                dr.Add(id, name, experienceYears, licenseType, address, birthdate);
            });

        System.out.println(exception);
    }

    @Test
    void DriverIDEndsWithOneUpperOneLowerFail() {
        var dr = new DriverRepository();
        String id = "33$$1111Aa";
        String name = "John Doe";
        int experienceYears = 1;
        String licenseType = "Light";
        String address = "1|Sesame St.|Melbourne|Victoria|Australia";
        String birthdate = "01-01-2000";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, 
            () -> {
                dr.Add(id, name, experienceYears, licenseType, address, birthdate);
            });

        System.out.println(exception);

    }


    @Test
    void DriverAddress6FieldsFail() {
        var dr = new DriverRepository();
        String id = "33$$1111AA";
        String name = "John Doe";
        int experienceYears = 1;
        String licenseType = "Light";
        String address = "1|Sesame St.|Melbourne|3000|Victoria|Australia";
        String birthdate = "01-01-2000";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, 
            () -> {
                dr.Add(id, name, experienceYears, licenseType, address, birthdate);
            });

        System.out.println(exception);
    }

    @Test
    void DriverAddress4FieldsFail() {
        var dr = new DriverRepository();
        String id = "33$$1111AA";
        String name = "John Doe";
        int experienceYears = 1;
        String licenseType = "Light";
        String address = "1|Sesame St.|Melbourne|Victoria";
        String birthdate = "01-01-2000";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, 
            () -> {
                dr.Add(id, name, experienceYears, licenseType, address, birthdate);
            });

        System.out.println(exception);
    }

    @Test
    void DriverBirthdayWrongFormatFail(){
        var dr = new DriverRepository();
        String id = "33$$1111AA";
        String name = "John Doe";
        int experienceYears = 1;
        String licenseType = "Light";
        String address = "1|Sesame St.|Melbourne|Victoria|Australia";
        String birthdate = "01/01/2000";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, 
            () -> {
                dr.Add(id, name, experienceYears, licenseType, address, birthdate);
            });

        System.out.println(exception);
    }

    @Test
    void DriverUpdateCannotChangeName(){
        var dr = new DriverRepository();
        String id = "33$$1111AA";
        String name = "John Doe";
        int experienceYears = 1;
        String licenseType = "Light";
        String address = "1|Sesame St.|Melbourne|Victoria|Australia";
        String birthdate = "01-01-2000";

        dr.Add(id, name, experienceYears, licenseType, address, birthdate);

        String new_name = "Jane Doe";

        dr.Update(id, new_name, licenseType, address, birthdate);

        String driverName = dr.getDriverById(id).getName();
        assertEquals(name, driverName);
    }


    @Test
    void DriverUpdateCannotChangeLicenceIfExperienceMoreThanTen(){
        var dr = new DriverRepository();
        String id = "33$$1111AA";
        String name = "John Doe";
        int experienceYears = 20;
        String licenseType = "Light";
        String address = "1|Sesame St.|Melbourne|Victoria|Australia";
        String birthdate = "01-01-2000";

        dr.Add(id, name, experienceYears, licenseType, address, birthdate);

        String new_license = "Medium";

        dr.Update(id, name, new_license, address, birthdate);

        String driverLicense = dr.getDriverById(id).getLicenseType();
        assertEquals(licenseType, driverLicense);
    }

    @Test
    void DriverUpdateCanChangeLicenceIfExperienceTen(){
        var dr = new DriverRepository();
        String id = "33$$1111AA";
        String name = "John Doe";
        int experienceYears = 10;
        String licenseType = "Light";
        String address = "1|Sesame St.|Melbourne|Victoria|Australia";
        String birthdate = "01-01-2000";

        dr.Add(id, name, experienceYears, licenseType, address, birthdate);

        String new_license = "Medium";

        dr.Update(id, name, new_license, address, birthdate);

        String driverLicense = dr.getDriverById(id).getLicenseType();
        assertEquals(new_license, driverLicense);
    }

    @Test
    void DriverUpdateCanChangeLicenceIfExperienceLessThanTen(){
        var dr = new DriverRepository();
        String id = "33$$1111AA";
        String name = "John Doe";
        int experienceYears = 9;
        String licenseType = "Light";
        String address = "1|Sesame St.|Melbourne|Victoria|Australia";
        String birthdate = "01-01-2000";

        dr.Add(id, name, experienceYears, licenseType, address, birthdate);

        String new_license = "Medium";

        dr.Update(id, name, new_license, address, birthdate);

        String driverLicense = dr.getDriverById(id).getLicenseType();
        assertEquals(new_license, driverLicense);
    }
   
}
