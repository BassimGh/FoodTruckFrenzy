package foodtruckfrenzy.Drawable.Vehicle;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import foodtruckfrenzy.GameFramework.Grid;
import foodtruckfrenzy.Helper.BoardElementFactory;
import foodtruckfrenzy.Helper.MapLayout;

public class CopCreatorThreadTest {
    private Grid grid;
    private FoodTruck player;
    private CopCreatorThread copCreatorThread;

    @BeforeEach                                         
    void setup() {
        grid = new Grid(new BoardElementFactory(), new MapLayout());
        player = new FoodTruck(0, 0, grid);
        copCreatorThread = new CopCreatorThread(11, 8, grid, player);
    }

    @Test
    void testGetCop() {
        assertTrue(copCreatorThread.getCop() instanceof Cop);
    }
}
