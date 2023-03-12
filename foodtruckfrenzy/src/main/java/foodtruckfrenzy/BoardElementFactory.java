package foodtruckfrenzy;

public class BoardElementFactory {
    public static BoardElement create(BoardElementEnum type, int row, int col) {
        switch (type) {
            case R:
                return new Road(row, col, null);
            case O:
                return new Obstruction(row, col);
            case S:
                return new Road(row, col, new SpeedTrap(row, col));
            case P:
                return new Road(row, col, new PotHole(row, col));
            default:
                throw new IllegalArgumentException();
        }
    }
}
