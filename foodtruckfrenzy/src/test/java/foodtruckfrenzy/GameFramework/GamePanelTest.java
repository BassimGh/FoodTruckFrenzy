package foodtruckfrenzy.GameFramework;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import foodtruckfrenzy.Drawable.Vehicle.Cop;
import foodtruckfrenzy.Drawable.Vehicle.FoodTruck;

public class GamePanelTest {
    
    private GamePanel gamePanel;

    @Test
    public void testGamePanelConstructorCops() {
        ArrayList<Cop> cops = new ArrayList<>();
        Cop cop1 = Mockito.mock(Cop.class);
        Cop cop2 = Mockito.mock(Cop.class);
        cops.add(cop1);
        cops.add(cop2);

        gamePanel = new GamePanel(null, null, cops);

        assertEquals(cops, gamePanel.getCops());
        assertEquals(cop1, cops.get(0));
        assertEquals(cop2, cops.get(1));
    }

    @Test
    public void testGamePanelConstructorFoodTruck() {
        FoodTruck foodTruck = Mockito.mock(FoodTruck.class);
        gamePanel = new GamePanel(null, foodTruck, null);

        assertEquals(foodTruck, gamePanel.getFoodTruck());
    }

    @Test
    public void testGamePanelConstructorGrid() {
        Grid grid = Mockito.mock(Grid.class);
        gamePanel = new GamePanel(grid, null, null);

        assertEquals(grid, gamePanel.getGrid());
    }
}
