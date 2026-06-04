import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class BusRepositoryTest {

    @Test
    public void BusIDNotUniqueFail(){
        BusRepository br = new BusRepository();
        String id = "12345678";
        int capacity = 60;
        double fuelLevel = 27.8;
        String fuelType = "Diesel";
        Driver driver = new Driver("33$$1111AA", "John Doe", 1, "Light", 
                            "1|Sesame St.|Melbourne|Victoria|Australia", "01-01-2000");

        br.Add(id, capacity, fuelLevel, fuelType, driver);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, 
            () -> {
                br.Add(id, capacity, fuelLevel, fuelType, driver);
            });

        System.out.println(exception);
    }

    @Test
    public void BusIDUniquePass(){
        BusRepository br = new BusRepository();
        String id = "12345678";
        int capacity = 60;
        double fuelLevel = 27.8;
        String fuelType = "Diesel";
        Driver driver = new Driver("33$$1111AA", "John Doe", 1, "Light", 
                            "1|Sesame St.|Melbourne|Victoria|Australia", "01-01-2000");

        br.Add(id, capacity, fuelLevel, fuelType, driver);

        String new_id = "87654321";
        assertDoesNotThrow(() -> {br.Add(new_id, capacity, fuelLevel, fuelType, driver);});
    }


    @Test
    public void BusIDLongerThanEightFail(){
        BusRepository br = new BusRepository();
        String id = "123456789";
        int capacity = 60;
        double fuelLevel = 27.8;
        String fuelType = "Diesel";
        Driver driver = new Driver("33$$1111AA", "John Doe", 1, "Light", 
                            "1|Sesame St.|Melbourne|Victoria|Australia", "01-01-2000");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, 
            () -> {
                br.Add(id, capacity, fuelLevel, fuelType, driver);
            });
        
        System.out.println(exception);
    }

    @Test
    public void BusIDShorterThanEightFail(){
        BusRepository br = new BusRepository();
        String id = "1234567";
        int capacity = 60;
        double fuelLevel = 27.8;
        String fuelType = "Diesel";
        Driver driver = new Driver("33$$1111AA", "John Doe", 1, "Light", 
                            "1|Sesame St.|Melbourne|Victoria|Australia", "01-01-2000");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, 
            () -> {
                br.Add(id, capacity, fuelLevel, fuelType, driver);
            });

        System.out.println(exception);
    }

    @Test
    public void BusIDContainsNonDigitFail(){
        BusRepository br = new BusRepository();
        String id = "1234A678";
        int capacity = 60;
        double fuelLevel = 27.8;
        String fuelType = "Diesel";
        Driver driver = new Driver("33$$1111AA", "John Doe", 1, "Light", 
                            "1|Sesame St.|Melbourne|Victoria|Australia", "01-01-2000");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, 
            () -> {
                br.Add(id, capacity, fuelLevel, fuelType, driver);
            });

        System.out.println(exception);
    }

    @Test
    public void BusCapicityCannotIncrease(){
        BusRepository br = new BusRepository();
        String id = "12345678";
        int capacity = 60;
        double fuelLevel = 27.8;
        String fuelType = "Diesel";
        Driver driver = new Driver("33$$1111AA", "John Doe", 1, "Light", 
                            "1|Sesame St.|Melbourne|Victoria|Australia", "01-01-2000");

        br.Add(id, capacity, fuelLevel, fuelType, driver);

        int new_capacity = 70;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, 
            () -> {
                br.Update(id, new_capacity, fuelLevel, fuelType, driver);
            });

        System.out.println(exception);
    }

    @Test
    public void BusCapicityCanDecrease(){
        BusRepository br = new BusRepository();
        String id = "12345678";
        int capacity = 60;
        double fuelLevel = 27.8;
        String fuelType = "Diesel";
        Driver driver = new Driver("33$$1111AA", "John Doe", 1, "Light", 
                            "1|Sesame St.|Melbourne|Victoria|Australia", "01-01-2000");

        br.Add(id, capacity, fuelLevel, fuelType, driver);

        int new_capacity = 20;

        br.Update(id, new_capacity, fuelLevel, fuelType, driver);

        int busCapacity = br.getBusById(id).getCapacity();

        assertEquals(new_capacity, busCapacity);
    }

    @Test
    public void DriverOlderThan50CanDriveBusUnder50(){
        BusRepository br = new BusRepository();
        String id = "12345678";
        int capacity = 40;
        double fuelLevel = 27.8;
        String fuelType = "Diesel";
        Driver driver = new Driver("33$$1111AA", "John Doe", 1, "Light", 
                            "1|Sesame St.|Melbourne|Victoria|Australia", "01-01-1976");


        assertDoesNotThrow(() -> {br.Add(id, capacity, fuelLevel, fuelType, driver);});
    }

    @Test
    public void DriverOlderThan50CannotDriveBusOver50(){
        BusRepository br = new BusRepository();
        String id = "12345678";
        int capacity = 60;
        double fuelLevel = 27.8;
        String fuelType = "Diesel";
        Driver driver = new Driver("33$$1111AA", "John Doe", 1, "Light", 
                            "1|Sesame St.|Melbourne|Victoria|Australia", "01-01-1976");


        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, 
            () -> {
                br.Add(id, capacity, fuelLevel, fuelType, driver);
            });

        System.out.println(exception);
    }

    @Test
    public void DriverOverFiveYearsCanDriveElectric(){
        BusRepository br = new BusRepository();
        String id = "12345678";
        int capacity = 60;
        double fuelLevel = 27.8;
        String fuelType = "Electricity";
        Driver driver = new Driver("33$$1111AA", "John Doe", 6, "Heavy", 
                            "1|Sesame St.|Melbourne|Victoria|Australia", "01-01-2000");


        assertDoesNotThrow(() -> {br.Add(id, capacity, fuelLevel, fuelType, driver);});
    }

    @Test
    public void DriverAtFiveYearsCanDriveElectric(){
        BusRepository br = new BusRepository();
        String id = "12345678";
        int capacity = 60;
        double fuelLevel = 27.8;
        String fuelType = "Electricity";
        Driver driver = new Driver("33$$1111AA", "John Doe", 5, "Heavy", 
                            "1|Sesame St.|Melbourne|Victoria|Australia", "01-01-2000");


        assertDoesNotThrow(() -> {br.Add(id, capacity, fuelLevel, fuelType, driver);});
    }

    @Test
    public void DriverUnderFiveYearsCannotDriveElectric(){
        BusRepository br = new BusRepository();
        String id = "12345678";
        int capacity = 60;
        double fuelLevel = 27.8;
        String fuelType = "Electricity";
        Driver driver = new Driver("33$$1111AA", "John Doe", 4, "Heavy", 
                            "1|Sesame St.|Melbourne|Victoria|Australia", "01-01-2000");


        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, 
            () -> {
                br.Add(id, capacity, fuelLevel, fuelType, driver);
            });

        System.out.println(exception);
    }

    @Test
    public void DriverLightCannotDriveHybrid(){
        BusRepository br = new BusRepository();
        String id = "12345678";
        int capacity = 60;
        double fuelLevel = 27.8;
        String fuelType = "Hybrid";
        Driver driver = new Driver("33$$1111AA", "John Doe", 5, "Light", 
                            "1|Sesame St.|Melbourne|Victoria|Australia", "01-01-2000");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, 
            () -> {
                br.Add(id, capacity, fuelLevel, fuelType, driver);
            });

        System.out.println(exception);
    }

    @Test
    public void DriverLightCannotDriveElectricity(){
        BusRepository br = new BusRepository();
        String id = "12345678";
        int capacity = 60;
        double fuelLevel = 27.8;
        String fuelType = "Electricity";
        Driver driver = new Driver("33$$1111AA", "John Doe", 5, "Light", 
                            "1|Sesame St.|Melbourne|Victoria|Australia", "01-01-2000");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, 
            () -> {
                br.Add(id, capacity, fuelLevel, fuelType, driver);
            });

        System.out.println(exception);
    }

    
    @Test
    public void DriverMediumCannotDriveHybrid(){
        BusRepository br = new BusRepository();
        String id = "12345678";
        int capacity = 60;
        double fuelLevel = 27.8;
        String fuelType = "Hybrid";
        Driver driver = new Driver("33$$1111AA", "John Doe", 5, "Medium", 
                            "1|Sesame St.|Melbourne|Victoria|Australia", "01-01-2000");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, 
            () -> {
                br.Add(id, capacity, fuelLevel, fuelType, driver);
            });

        System.out.println(exception);
    }

    @Test
    public void DriverMediumCannotDriveElectricity(){
        BusRepository br = new BusRepository();
        String id = "12345678";
        int capacity = 60;
        double fuelLevel = 27.8;
        String fuelType = "Electricity";
        Driver driver = new Driver("33$$1111AA", "John Doe", 5, "Medium", 
                            "1|Sesame St.|Melbourne|Victoria|Australia", "01-01-2000");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, 
            () -> {
                br.Add(id, capacity, fuelLevel, fuelType, driver);
            });

        System.out.println(exception);
    }


}
