package foodtruckfrenzy.Helper;

import java.util.ArrayList;

import foodtruckfrenzy.Drawable.Vehicle.Cop;
import foodtruckfrenzy.Drawable.Vehicle.FoodTruck;
import foodtruckfrenzy.GameFramework.Grid;

public class VehicleSpawner {
    private FoodTruck foodTruck;
    private ArrayList<Cop> cops = new ArrayList<Cop>();
    

    public VehicleSpawner(Grid grid) {
        this.foodTruck = new FoodTruck(3, 0, grid);
        cops.add(new Cop(8, 13, grid, foodTruck));
        cops.add(new Cop(17, 40, grid, foodTruck));
        cops.add(new Cop(19, 13, grid, foodTruck));
    }

    public FoodTruck getFoodTruck() {
        return this.foodTruck;
    }

    public ArrayList<Cop> getCops() {
        return cops;
    }
}
