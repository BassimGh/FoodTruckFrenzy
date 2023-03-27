package foodtruckfrenzy.Helper;

import java.util.ArrayList;

import foodtruckfrenzy.Drawable.Vehicle.Cop;
import foodtruckfrenzy.Drawable.Vehicle.FoodTruck;
import foodtruckfrenzy.GameFramework.Grid;

public class VehicleSpawner {
    private Grid grid;
    private FoodTruck foodTruck;
    private ArrayList<Cop> cops;
    

    public VehicleSpawner(Grid grid) {
        this.grid = grid;
        this.foodTruck = new FoodTruck(3, 0, grid);
    }

    public FoodTruck getFoodTruck() {
        return this.foodTruck;
    }

    public ArrayList<Cop> getCops() {
        return cops;
    }
}
