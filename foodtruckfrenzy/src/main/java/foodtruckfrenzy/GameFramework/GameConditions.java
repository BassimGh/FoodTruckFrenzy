package foodtruckfrenzy.GameFramework;

import java.util.ArrayList;

import foodtruckfrenzy.Drawable.Item.Food;
import foodtruckfrenzy.Drawable.Vehicle.Cop;
import foodtruckfrenzy.Drawable.Vehicle.FoodTruck;

public class GameConditions {
    
    private ArrayList<Cop> _cops;
    private FoodTruck _foodTruck;

    GameConditions(ArrayList<Cop> cops, FoodTruck foodTruck) {
        _cops = cops;
        _foodTruck = foodTruck;
    }
    
    /**
     * checks if the specified FoodTruck object is in the same grid location as any of the Cop objects in the specified array
     * or if the food truck score is < 0
     * @return true if there is a collison between the foodTruck or any Cop in the array or if score < 0, false if not
     */
    boolean checkLoss() {
        if (_foodTruck.getScoreInt() < 0)
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
        return _foodTruck.getCol() == 40 && _foodTruck.getRow() == 16 && _foodTruck.getIngredientsFound() >= Food.getCount();
    }
}
