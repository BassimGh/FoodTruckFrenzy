package foodtruckfrenzy.Helper;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.*;

import foodtruckfrenzy.Drawable.Vehicle.Cop;
import foodtruckfrenzy.Drawable.Vehicle.FoodTruck;
import foodtruckfrenzy.GameFramework.Grid;
import foodtruckfrenzy.GameFramework.Scoreboard;

public class VehicleSpawnerTest {
    private VehicleSpawner vehicleSpawner;
    private Grid grid;

    @BeforeEach
    void setup() {
        grid = new Grid(new BoardElementFactory(), new MapLayout());
        vehicleSpawner = new VehicleSpawner(grid, new Scoreboard(0,0));
    }

    @Test
    void testGetFoodTruck() {
        FoodTruck foodTruck = vehicleSpawner.getFoodTruck();
        assertTrue(foodTruck instanceof FoodTruck);
        assertNotNull(foodTruck);
    }
    @Test
    void testGetCops() {
        ArrayList<Cop> cops = vehicleSpawner.getCops();
        for(Cop cop : cops){
            assertTrue(cop instanceof Cop);
            assertNotNull(cop);
        }
    }
}