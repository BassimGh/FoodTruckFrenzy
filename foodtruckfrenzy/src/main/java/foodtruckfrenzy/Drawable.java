package foodtruckfrenzy;

import java.awt.Graphics2D;
import java.awt.Color;

public abstract class Drawable {

    int _col;
    int _row;

    public abstract Color getGraphic();

    public void draw(Graphics2D g2d, int cellSize) {
        g2d.setColor(this.getGraphic());
        g2d.fillRect(_col * cellSize, _row * cellSize, cellSize, cellSize);
    }

}
