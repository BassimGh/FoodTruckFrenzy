package foodtruckfrenzy.SecondaryUI;

/**
 *The ImagePaths class contains the image file paths to be supplied by each type of child class to the Screen class
 *Each class will create a new ImagePath object and supply custom Strings that are the file paths
 */

public class ImagePaths {

    //The paths to the background, button1, and button2 image file paths
    protected String backgroundPath;
    protected String button1Path;
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
     * @return the path to the background image file
     */
    public String getBackgroundPath() {
        return backgroundPath;
    }

    /**
     * Returns the path to the first button image file
     * @return the path to the first button image file
     */

    public String getButton1Path() {
        return button1Path;
    }

    /**
     * Returns the path to the second button image file
     * @return the path to the second button image file
     */

    public String getButton2Path() {
        return button2Path;
    }
    
}
