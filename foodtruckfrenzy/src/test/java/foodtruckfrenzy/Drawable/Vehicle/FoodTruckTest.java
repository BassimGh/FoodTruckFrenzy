package foodtruckfrenzy.Drawable.Vehicle;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import foodtruckfrenzy.GameFramework.Grid;
import foodtruckfrenzy.GameFramework.Scoreboard;
import foodtruckfrenzy.Helper.BoardElementFactory;
import foodtruckfrenzy.Helper.MapLayout;


public class FoodTruckTest {
    
    private Grid grid;
    private Scoreboard scoreboard;
    private FoodTruck foodTruck;

    @BeforeEach                  
    void setup() {
        grid = new Grid(new BoardElementFactory(), new MapLayout());
        foodTruck = new FoodTruck(11, 8, grid, scoreboard);
    }

    @Test
    void testMoveUpSuccess() {
        int initialRowPos = foodTruck.getRow();
        assertTrue(foodTruck.moveUp());
        assertEquals(initialRowPos - 1 , foodTruck.getRow());
    }
    @Test 
    void testMoveUpFail() {
        FoodTruck tempFoodTruck = new FoodTruck(1, 1, grid, null);
        int initialRowPos = tempFoodTruck.getRow();
        assertFalse(tempFoodTruck.moveUp());
        assertEquals(initialRowPos, tempFoodTruck.getRow());
    }
    
    @Test 
    void testMoveDownSuccess() {
        int initialRowPos = foodTruck.getRow();
        assertTrue(foodTruck.moveDown());
        assertEquals(initialRowPos + 1 , foodTruck.getRow());
    }
    @Test
    void testMoveDownFail() {
        FoodTruck tempFoodTruck = new FoodTruck(1, 2, grid, null);
        int initialRowPos = tempFoodTruck.getRow();
        assertFalse(tempFoodTruck.moveDown());
        assertEquals(initialRowPos, tempFoodTruck.getRow());
    }

    @Test 
    void testMoveLeftSuccess() {
        int initialColPos = foodTruck.getCol();
        assertTrue(foodTruck.moveLeft());
        assertEquals(initialColPos - 1 , foodTruck.getCol());
    }
    @Test
    void testMoveLeftFail() {
        FoodTruck tempFoodTruck = new FoodTruck(2, 1, grid, null);
        int initialColPos = tempFoodTruck.getCol();
        assertFalse(tempFoodTruck.moveLeft());
        assertEquals(initialColPos, tempFoodTruck.getCol());
    }

    @Test 
    void testMoveRightSuccess() {
        int initialColPos = foodTruck.getCol();
        assertTrue(foodTruck.moveRight());
        assertEquals(initialColPos + 1 , foodTruck.getCol());
    }
    @Test
    void testMoveRightFail() {
        FoodTruck tempFoodTruck = new FoodTruck(2, 1, grid, null);
        int initialColPos = tempFoodTruck.getCol();
        assertFalse(tempFoodTruck.moveRight());
        assertEquals(initialColPos, tempFoodTruck.getCol());
    }

    @Test
    void testGetGrid() {
        assertEquals(grid, foodTruck.getGrid());
        assertEquals(null, new FoodTruck(0, 0, null, null).getGrid());
    }

    @Test
    public void testGetScoreboard() {
        assertEquals(scoreboard, foodTruck.getScoreboard());
    }

    @Test
    public void testAttach() {
        Cop cop = new Cop(0, 0, grid, foodTruck);
        foodTruck.attach(cop);
        assertTrue(foodTruck.getCops().contains(cop));
    }
}

