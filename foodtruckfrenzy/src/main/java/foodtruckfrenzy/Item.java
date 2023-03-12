package foodtruckfrenzy;

public class Item extends Drawable {

    private int _value;
    public Item(int row, int col, DrawableEnum type, int value) {
        super(row, col, type);
        _value = value;
    }
    
    public int getValue() {
        return _value;
    }
}
