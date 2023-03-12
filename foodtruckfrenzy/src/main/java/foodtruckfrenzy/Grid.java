package foodtruckfrenzy;

import java.awt.Graphics2D;

public class Grid {

    final static int ROWS = 20; // Number of grid rows
    final static int COLS = 40; // Number of grid columns
    final static int CELL_SIZE = 32; // Size of each grid cell
    
    private BoardElement[][] grid;

    public Grid() {
        grid = new BoardElement[ROWS][COLS];
    }

    public BoardElement getCell(int row, int col) {
        return grid[row][col];
    }

    public void setCell(int row, int col, BoardElement cell) {
        grid[row][col] = cell;
    }

    public void drawCell(int row, int col, Graphics2D g2d) {
        grid[row][col].draw(g2d);
    }

    public boolean isObstruction(int row, int col) {
        return grid[row][col].isObstruction();
    }

    public ScoreValue interact(int row, int col) {

        return getCell(row, col).interact();
    }

}
