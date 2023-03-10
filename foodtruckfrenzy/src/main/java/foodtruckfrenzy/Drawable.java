package foodtruckfrenzy;

import javax.swing.*;
import java.awt.*;

public abstract class Drawable {

    Grid _grid;
    int _col;
    int _row;

    private Image image;

    public Drawable() {
        image = new ImageIcon("src/main/resources/foodtruckfrenzy/foodtruck.png").getImage();
    }

    public abstract Color getGraphic();

    public void draw(Graphics2D g2d, int cellSize) {
        g2d.setColor(this.getGraphic());
        g2d.fillRect(_col * cellSize, _row * cellSize, cellSize, cellSize);
    }

    public void drawImage(Graphics2D g2d, int cellSize) {
        g2d.drawImage(image, _col * cellSize, _row * cellSize, cellSize, cellSize, null);
    }

}
