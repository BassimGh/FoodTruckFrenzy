package foodtruckfrenzy.GameFramework;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.*;

import foodtruckfrenzy.Drawable.Vehicle.Cop;
import foodtruckfrenzy.Drawable.Vehicle.FoodTruck;

public class GameConditionsTest {
    
    private GameConditions gameConditions;
    private Scoreboard scoreboard;
    private FoodTruck foodTruck;
    private ArrayList<Cop> cops;

    @BeforeEach
    void setup() {
        scoreboard = new Scoreboard(5, 5);
        foodTruck = new FoodTruck(5, 6, null, scoreboard);
        cops = new ArrayList<>();
        gameConditions = new GameConditions(cops, foodTruck);
    }

    @Test
    void checkLossFalse() {
        cops.add(new Cop(0, 1, null, foodTruck));
        cops.add(new Cop(2, 3, null, foodTruck));
        assertFalse(gameConditions.checkLoss());
        cops.clear();
    }

    @Test
    void checkLossTrueScoreNegative() {
        scoreboard.addScore(-1);
        assertTrue(gameConditions.checkLoss());
        scoreboard.addScore(1);
        assertFalse(gameConditions.checkLoss());
    }

    @Test
    void checkLossTrueCopCollisionFirstCar() {
        cops.add(new Cop(5, 6, null, foodTruck));
        assertTrue(gameConditions.checkLoss());
        cops.clear();
        assertFalse(gameConditions.checkLoss());
    }

    @Test
    void checkLossTrueCopCollisionThirdCar() {
        cops.add(new Cop(0, 1, null, foodTruck));
        cops.add(new Cop(2, 3, null, foodTruck));
        cops.add(new Cop(5, 6, null, foodTruck));
        assertTrue(gameConditions.checkLoss());
        cops.clear();
        assertFalse(gameConditions.checkLoss());
    }

}
