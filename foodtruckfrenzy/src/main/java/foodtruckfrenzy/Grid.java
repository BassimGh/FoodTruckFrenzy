package foodtruckfrenzy;

import java.awt.Graphics2D;

public class Grid {

    private final int ROWS = 20; // Number of grid rows
    private final int COLS = 25; // Number of grid columns
    private final int CELL_SIZE = 32; // Size of each grid cell
    
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
        grid[row][col].draw(g2d, CELL_SIZE);
    }

    public boolean isObstruction(int row, int col) {
        return grid[row][col].isObstruction();
    }


    public int getRows() {
        return ROWS;
    }

    public int getCols() {
        return COLS;
    }

    public int getCellSize() {
        return CELL_SIZE;
    }


}
