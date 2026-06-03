import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class BusRepositoryTest {

    @Test
    public void BusIDNotUniqueFail(){
        BusRepository br = new BusRepository();
        String id = "12345678";
        int capacity = 30;
        double fuelLevel = 27.8;
        String fuelType = "Diesel";
        Driver driver = new Driver("33$$1111AA", "John Doe", 1, "Light", 
                            "1|Sesame St.|Melbourne|Victoria|Australia", "01-01-2000");

        br.Add(id, capacity, fuelLevel, fuelType, driver);

        assertThrows(IllegalArgumentException.class, 
            () -> {
                br.Add(id, capacity, fuelLevel, fuelType, driver);
            });
    }

}
