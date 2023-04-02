package foodtruckfrenzy.Drawable.Vehicle;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import foodtruckfrenzy.GameFramework.Grid;


public class CopTest {
    Grid grid;
    FoodTruck player;
    Cop cop;

    @BeforeEach                                         
    void setUp() {
        grid = new Grid();
        player = new FoodTruck(0, 0, grid);
        cop = new Cop(11, 8, grid, player);
    }

    @Test 
    void testMoveUp() {
        int initialRowPos = cop.getRow();
        assertTrue(cop.moveUp());
        assertEquals(initialRowPos - 1 , cop.getRow());

        Cop tempCop = new Cop(1, 1, grid, player);
        initialRowPos = tempCop.getRow();
        assertFalse(tempCop.moveUp());
        assertEquals(initialRowPos, tempCop.getRow());
    }
    @Test 
    void testMoveDown() {
        int initialRowPos = cop.getRow();
        assertTrue(cop.moveDown());
        assertEquals(initialRowPos + 1 , cop.getRow());

        Cop tempCop = new Cop(1, 1, grid, player);
        initialRowPos = tempCop.getRow();
        assertFalse(tempCop.moveUp());
        assertEquals(initialRowPos, tempCop.getRow());
    }
    @Test 
    void testMoveLeft() {
        int initialColPos = cop.getCol();
        assertTrue(cop.moveLeft());
        assertEquals(initialColPos - 1 , cop.getCol());
    }
    @Test 
    void testMoveRight() {
        int initialColPos = cop.getCol();
        assertTrue(cop.moveRight());
        assertEquals(initialColPos + 1 , cop.getCol());
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
