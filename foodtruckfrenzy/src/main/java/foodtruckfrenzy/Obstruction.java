package foodtruckfrenzy;

public class Obstruction extends BoardElement {

    public Obstruction(int row, int col) {
        super(row, col, DrawableEnum.OBSTRUCTION);
    }

    @Override
    public int interact() {
        throw new UnsupportedOperationException(" 'interact' method called on an obstruction");
    }   
}
