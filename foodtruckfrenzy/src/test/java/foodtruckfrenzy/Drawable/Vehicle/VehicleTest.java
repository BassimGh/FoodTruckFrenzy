package foodtruckfrenzy.Drawable.Vehicle;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import foodtruckfrenzy.GameFramework.Grid;

public class VehicleTest {
    Grid grid;
    FoodTruck player;
    Vehicle vehicle;

    @BeforeEach                  
    void setup() {
        grid = new Grid();
        player = new FoodTruck(0, 0, grid);
        vehicle = new Vehicle(11, 8, grid, null);
    }

    @Test
    void testMoveUpSuccess() {
        int initialRowPos = vehicle.getRow();
        assertTrue(vehicle.moveUp());
        assertEquals(initialRowPos - 1 , vehicle.getRow());
    }
    @Test 
    void testMoveUpFail() {
        Vehicle tempVehicle = new Vehicle(1, 1, grid, null);
        int initialRowPos = tempVehicle.getRow();
        assertFalse(tempVehicle.moveUp());
        assertEquals(initialRowPos, tempVehicle.getRow());
    }
    
    @Test 
    void testMoveDownSuccess() {
        int initialRowPos = vehicle.getRow();
        assertTrue(vehicle.moveDown());
        assertEquals(initialRowPos + 1 , vehicle.getRow());
    }
    @Test
    void testMoveDownFail() {
        Vehicle tempVehicle = new Vehicle(1, 2, grid, null);
        int initialRowPos = tempVehicle.getRow();
        assertFalse(tempVehicle.moveDown());
        assertEquals(initialRowPos, tempVehicle.getRow());
    }

    @Test 
    void testMoveLeftSuccess() {
        int initialColPos = vehicle.getCol();
        assertTrue(vehicle.moveLeft());
        assertEquals(initialColPos - 1 , vehicle.getCol());
    }
    @Test
    void testMoveLeftFail() {
        Vehicle tempVehicle = new Vehicle(2, 1, grid, null);
        int initialColPos = tempVehicle.getCol();
        assertFalse(tempVehicle.moveLeft());
        assertEquals(initialColPos, tempVehicle.getCol());
    }

    @Test 
    void testMoveRightSuccess() {
        int initialColPos = vehicle.getCol();
        assertTrue(vehicle.moveRight());
        assertEquals(initialColPos + 1 , vehicle.getCol());
    }
    @Test
    void testMoveRightFail() {
        Vehicle tempVehicle = new Vehicle(2, 1, grid, null);
        int initialColPos = tempVehicle.getCol();
        assertFalse(tempVehicle.moveRight());
        assertEquals(initialColPos, tempVehicle.getCol());
    }

    @Test
    void testGetGrid() {
        assertEquals(grid, vehicle.getGrid());
        assertEquals(null, new Vehicle(0, 0, null, null).getGrid());
    }
}
