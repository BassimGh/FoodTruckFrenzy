package foodtruckfrenzy;

public class BoardElementFactory {
    public static BoardElement create(BoardElementEnum type, int row, int col) {
        switch (type) {
            case H:
                return new Road(row, col, null, DrawableEnum.HORIZONTAL_ROAD);
            case V:
                return new Road(row, col, null, DrawableEnum.VERTICAL_ROAD);
            case X:
                return new Road(row, col, null, DrawableEnum.FOUR_WAY_INTERSECT);
            case O:
                return new Obstruction(row, col);
            case S:
                return new Road(row, col, new SpeedTrap(row, col), DrawableEnum.HORIZONTAL_ROAD);
            case P:
                return new Road(row, col, new PotHole(row, col), DrawableEnum.HORIZONTAL_ROAD);
            case F:
                return new Road(row, col, new Food(row, col), DrawableEnum.HORIZONTAL_ROAD);
            default:
                throw new IllegalArgumentException();
        }
    }
}
