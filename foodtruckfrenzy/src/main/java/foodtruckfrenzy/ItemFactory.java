package foodtruckfrenzy;

public class ItemFactory {
    public static Item create(ItemEnum type) {
        switch (type) {
            case Road:
                return new Road();
            case Obstruction:
                return new Obstruction();
            default:
                throw new IllegalArgumentException();
        }
    }
}
