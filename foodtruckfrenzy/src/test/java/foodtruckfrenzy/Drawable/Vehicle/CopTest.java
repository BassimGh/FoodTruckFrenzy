package foodtruckfrenzy.Drawable.Vehicle;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import foodtruckfrenzy.Drawable.DrawableEnum;
import foodtruckfrenzy.GameFramework.Grid;
import foodtruckfrenzy.GameFramework.Scoreboard;
import foodtruckfrenzy.Helper.BoardElementFactory;
import foodtruckfrenzy.Helper.MapLayout;


public class CopTest {
    private Grid _grid;
    private FoodTruck _player;
    private Cop _cop;

    @BeforeEach                                         
    void setup() {
        _grid = new Grid(new BoardElementFactory(), new MapLayout());
        _player = new FoodTruck(0, 0, _grid, new Scoreboard(0,0));
        _cop = new Cop(11, 8, _grid, _player);
    }

    @Test 
    void testMoveUpSuccess() {
        int initialRowPos = _cop.getRow();
        assertTrue(_cop.moveUp());
        assertEquals(DrawableEnum.COP_UP, _cop.getDrawableType());
        assertEquals(initialRowPos - 1 , _cop.getRow());
    }
    @Test
    void testMoveUpFail() {
        Cop cop = new Cop(1, 1, _grid, new FoodTruck(0, 0, _grid, null));
        int initialRowPos = cop.getRow();
        assertFalse(cop.moveUp());
        assertEquals(initialRowPos, cop.getRow());
    }

    @Test 
    void testMoveDownSuccess() {
        int initialRowPos = _cop.getRow();
        assertTrue(_cop.moveDown());
        assertEquals(DrawableEnum.COP_DOWN, _cop.getDrawableType());
        assertEquals(initialRowPos + 1 , _cop.getRow());
    }
    @Test
    void testMoveDownFail() {
        Cop cop = new Cop(1, 2, _grid, new FoodTruck(0, 0, _grid, null));
        int initialRowPos = cop.getRow();
        assertFalse(cop.moveDown());
        assertEquals(initialRowPos, cop.getRow());
    }

    @Test 
    void testMoveLeftSuccess() {
        int initialColPos = _cop.getCol();
        assertTrue(_cop.moveLeft());
        assertEquals(DrawableEnum.COP_LEFT, _cop.getDrawableType());
        assertEquals(initialColPos - 1 , _cop.getCol());
    }
    @Test
    void testMoveLeftFail() {
        Cop cop = new Cop(2, 1, _grid, new FoodTruck(0, 0, _grid, null));
        int initialColPos = cop.getCol();
        assertFalse(cop.moveLeft());
        assertEquals(initialColPos, cop.getCol());
    }
    
    @Test 
    void testMoveRightSuccess() {
        int initialColPos = _cop.getCol();
        assertTrue(_cop.moveRight());
        assertEquals(DrawableEnum.COP_RIGHT, _cop.getDrawableType());
        assertEquals(initialColPos + 1 , _cop.getCol());
    }
    @Test
    void testMoveRightFail() {
        Cop cop = new Cop(2, 1, _grid, new FoodTruck(0, 0, _grid, null));
        int initialColPos = cop.getCol();
        assertFalse(cop.moveRight());
        assertEquals(initialColPos, cop.getCol());
    }
}
