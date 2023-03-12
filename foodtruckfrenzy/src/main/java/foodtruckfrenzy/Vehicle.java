package foodtruckfrenzy;

public class Vehicle extends Drawable {

    private int SPEED = 1;
    private Grid _grid;

    public Vehicle(int row, int col, Grid grid, DrawableEnum type) {
        super(row, col, type);
        _grid = grid;
    }

    public boolean moveUp() {
        int newRow = this.getRow() - SPEED;

        if (newRow < 0) { return false; }

        if (_grid.isObstruction(newRow, this.getCol())) { return false; }

        this.setRow(newRow);
        this.setType(DrawableEnum.FOODTRUCK_UP);

        return true;
    }

    public boolean moveDown() {
        int newRow = this.getRow() + SPEED;

        if (newRow >= Grid.ROWS) { return false; }

        if (_grid.isObstruction(newRow, this.getCol())) { return false; }

        this.setRow(newRow);
        this.setType(DrawableEnum.FOODTRUCK_DOWN);

        return true;
    }

    public boolean moveRight() {
        int newCol = this.getCol() + SPEED;

        if (newCol >= Grid.COLS) { return false; }

        if (_grid.isObstruction(this.getRow(), newCol)) { return false; }

        this.setCol(newCol);
        this.setType(DrawableEnum.FOODTRUCK_RIGHT);

        return true;
    }

    public boolean moveLeft() {
        int newCol = this.getCol() - SPEED;

        if (newCol < 0 ) { return false; }

        if (_grid.isObstruction(this.getRow(), newCol)) { return false; }

        this.setCol(newCol);
        this.setType(DrawableEnum.FOODTRUCK_LEFT);

        return true;
    }

    public Grid getGrid() {
        return _grid;
    }


}
