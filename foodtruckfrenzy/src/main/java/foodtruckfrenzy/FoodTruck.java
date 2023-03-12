package foodtruckfrenzy;

public class FoodTruck extends Drawable {

    private int SPEED = 1;
    private Grid _grid;

    public FoodTruck(int row, int col, Grid grid) {
        super(row, col, DrawableEnum.FOODTRUCK_RIGHT);
        _grid = grid;
    }

    public void moveUp() {
        int newRow = this.getRow() - SPEED;

        if (newRow < 0) { return; }

        if (_grid.isObstruction(newRow, this.getCol())) { return; }

        this.setRow(newRow);
        this.setType(DrawableEnum.FOODTRUCK_UP);
    }

    public void moveDown() {
        int newRow = this.getRow() + SPEED;

        if (newRow >= _grid.getRows()) { return; }

        if (_grid.isObstruction(newRow, this.getCol())) { return; }

        this.setRow(newRow);
        this.setType(DrawableEnum.FOODTRUCK_DOWN);
    }

    public void moveRight() {
        int newCol = this.getCol() + SPEED;

        if (newCol >= _grid.getCols()) { return; }

        if (_grid.isObstruction(this.getRow(), newCol)) { return; }

        this.setCol(newCol);
        this.setType(DrawableEnum.FOODTRUCK_RIGHT);
    }

    public void moveLeft() {
        int newCol = this.getCol() - SPEED;

        if (newCol < 0 ) { return; }

        if (_grid.isObstruction(this.getRow(), newCol)) { return; }

        this.setCol(newCol);
        this.setType(DrawableEnum.FOODTRUCK_LEFT);
    }

}
