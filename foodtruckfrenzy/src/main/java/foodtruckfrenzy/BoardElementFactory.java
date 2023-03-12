package foodtruckfrenzy;

public class BoardElementFactory {
    public static BoardElement create(BoardElementEnum type, int row, int col) {
        switch (type) {
            case R:
                return new Road(row, col, null);
            case O:
                return new Obstruction(row, col);
            case S:
                return new Road(row, col, DrawableEnum.SPEED_TRAP);
            case P:
                return new Road(row, col, DrawableEnum.POT_HOLE);
            default:
                throw new IllegalArgumentException();
        }
    }
}
