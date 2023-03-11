package foodtruckfrenzy;

public class FoodTruck extends Drawable {

    private int SPEED = 1;
    private Grid _grid;

    public FoodTruck(int row, int col, Grid grid) {
        super(row, col, "foodtruck.png");
        _grid = grid;
    }

    public void moveUp() {
        int newRow = this.getRow() - SPEED;

        if (newRow < 0) { return; }

        if (_grid.isObstruction(newRow, this.getCol())) { return; }

        this.setRow(newRow);
    }

    public void moveDown() {
        int newRow = this.getRow() + SPEED;

        if (newRow >= _grid.getRows()) { return; }

        if (_grid.isObstruction(newRow, this.getCol())) { return; }

        this.setRow(newRow);
    }

    public void moveRight() {
        int newCol = this.getCol() + SPEED;

        if (newCol >= _grid.getCols()) { return; }

        if (_grid.isObstruction(this.getRow(), newCol)) { return; }

        this.setCol(newCol);
    }

    public void moveLeft() {
        int newCol = this.getCol() - SPEED;

        if (newCol < 0 ) { return; }

        if (_grid.isObstruction(this.getRow(), newCol)) { return; }

        this.setCol(newCol);
    }

}
