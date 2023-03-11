package foodtruckfrenzy;

import java.awt.*;

public abstract class Drawable {

    private int _row;
    private int _col;
    private Image _image;

    public Drawable(int row, int col, DrawableEnum type) {
        _image = SpriteLoader.getImage(type);
        _row = row;
        _col = col;
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
        g2d.drawImage(_image, _col * Grid.CELL_SIZE, _row * Grid.CELL_SIZE, Grid.CELL_SIZE, Grid.CELL_SIZE, null);
    }

}
