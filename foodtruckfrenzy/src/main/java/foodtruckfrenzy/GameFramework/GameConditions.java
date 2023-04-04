package foodtruckfrenzy.GameFramework;

import java.util.ArrayList;

import foodtruckfrenzy.Drawable.Vehicle.Cop;
import foodtruckfrenzy.Drawable.Vehicle.FoodTruck;

/**
 * The GameConditions class is responsible for checking win and loss conditions
 */
public class GameConditions {
    
    private ArrayList<Cop> _cops;
    private FoodTruck _foodTruck;
    private Scoreboard _scoreboard;
    private boolean _paused = false;

    /**
     * Constructs a new GameConditions object that checks the win and loss
     * conditions for the specified FoodTruck and Cop instances.
     * @param cops      the ArrayList of Cop instances in the game
     * @param foodTruck the FoodTruck instance representing the player
     */
    GameConditions(ArrayList<Cop> cops, FoodTruck foodTruck) {
        _cops = cops;
        _foodTruck = foodTruck;
        _scoreboard = foodTruck.getScoreboard();
    }
    
    /**
     * checks if the specified FoodTruck object is in the same grid location as any of the Cop objects in the specified array
     * or if the food truck score is < 0
     * @return true if there is a collison between the foodTruck or any Cop in the array or if score < 0, false if not
     */
    boolean checkLoss() {
        if (_paused)
            return false;

        if (_scoreboard.getScore() < 0)
            return true;

        for (Cop cop : _cops)
            if (cop.getCol() == _foodTruck.getCol() && cop.getRow() == _foodTruck.getRow())
                return true;
        
        return false;

    }

    /**
     * Check win condition for the game, if foodTruck collected all Food items in the system and is on tile row 16, column 40
     * @param _foodTruck foodTruck corresponding to player being checked for a win
     * @return true if there is a successful win, otherwise false
     */
    boolean checkWin() {
        if (_paused)
            return false;
        
        return _foodTruck.getCol() == 40 && _foodTruck.getRow() == 16 && _scoreboard.getIngredientsFound() >= _scoreboard.getIngredientsDiscoverable();
    }

    void pause() {
        _paused = true;
    }

    void resume() {
        _paused = false;
    }

    boolean checkPaused() {
        return _paused;
    }
}
