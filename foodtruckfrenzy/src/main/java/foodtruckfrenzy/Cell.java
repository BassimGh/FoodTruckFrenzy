package foodtruckfrenzy;

import java.awt.Color;
import java.awt.Graphics2D;


public class Cell extends Drawable {
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

    public boolean isObstruction() {
        return _item instanceof Obstruction;
    }

    @Override
    public void draw(Graphics2D g2d, int cellSize) {
        _item.draw(g2d, cellSize);
    }

    @Override
    public Color getGraphic() {
        return _item.getGraphic();
    }
}