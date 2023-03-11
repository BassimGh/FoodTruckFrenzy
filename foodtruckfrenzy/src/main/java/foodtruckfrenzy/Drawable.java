package foodtruckfrenzy;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public abstract class Drawable {

    private int _row;
    private int _col;
    private Image image;

    public Drawable(int row, int col, String imageName) {
        _row = row;
        _col = col;

        // Load the image as an input stream from inside the jar file
        InputStream imageStream = getClass().getResourceAsStream("/foodtruckfrenzy/" + imageName);

        try {
            // Use ImageIO to read the image from the input stream
            image = ImageIO.read(imageStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
