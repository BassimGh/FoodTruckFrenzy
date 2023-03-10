package foodtruckfrenzy;

public class ItemFactory {
    public static Item create(ItemEnum type) {
        switch (type) {
            case ROAD:
                return new Road();
            case OBSTRUCTION:
                return new Obstruction();
            default:
                throw new IllegalArgumentException();
        }
    }
}
