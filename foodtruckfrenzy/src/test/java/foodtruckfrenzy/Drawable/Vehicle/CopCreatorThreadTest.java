package foodtruckfrenzy.Drawable.Vehicle;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import foodtruckfrenzy.GameFramework.Grid;

public class CopCreatorThreadTest {
    Grid grid;
    FoodTruck player;
    CopCreatorThread copCreatorThread;

    @BeforeEach                                         
    void setup() {
        grid = new Grid();
        player = new FoodTruck(0, 0, grid);
        copCreatorThread = new CopCreatorThread(11, 8, grid, player);
    }

    @Test
    void testGetCop() {
        assertTrue(copCreatorThread.getCop() instanceof Cop);
    }
}
