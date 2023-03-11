package foodtruckfrenzy;

public abstract class BoardElement extends Drawable {

    public BoardElement(int row, int col, DrawableEnum type) {
        super(row, col, type);
    }

    public boolean isObstruction() {
        return this instanceof Obstruction;
    }

}
