package foodtruckfrenzy;

public class BoardElementFactory {
    public static BoardElement create(BoardElementEnum type) {
        switch (type) {
            case R:
                return new Road();
            case O:
                return new Obstruction();
            case S:
                return new SpeedTrap();
            case P:
                return new PotHole();
            default:
                throw new IllegalArgumentException();
        }
    }
}
