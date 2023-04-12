package foodtruckfrenzy.Drawable.Vehicle;

/**
 * Position stores the coordinates and previously visited cell
 * to be used for backtracking in the cop's depth first search
 */
public class Position {
    // represents row value in grid
    public int row;
    // represents column value in grid
    public int col;
    // prev stores position instance used for back tracking in the cop's breadth first search
    public Position prev;
    /**
     * Creates a new Position object holding the specified row and column of the grid.
     * Also holds a position object prev referencing a previous position
     * @param row the row of the grid.
     * @param col the column of the grid.
     * @param prev the previously visited position by the tracking algorithm.
     */
    public Position(int row, int col, Position prev) {
        this.row = row;
        this.col = col;
        this.prev = prev;
    }

    /**
     * Generates a unique key based of the row and column of each position
     * @return returns a key in the form of row_col
     */
    public String generateKey() {
        return row + "_" + col;
    }
}
