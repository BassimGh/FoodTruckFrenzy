package foodtruckfrenzy;

import java.util.ArrayList;

public class Cop extends Vehicle{

    private FoodTruck foodtruck;

    private ArrayList<Direction> directions = new ArrayList<>();

    public Cop(int row, int col, Grid grid, FoodTruck target) {
        super(row, col, grid, DrawableEnum.COP_RIGHT);
    }

    @Override
    public boolean moveUp() {
        boolean moved = super.moveUp();
        this.setType(DrawableEnum.COP_UP);
        return moved;
    }

    @Override
    public boolean moveDown() {
        boolean moved = super.moveDown();
        this.setType(DrawableEnum.COP_DOWN);
        return moved;
    }

    @Override
    public boolean moveLeft() {
        boolean moved = super.moveLeft();
        this.setType(DrawableEnum.COP_LEFT);
        return moved;
    }

    @Override
    public boolean moveRight() {
        boolean moved = super.moveRight();
        this.setType(DrawableEnum.COP_RIGHT);
        return moved;
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
