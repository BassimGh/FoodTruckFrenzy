package foodtruckfrenzy;

public class BoardElementFactory {
    public static Cell create(BoardElementEnum type, int row, int col, Grid grid) {
        switch (type) {
            case R:
                return new Road(row, col, grid);
            case O:
                return new Obstruction(row, col, grid);
            case S:
                return new SpeedTrap(row, col, grid);
            case P:
                return new PotHole(row, col, grid);
            default:
                throw new IllegalArgumentException();
        }
    }
}
