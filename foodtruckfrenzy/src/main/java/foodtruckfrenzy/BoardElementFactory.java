package foodtruckfrenzy;

public class BoardElementFactory {
    public static Cell create(BoardElementEnum type, int row, int col) {
        switch (type) {
            case R:
                return new Road(row, col);
            case O:
                return new Obstruction(row, col);
            case S:
                return new SpeedTrap(row, col);
            case P:
                return new PotHole(row, col);
            default:
                throw new IllegalArgumentException();
        }
    }
}
