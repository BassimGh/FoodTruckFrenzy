package foodtruckfrenzy;

public abstract class Cell extends Drawable {

    public Cell(int row, int col, Grid grid ) {
        _row = row;
        _col = col;
        _grid = grid;
    }

    public int getRow() {
        return _row;
    }

    public void setRow(int row) {
        this._row = row;
    }

    public int getCol() {
        return _col;
    }

    public void setCol(int col) {
        _col = col;
    }

    public boolean isObstruction() {
        return this instanceof Obstruction;
    }

}
