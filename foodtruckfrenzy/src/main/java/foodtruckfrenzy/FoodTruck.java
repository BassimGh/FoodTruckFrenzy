package foodtruckfrenzy;

import java.awt.Color;

public class FoodTruck extends Vehicle {
    
    public FoodTruck(int row, int col, Grid grid) {
        super(row, col, grid);
    }

    @Override
    public Color getGraphic() {
        return Color.RED;
    }
    
}
