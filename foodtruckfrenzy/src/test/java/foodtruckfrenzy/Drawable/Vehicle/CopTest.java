package foodtruckfrenzy.Drawable.Vehicle;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import foodtruckfrenzy.Drawable.DrawableEnum;
import foodtruckfrenzy.GameFramework.Grid;


public class CopTest {
    private Grid grid;
    private FoodTruck player;
    private Cop cop;

    @BeforeEach                                         
    void setup() {
        grid = new Grid();
        player = new FoodTruck(0, 0, grid);
        cop = new Cop(11, 8, grid, player);
    }

    @Test
    void testDefaultDirection() {
        assertEquals(DrawableEnum.COP_RIGHT, cop.getType());
    }

    @Test 
    void testMoveUp() {
        cop.moveUp();
        assertEquals(DrawableEnum.COP_UP, cop.getType());
    }
    @Test 
    void testMoveDown() {
        cop.moveDown();
        assertEquals(DrawableEnum.COP_DOWN, cop.getType());
    }
    @Test 
    void testMoveLeft() {
        cop.moveLeft();
        assertEquals(DrawableEnum.COP_LEFT, cop.getType());
    }
    @Test 
    void testMoveRight() {
        cop.moveRight();
        assertEquals(DrawableEnum.COP_RIGHT, cop.getType());
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
