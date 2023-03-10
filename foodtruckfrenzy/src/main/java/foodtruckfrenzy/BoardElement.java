package foodtruckfrenzy;

public abstract class BoardElement extends Drawable {

    public BoardElement(int row, int col, Grid grid, String imageName) {
        super(imageName);
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
