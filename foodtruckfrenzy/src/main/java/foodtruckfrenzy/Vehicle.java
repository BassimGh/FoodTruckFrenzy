package foodtruckfrenzy;

public abstract class Vehicle extends Drawable {

    private int SPEED = 1;

    public Vehicle(int row, int col, Grid grid, String imageName) {
        super(imageName);
        _row = row;
        _col = col;
        _grid = grid;

    }

    public int getRow() {
        return _row;
    }

    public int getCol() {
        return _col;
    }

    public void setRow(int row) {
        _row = row;
    }

    public void setCol(int col) {
        _col = col;
    }

    public void moveUp() {
        int newRow = _row -SPEED;

        if (newRow < 0) { return; }

        if (_grid.isObstruction(newRow, _col)) { return; }

        _row = newRow;
    }

    public void moveDown() {
        int newRow = _row + SPEED;

        if (newRow >= _grid.getRows()) { return; }

        if (_grid.isObstruction(newRow, _col)) { return; }

        _row = newRow;
    }

    public void moveRight() {
        int newCol = _col + SPEED;

        if (newCol >= _grid.getCols()) { return; }

        if (_grid.isObstruction(_row, newCol)) { return; }

        _col = newCol;
    }

    public void moveLeft() {
        int newCol = _col - SPEED;

        if (newCol < 0 ) { return; }

        if (_grid.isObstruction(_row, newCol)) { return; }

        _col = newCol;
    }

}
