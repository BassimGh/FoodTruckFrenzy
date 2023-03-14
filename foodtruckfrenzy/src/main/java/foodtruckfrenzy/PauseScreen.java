package foodtruckfrenzy;
import java.awt.event.ActionListener;

/**
 * The PauseScreen class extends the Screen class to display a pause screen for a game or application.
 */

public class PauseScreen extends Screen {

    /**
     * Constructs a PauseScreen object with the specified ActionListeners for the resume and restart buttons.
     * Constructs the PauseScreen object with the file paths for the paused background, resume button, and restart button images.
     * 
     * @param startListener The ActionListener to handle resume button events.
     * @param exitListener The ActionListener to handle restart button events.
     */

    public PauseScreen(ActionListener startListener, ActionListener exitListener) {
        super(startListener, exitListener, "/foodtruckfrenzy/paused.png", "/foodtruckfrenzy/resume.png", "/foodtruckfrenzy/restart.png");
    }
}
