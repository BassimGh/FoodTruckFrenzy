package foodtruckfrenzy.SecondaryUI;

import java.awt.event.ActionListener;
/**
 * The TitleScreen class extends the Screen class to display the initial Title Screen when the game is launched
 */
public class TitleScreen extends Screen {

    /**
     * Constructs a TitleScreen object with the specified ActionListeners for the start and exit buttons.
     * Constructs the TitleScreen object with the specific file paths for the background, start button, and exit button images.
     * @param startListener The ActionListener to handle start button events.
     * @param exitListener The ActionListener to handle exit button events.
     * {@code ImagePaths} supplies the String image paths to the specified images used in the parent Screen class.
     * {@code Dimensions} supplies the custom int values for the height and the width of the TitleScreen
     */

    public TitleScreen(ActionListener startListener, ActionListener exitListener) {
        /**
         * passes listeners, the image file paths, and the custom screen dimensions
         */
        super(startListener, exitListener, new ImagePaths("background.png", "start.png", "exit.png"), new Dimensions(800, 600));
    }
}
