package foodtruckfrenzy;

public abstract class BoardElement extends Drawable {

    public BoardElement(int row, int col, String imageName) {
        super(row, col, imageName);
    }

    public boolean isObstruction() {
        return this instanceof Obstruction;
    }

}
