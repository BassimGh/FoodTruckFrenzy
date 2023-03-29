package foodtruckfrenzy.Helper;

import java.util.ArrayList;

import foodtruckfrenzy.Drawable.Vehicle.Cop;
import foodtruckfrenzy.Drawable.Vehicle.CopCreatorThread;
import foodtruckfrenzy.Drawable.Vehicle.FoodTruck;
import foodtruckfrenzy.GameFramework.Grid;


/**
 * Helper class used to initialize and return all vehicle objects
 * used in the game
 */
public class VehicleSpawner {
    private FoodTruck foodTruck;
    private ArrayList<Cop> cops = new ArrayList<Cop>();
    
    /**
     * Initializes all vehicles in the game (food truck and cops)
     * @param grid instance that is used by the game
     */
    public VehicleSpawner(Grid grid) {
        this.foodTruck = new FoodTruck(3, 0, grid);

        ArrayList<CopCreatorThread> copCreatorThreads = new ArrayList<>();
        copCreatorThreads.add(new CopCreatorThread(8, 13, grid, foodTruck));
        copCreatorThreads.add(new CopCreatorThread(14, 22, grid, foodTruck));
        copCreatorThreads.add(new CopCreatorThread(18, 13, grid, foodTruck));
        copCreatorThreads.add(new CopCreatorThread(7, 15, grid, foodTruck));
        copCreatorThreads.add(new CopCreatorThread(16, 20, grid, foodTruck));
        copCreatorThreads.add(new CopCreatorThread(15, 23, grid, foodTruck));
        copCreatorThreads.add(new CopCreatorThread(16, 40, grid, foodTruck));

        for (CopCreatorThread copThread : copCreatorThreads) {
            copThread.start();
            Cop cop = copThread.getCop();
            cops.add(cop);
            foodTruck.attach(cop);
        }
    }

    /**
     * Gets the foodTruck object
     * @return foodTruck instance
     */
    public FoodTruck getFoodTruck() {
        return this.foodTruck;
    }

    /**
     * Gets ArrayList of cops
     * @return ArrayList of Cop objects
     */
    public ArrayList<Cop> getCops() {
        return cops;
    }
}
