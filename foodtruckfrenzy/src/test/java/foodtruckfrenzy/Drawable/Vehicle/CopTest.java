package foodtruckfrenzy.Drawable.Vehicle;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import foodtruckfrenzy.Drawable.DrawableEnum;
import foodtruckfrenzy.GameFramework.Grid;
import foodtruckfrenzy.GameFramework.Scoreboard;
import foodtruckfrenzy.Helper.BoardElementFactory;
import foodtruckfrenzy.Helper.MapLayout;


public class CopTest {
    private Grid grid;
    private FoodTruck player;
    private Cop cop;

    @BeforeEach                                         
    void setup() {
        grid = new Grid(new BoardElementFactory(), new MapLayout());
        player = new FoodTruck(0, 0, grid, new Scoreboard(0,0));
        cop = new Cop(11, 8, grid, player);
    }

    @Test
    void testDefaultDirection() {
        assertEquals(DrawableEnum.COP_RIGHT, cop.getDrawableType());
    }

    @Test 
    void testMoveUp() {
        cop.moveUp();
        assertEquals(DrawableEnum.COP_UP, cop.getDrawableType());
    }
    @Test 
    void testMoveDown() {
        cop.moveDown();
        assertEquals(DrawableEnum.COP_DOWN, cop.getDrawableType());
    }
    @Test 
    void testMoveLeft() {
        cop.moveLeft();
        assertEquals(DrawableEnum.COP_LEFT, cop.getDrawableType());
    }
    @Test 
    void testMoveRight() {
        cop.moveRight();
        assertEquals(DrawableEnum.COP_RIGHT, cop.getDrawableType());
    }
    
    // @Test
    // void chaseTruck() {
    //     cop.
    // }
    
    // @Test
    // void initDirections() {
    //     cop.initDirections();
    // }
    
    // @Test
    // void addDirections() {
        
    // }


}
