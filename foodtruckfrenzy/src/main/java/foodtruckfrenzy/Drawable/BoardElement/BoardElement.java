package foodtruckfrenzy.Drawable.BoardElement;

import foodtruckfrenzy.Drawable.Drawable;
import foodtruckfrenzy.Drawable.DrawableEnum;
import foodtruckfrenzy.Drawable.Item.ScoreValue;

/**
 * Abstract class for the most low level objects that can be stored on the board grid
 */
public abstract class BoardElement extends Drawable {

    /**
     * Constructor for a new board element
     * @param row row which this element is on a grid
     * @param col column which this element is on a grid
     * @param type DrawableEnum which is to be displayed when this image is drawn
     */
    public BoardElement(int row, int col, DrawableEnum type) {
        super(row, col, type);
    }

    /**
     * Interact with board element cell
     * @return a ScoreValue object corresponding to the board elements contents
     */
    public abstract ScoreValue interact();

}
