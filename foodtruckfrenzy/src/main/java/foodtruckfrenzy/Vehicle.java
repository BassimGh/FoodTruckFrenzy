package foodtruckfrenzy;

public class Vehicle extends Drawable {

    private int SPEED = 1;
    private Grid _grid;

    public Vehicle(int row, int col, Grid grid, DrawableEnum type) {
        super(row, col, type);
        _grid = grid;
    }

    public void moveUp() {
        int newRow = this.getRow() - SPEED;

        if (newRow < 0) { return; }

        if (_grid.isObstruction(newRow, this.getCol())) { return; }

        _grid.interact(newRow, this.getCol());

        this.setRow(newRow);
        this.setType(DrawableEnum.FOODTRUCK_UP);
    }

    public void moveDown() {
        int newRow = this.getRow() + SPEED;

        if (newRow >= Grid.ROWS) { return; }

        if (_grid.isObstruction(newRow, this.getCol())) { return; }
        
        _grid.interact(newRow, this.getCol());

        this.setRow(newRow);
        this.setType(DrawableEnum.FOODTRUCK_DOWN);
    }

    public void moveRight() {
        int newCol = this.getCol() + SPEED;

        if (newCol >= Grid.COLS) { return; }

        if (_grid.isObstruction(this.getRow(), newCol)) { return; }

        _grid.interact(this.getRow(), newCol);

        this.setCol(newCol);
        this.setType(DrawableEnum.FOODTRUCK_RIGHT);
    }

    public void moveLeft() {
        int newCol = this.getCol() - SPEED;

        if (newCol < 0 ) { return; }

        if (_grid.isObstruction(this.getRow(), newCol)) { return; }

        _grid.interact(this.getRow(), newCol);

        this.setCol(newCol);
        this.setType(DrawableEnum.FOODTRUCK_LEFT);
    }

}
