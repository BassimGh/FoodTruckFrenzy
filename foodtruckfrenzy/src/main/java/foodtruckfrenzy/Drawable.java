package foodtruckfrenzy;

import java.awt.*;

public abstract class Drawable {

    private int _row;
    private int _col;
    private Image _image;
    private DrawableEnum _type;

    public Drawable(int row, int col, DrawableEnum type) {
        _type = type;
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

    public void setType(DrawableEnum type) {
        _type = type;
    }

    public void draw(Graphics2D g2d) {
        _image = SpriteLoader.getImage(this._type);
        g2d.drawImage(_image, _col * Grid.CELL_SIZE, _row * Grid.CELL_SIZE, Grid.CELL_SIZE, Grid.CELL_SIZE, null);
    }

}
