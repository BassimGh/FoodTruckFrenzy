package foodtruckfrenzy;

public class ItemFactory {
    public static Item create(ItemEnum type) {
        switch (type) {
            case R:
                return new Road();
            case O:
                return new Obstruction();
            default:
                throw new IllegalArgumentException();
        }
    }
}
