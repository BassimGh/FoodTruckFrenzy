package foodtruckfrenzy;

import javax.swing.*;
import java.awt.*;

public abstract class Drawable {

    Grid _grid;
    int _col;
    int _row;

    private Image image;

    public Drawable(String imageName) {

        image = new ImageIcon("src/main/resources/foodtruckfrenzy/"+imageName).getImage();
    }

    public void draw(Graphics2D g2d, int cellSize) {
        g2d.drawImage(image, _col * cellSize, _row * cellSize, cellSize, cellSize, null);
    }

}
