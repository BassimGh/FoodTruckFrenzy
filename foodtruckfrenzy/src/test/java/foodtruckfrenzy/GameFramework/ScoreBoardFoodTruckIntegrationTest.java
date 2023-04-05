package foodtruckfrenzy.GameFramework;

import org.junit.jupiter.api.*;
import foodtruckfrenzy.Drawable.Item.ScoreType;
import foodtruckfrenzy.Drawable.Item.ScoreValue;
import foodtruckfrenzy.Drawable.Vehicle.FoodTruck;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;



public class ScoreBoardFoodTruckIntegrationTest {
    
    
    @Test
    public void testInteractFood() {
        // Create a mock Grid object
        Grid grid = mock(Grid.class);

        // Create a ScoreValue object
        ScoreValue scoreValue = new ScoreValue(ScoreType.FOOD, 10);
    
        // Create a mock Scoreboard object
        Scoreboard scoreboard = mock(Scoreboard.class);
    
        // Create a FoodTruck object
        FoodTruck foodTruck = new FoodTruck(0, 0, grid, scoreboard);
    
        // Set up the Grid object to return the ScoreValue object when interact() is called
        when(grid.interact(0, 0)).thenReturn(scoreValue);
    
        // Call the interact() method on the FoodTruck object
        foodTruck.interact();
    
        // Verify that the scoreboard was updated correctly
        verify(scoreboard).addScore(10);
        verify(scoreboard).addIngredientsFound();
        }


    @Test
    public void testInteractDamage() {
        // Create a mock Grid object
        Grid grid = mock(Grid.class);

        // Create a ScoreValue object
        ScoreValue scoreValue = new ScoreValue(ScoreType.DAMAGE, 10);
    
        // Create a mock Scoreboard object
        Scoreboard scoreboard = mock(Scoreboard.class);
    
        // Create a FoodTruck object
        FoodTruck foodTruck = new FoodTruck(0, 0, grid, scoreboard);
    
        // Set up the Grid object to return the ScoreValue object when interact() is called
        when(grid.interact(0, 0)).thenReturn(scoreValue);
    
        // Call the interact() method on the FoodTruck object
        foodTruck.interact();
    
        // Verify that the scoreboard was updated correctly
        verify(scoreboard).addScore(10);
        verify(scoreboard).addDamage(10);
        }
    
    @Test
    public void testInteractSpeed() {
        // Create a mock Grid object
        Grid grid = mock(Grid.class);

        // Create a ScoreValue object
        ScoreValue scoreValue = new ScoreValue(ScoreType.SPEED, 10);
    
        // Create a mock Scoreboard object
        Scoreboard scoreboard = mock(Scoreboard.class);
    
        // Create a FoodTruck object
        FoodTruck foodTruck = new FoodTruck(0, 0, grid, scoreboard);
    
        // Set up the Grid object to return the ScoreValue object when interact() is called
        when(grid.interact(0, 0)).thenReturn(scoreValue);
    
        // Call the interact() method on the FoodTruck object
        foodTruck.interact();
    
        // Verify that the scoreboard was updated correctly
        verify(scoreboard).addScore(10);
        verify(scoreboard).addFines(10);
        }
    
          
    @Test
    public void testInteractBonus() {
        // Create a mock Grid object
        Grid grid = mock(Grid.class);

        // Create a ScoreValue object
        ScoreValue scoreValue = new ScoreValue(ScoreType.BONUS, 10);
    
        // Create a mock Scoreboard object
        Scoreboard scoreboard = mock(Scoreboard.class);
    
        // Create a FoodTruck object
        FoodTruck foodTruck = new FoodTruck(0, 0, grid, scoreboard);
    
        // Set up the Grid object to return the ScoreValue object when interact() is called
        when(grid.interact(0, 0)).thenReturn(scoreValue);
    
        // Call the interact() method on the FoodTruck object
        foodTruck.interact();
    
        // Verify that the scoreboard was updated correctly
        verify(scoreboard).addScore(10);
        verify(scoreboard).addRecipesFound();
    }

    @Test
    public void testInteractNULL() {
        // Create a mock Grid object
        Grid grid = mock(Grid.class);

        // Create a ScoreValue object
        ScoreValue scoreValue = new ScoreValue(ScoreType.NULL, 0);
    
        // Create a mock Scoreboard object
        Scoreboard scoreboard = mock(Scoreboard.class);
    
        // Create a FoodTruck object
        FoodTruck foodTruck = new FoodTruck(0, 0, grid, scoreboard);
    
        // Set up the Grid object to return the ScoreValue object when interact() is called
        when(grid.interact(0, 0)).thenReturn(scoreValue);
    
        // Call the interact() method on the FoodTruck object
        foodTruck.interact();
    
        // Verify that the scoreboard was updated correctly
        verify(scoreboard).addScore(0);
    }

}
