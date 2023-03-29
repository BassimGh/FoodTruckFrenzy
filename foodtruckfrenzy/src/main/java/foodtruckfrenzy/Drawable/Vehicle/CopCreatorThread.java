package foodtruckfrenzy.Drawable.Vehicle;

import foodtruckfrenzy.GameFramework.Grid;

/**
 * CopCreatorThread is responsible for creating a new cop instance
 * When calling start(), the cop will intialize and the getDirections is run
 */
public class CopCreatorThread extends Thread {
    
    private Cop _cop;

    /**
     * Creates a new cop creator thread
     * @param row row of cop placement
     * @param col column of cop placement
     * @param grid grid that cop belongs to
     * @param player foodtruck that cop will follow
     */
    public CopCreatorThread(int row, int col, Grid grid, FoodTruck player) {
        this._cop = new Cop(row, col, grid, player);
    }

    /**
     * Called on thread start, intitializes cops first directions
     */
    @Override
    public void run() {
        _cop.getDirections();
    }

    /**
     * Getter for the cop object that was created
     * @return Cop object that was created by this thread
     */
    public Cop getCop() {
        return _cop;
    }

}
