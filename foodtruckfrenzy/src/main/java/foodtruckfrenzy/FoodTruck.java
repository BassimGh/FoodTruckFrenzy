package foodtruckfrenzy;

import java.awt.Color;

public class FoodTruck extends Vehicle {

    FoodTruck(double x, double y) {
        super(x, y);
        //TODO Auto-generated constructor stub
    }
    
    @Override
    public Color getGraphic() {
        return Color.RED;
    }
    
}
