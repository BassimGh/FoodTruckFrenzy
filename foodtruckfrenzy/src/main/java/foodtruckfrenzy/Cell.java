package foodtruckfrenzy;

import java.awt.Graphics2D;


public class Cell {
    private int _row;
    private int _col;
    private BoardElement _item;

    public Cell(int row, int col, BoardElement item) {
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

    public void draw(Graphics2D g2d) {
        g2d.setColor(_item.getGraphic());
        g2d.fillRect(_col * Main.CELL_SIZE, _row * Main.CELL_SIZE, Main.CELL_SIZE, Main.CELL_SIZE);
    }

    public boolean isObstruction() {
        return _item instanceof Obstruction;
    }
}