package foodtruckfrenzy.Drawable.Vehicle;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import foodtruckfrenzy.GameFramework.Grid;
import foodtruckfrenzy.GameFramework.Scoreboard;
import foodtruckfrenzy.Helper.BoardElementFactory;
import foodtruckfrenzy.Helper.MapLayout;

public class CopCreatorThreadTest {
    private Grid _grid;
    private FoodTruck player;
    private CopCreatorThread copCreatorThread;
    private int _row;
    private int _col;

    @BeforeEach
    void setup() {
        this._grid = new Grid(new BoardElementFactory(), new MapLayout());
        this._row = 0;
        this._col = 0;
        player = new FoodTruck(_row, _col, _grid, new Scoreboard(0,0));
        copCreatorThread = new CopCreatorThread(11, 8, _grid, player);
    }

    @Test
    void testGetCop() {
        assertNotNull(copCreatorThread);
        assertTrue(copCreatorThread.getCop() instanceof Cop);
    }
    void testGetRow() {
        int row = copCreatorThread.getCop().getRow();
        assertNotNull(row);
        assertEquals(_row, row);
    }
    void testGetCol() {
        int col = copCreatorThread.getCop().getCol();
        assertNotNull(col);
        assertEquals(_col, col);
    }
    void testGetGrid() {
        Grid tempGrid = copCreatorThread.getCop().getGrid();
        assertNotNull(tempGrid);
        assertEquals(_grid, tempGrid);
    }
}
