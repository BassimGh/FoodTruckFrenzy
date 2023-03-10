package foodtruckfrenzy;

import java.awt.Graphics2D;

public abstract class Vehicle implements Graphical {
    
    private int _row;
    private int _col;

    public Vehicle(int row, int col) {
        _row = row;
        _col = col;
    }

    public int getRow() {
        return _row;
    }

    public int getCol() {
        return _col;
    }

    public void setRow(int row) {
        _row = row;
    }

    public void setCol(int col) {
        _col = col;
    }

    public void draw(Graphics2D g2d) {
        g2d.setColor(this.getGraphic());
        g2d.fillRect(_col * Main.CELL_SIZE, _row * Main.CELL_SIZE, Main.CELL_SIZE, Main.CELL_SIZE);
    }


}
