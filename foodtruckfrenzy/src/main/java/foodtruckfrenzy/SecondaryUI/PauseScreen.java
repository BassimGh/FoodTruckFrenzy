package foodtruckfrenzy.SecondaryUI;
import java.awt.event.ActionListener;

/**
 * The PauseScreen class extends the Screen class to display a pause screen for a game or application.
 */

public class PauseScreen extends Screen {

    /**
     * Constructs a PauseScreen object with the specified ActionListeners for the resume and restart buttons.
     * Constructs the PauseScreen object with the file paths for the paused background, resume button, and restart button images.
     * @param resumeListener The ActionListener to handle resume button events.
     * @param restartListener The ActionListener to handle restart button events.
     * {@code ImagePaths} supplies the String image paths to the specified images used in the parent Screen class.
     * {@code Dimensions} supplies the custom int values for the height and the width of the PauseScreen
     */ 

    public PauseScreen(ActionListener resumeListener, ActionListener restartListener) {
        super(resumeListener, restartListener, new ImagePaths("paused.png", "resume.png", "restart.png"), new Dimensions(1312,740));
    }
}
