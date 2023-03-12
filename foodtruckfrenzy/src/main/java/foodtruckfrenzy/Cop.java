package foodtruckfrenzy;

import java.util.ArrayList;

public class Cop extends Vehicle{

    private FoodTruck foodtruck;

    private ArrayList<Direction> directions = new ArrayList<>();

    public Cop(int row, int col, Grid grid, FoodTruck target) {
        super(row, col, grid, DrawableEnum.COP_RIGHT);
    }

    @Override
    public void moveUp() {
        super.moveUp();
        this.setType(DrawableEnum.COP_UP);
    }

    @Override
    public void moveDown() {
        super.moveDown();
        this.setType(DrawableEnum.COP_DOWN);
    }

    @Override
    public void moveLeft() {
        super.moveLeft();
        this.setType(DrawableEnum.COP_LEFT);
    }

    @Override
    public void moveRight() {
        super.moveRight();
        this.setType(DrawableEnum.COP_RIGHT);
    }

    public void chaseTruck() {
        this.moveRight();
        // int currentX = this.getRow();
        // int currentY = this.getCol();

        // int targetX = foodtruck.getCol();
        // int targetY = foodtruck.getRow();

        // while (!(currentX == targetX && currentY == targetY)) {
            
        // }
        // getPath();
    }

}
