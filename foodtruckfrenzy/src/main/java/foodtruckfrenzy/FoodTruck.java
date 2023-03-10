package foodtruckfrenzy;

import java.awt.Color;

public class FoodTruck extends Vehicle {
    
    public FoodTruck(int row, int col) {
        super(row, col);
    }

    @Override
    public Color getGraphic() {
        return Color.RED;
    }
    
}
