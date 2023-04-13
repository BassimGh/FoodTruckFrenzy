package foodtruckfrenzy.SecondaryUI;

/**
 *The ImagePaths class contains the image file paths to be supplied by each type of child class to the Screen class
 *Each class will create a new ImagePath object and supply custom Strings that are the file paths
 */

public class ImagePaths {

    /**
     * The path to the background image file.
     */
    protected String backgroundPath;

    /**
     * The path to the first button image file.
     */
    protected String button1Path;

    /**
     * The path to the second button image file.
     */
    protected String button2Path;

/**
 * Constructs a new ImagePaths object with the specified paths to image files
 * @param backgroundPath the path to the background image file
 * @param button1Path the path to the first button image file
 * @param button2Path the path to the second button image file
 */

    public ImagePaths(String backgroundPath, String button1Path, String button2Path) {
        this.backgroundPath = backgroundPath;
        this.button1Path = button1Path;
        this.button2Path = button2Path;
    }

    /**
     * Returns the path to the background image file
     * @return path to background image
     */
    public String getBackgroundPath() {
        return backgroundPath;
    }

    /**
     * Returns the path to the first button image file
     * @return button1 img path
     */
    public String getButton1Path() {
        return button1Path;
    }

    /**
     * Returns the path to the second button image file
     * @return button2 img path
     */
    public String getButton2Path() {
        return button2Path;
    }
}
