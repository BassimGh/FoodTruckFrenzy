package foodtruckfrenzy.SecondaryUI;

/**
 *The Dimensions class contains the width and height variable to be supplied by each type of child class to the Screen class
 *Each class will create a new Dimensions object that contains the custom height and width for the Screen class to use
 */

public class Dimensions {
    /**
     * The dimension width variable to be used
     */
    protected final int width;
    /**
     * The dimension height variable to be used
     */
    protected final int height;
     /**
     * Constructs a new Dimensions object to pass Screen Dimensions through
     * @param width the custom width is set by the child Screen class
     * @param height the custom height is set by the child Screen class
     */
    public Dimensions(int width, int height) {
        this.width = width;
        this.height = height;
    }

    /**
     * Gets the width dimension of the object
     * @return The width dimension of the object
     */

    public int getWidth() {
        return width;
    }

    /**
     * Gets the height dimension of the object
     * @return The height dimension of the object
     */

    public int getHeight() {
        return height;
    }
}