package foodtruckfrenzy.Drawable.Vehicle;

import foodtruckfrenzy.GameFramework.Grid;

public class CopCreatorThread extends Thread {
    
    private Cop cop;

    public CopCreatorThread(int row, int col, Grid grid, FoodTruck player) {
        this.cop = new Cop(row, col, grid, player);
    }

    @Override
    public void run() {
        cop.getDirections();
    }

    public Cop getCop() {
        return cop;
    }

}
