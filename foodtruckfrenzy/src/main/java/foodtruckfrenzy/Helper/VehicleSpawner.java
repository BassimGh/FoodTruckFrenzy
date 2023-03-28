package foodtruckfrenzy.Helper;

import java.util.ArrayList;

import foodtruckfrenzy.Drawable.Vehicle.Cop;
import foodtruckfrenzy.Drawable.Vehicle.CopCreatorThread;
import foodtruckfrenzy.Drawable.Vehicle.FoodTruck;
import foodtruckfrenzy.GameFramework.Grid;

public class VehicleSpawner {
    private FoodTruck foodTruck;
    private ArrayList<Cop> cops = new ArrayList<Cop>();
    

    public VehicleSpawner(Grid grid) {
        this.foodTruck = new FoodTruck(3, 0, grid);

        CopCreatorThread copThread = new CopCreatorThread(8, 13, grid, foodTruck);
        copThread.start();
        cops.add(copThread.getCop());

        copThread = new CopCreatorThread(17, 40, grid, foodTruck);
        copThread.start();
        cops.add(copThread.getCop());

        copThread = new CopCreatorThread(19, 13, grid, foodTruck);
        copThread.start();
        cops.add(copThread.getCop());

        for (Cop cop : cops) {
            foodTruck.attach(cop);
        }
    }

    public FoodTruck getFoodTruck() {
        return this.foodTruck;
    }

    public ArrayList<Cop> getCops() {
        return cops;
    }
}
