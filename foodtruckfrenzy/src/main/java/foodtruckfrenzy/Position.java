package foodtruckfrenzy;

public class Position {

    public Position(int row, int col, Position prev) {
        this.row = row;
        this.col = col;
        this.prev = prev;
    }

    public int row;
    public int col;
    public Position prev;
}
