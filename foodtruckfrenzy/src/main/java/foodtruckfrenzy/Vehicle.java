package foodtruckfrenzy;

public abstract class Vehicle extends Drawable {

    public Vehicle(int row, int col) {
        _row = row;
        _col = col;
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

}
