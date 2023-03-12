package foodtruckfrenzy;

public class FoodTruck extends Vehicle {

    public int score = 0; 

    public FoodTruck(int row, int col, Grid grid) {
        super(row, col, grid, DrawableEnum.FOODTRUCK_RIGHT);
    }

    @Override
    public void moveUp() {
        super.moveUp();
        this.setType(DrawableEnum.FOODTRUCK_UP);
        //interaction here
    }

    @Override
    public void moveDown() {
        super.moveDown();
        this.setType(DrawableEnum.FOODTRUCK_DOWN);
        //interaction here
    }

    @Override
    public void moveRight() {
        super.moveRight();
        this.setType(DrawableEnum.FOODTRUCK_RIGHT);
        //interaction here
    }

    @Override
    public void moveLeft() {
        super.moveLeft();
        this.setType(DrawableEnum.FOODTRUCK_LEFT);
        //interaction here
    }

}
