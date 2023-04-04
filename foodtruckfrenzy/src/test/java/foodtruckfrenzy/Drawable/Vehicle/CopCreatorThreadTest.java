package foodtruckfrenzy.Drawable.Vehicle;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import foodtruckfrenzy.GameFramework.Grid;
import foodtruckfrenzy.GameFramework.Scoreboard;
import foodtruckfrenzy.Helper.BoardElementFactory;
import foodtruckfrenzy.Helper.MapLayout;

public class CopCreatorThreadTest {
    private Grid grid;
    private FoodTruck player;
    private CopCreatorThread copCreatorThread;
    private int row;
    private int col;

    @BeforeEach
    void setup() {
        this.grid = new Grid(new BoardElementFactory(), new MapLayout());
        this.row = 0;
        this.col = 0;
        player = new FoodTruck(row, col, grid, new Scoreboard(0,0));
        copCreatorThread = new CopCreatorThread(11, 8, grid, player);
    }

    @Test
    void testGetCop() {
        assertTrue(copCreatorThread.getCop() instanceof Cop);
    }
    void testGetRow() {
        assertEquals(row, copCreatorThread.getCop().getRow());
    }
    void testGetCol() {
        assertEquals(col, copCreatorThread.getCop().getCol());
    }
    void testGetGrid() {
        assertEquals(grid, copCreatorThread.getCop().getGrid());
    }
}
