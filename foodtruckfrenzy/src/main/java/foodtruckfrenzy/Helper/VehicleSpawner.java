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

        ArrayList<CopCreatorThread> copCreatorThreads = new ArrayList<>();
        copCreatorThreads.add(new CopCreatorThread(8, 13, grid, foodTruck));
        copCreatorThreads.add(new CopCreatorThread(17, 30, grid, foodTruck));
        copCreatorThreads.add(new CopCreatorThread(19, 13, grid, foodTruck));
        copCreatorThreads.add(new CopCreatorThread(17, 30, grid, foodTruck));
        copCreatorThreads.add(new CopCreatorThread(5, 23, grid, foodTruck));

        for (CopCreatorThread copThread : copCreatorThreads) {
            copThread.start();
            Cop cop = copThread.getCop();
            cops.add(cop);
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
