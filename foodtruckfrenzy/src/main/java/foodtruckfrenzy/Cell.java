package foodtruckfrenzy;

import java.awt.Color;
import java.awt.Graphics;

public class Cell {
    private int row;
    private int col;
    private Color color;

    public Cell(int row, int col, Color color) {
        this.row = row;
        this.col = col;
        this.color = color;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(col * Main.CELL_SIZE, row * Main.CELL_SIZE, Main.CELL_SIZE, Main.CELL_SIZE);
    }
}