package foodtruckfrenzy;

import java.awt.event.ActionListener;
/**
 * The TitleScreen class extends the Screen class to display the initial Title Screen when the game is launched
 */
public class TitleScreen extends Screen {

    /**
     * Constructs a TitleScreen object with the specified ActionListeners for the start and exit buttons.
     * Constructs the TitleScreen object with the specific file paths for the background, start button, and exit button images.
     * 
     * @param startListener The ActionListener to handle start button events.
     * @param exitListener The ActionListener to handle exit button events.
     */

    public TitleScreen(ActionListener startListener, ActionListener exitListener) {
        super(startListener, exitListener, "/foodtruckfrenzy/background.png", "/foodtruckfrenzy/start.png", "/foodtruckfrenzy/exit.png", 800, 600);
    }
}
