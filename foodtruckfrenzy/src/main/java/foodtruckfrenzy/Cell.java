package foodtruckfrenzy;

import java.awt.Graphics;

public class Cell {
    private int _row;
    private int _col;
    private Drawable _item;

    public Cell(int row, int col, Drawable item) {
        _row = row;
        _col = col;
        _item = item;
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

    public void draw(Graphics g) {
        g.setColor(_item.getGraphic());
        g.fillRect(_col * Main.CELL_SIZE, _row * Main.CELL_SIZE, Main.CELL_SIZE, Main.CELL_SIZE);
    }

    public boolean isObstruction() {
        return _item instanceof Obstruction;
    }
}