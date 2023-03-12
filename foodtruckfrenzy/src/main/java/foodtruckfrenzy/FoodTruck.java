package foodtruckfrenzy;

public class FoodTruck extends Vehicle {

    public int score = 0; 

    public FoodTruck(int row, int col, Grid grid) {
        super(row, col, grid, DrawableEnum.FOODTRUCK_RIGHT);
    }

    @Override
    public void moveUp() {
        super.moveUp();
        //interaction here
    }

    @Override
    public void moveDown() {
        super.moveDown();
        //interaction here
    }

    @Override
    public void moveRight() {
        super.moveRight();
        //interaction here
    }

    @Override
    public void moveLeft() {
        super.moveLeft();
        //interaction here
    }

}
