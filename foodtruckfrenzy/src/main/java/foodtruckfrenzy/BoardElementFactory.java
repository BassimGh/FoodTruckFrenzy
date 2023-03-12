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

            case U:
                return new Road(row, col, null, DrawableEnum.NORTH_WEST_CORNER);
            case I:
                return new Road(row, col, null, DrawableEnum.NORTH_EAST_CORNER);
            case J:
                return new Road(row, col, null, DrawableEnum.SOUTH_EAST_CORNER);
            case K:
                return new Road(row, col, null, DrawableEnum.SOUTH_WEST_CORNER);
                
            case N:
                return new Road(row, col, null, DrawableEnum.THREE_WAY_NORTH);
            case B:
                return new Road(row, col, null, DrawableEnum.THREE_WAY_EAST);
            case M:
                return new Road(row, col, null, DrawableEnum.THREE_WAY_SOUTH);
            case C:
                return new Road(row, col, null, DrawableEnum.THREE_WAY_WEST);


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
