package foodtruckfrenzy;

import javax.swing.*;
import java.awt.*;

public abstract class Drawable {

    private int _row;
    private int _col;
    private Image image;

    public Drawable(int row, int col, String imageName) {

        _row = row;
        _col = col;
        image = new ImageIcon("src/main/resources/foodtruckfrenzy/"+imageName).getImage();
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

    public void draw(Graphics2D g2d, int cellSize) {
        g2d.drawImage(image, _col * cellSize, _row * cellSize, cellSize, cellSize, null);
    }

}
