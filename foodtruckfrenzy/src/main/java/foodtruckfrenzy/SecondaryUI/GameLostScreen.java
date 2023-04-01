package foodtruckfrenzy.SecondaryUI;

import java.awt.event.ActionListener;

import foodtruckfrenzy.GameFramework.Scoreboard;

/**
 * The GameLostScreen class extends the GameOverScreen class to display a screen for when the game is lost.
 * The purpose of this class is to pass the specific file paths, listeners, and Scoreboard to its parent class
 */

public class GameLostScreen extends GameOverScreen {
    /**
     * Constructs a GameLostScreen object with the specified ActionListeners for the start and exit buttons.
     * Constructs the GameLostScreen with the file paths for the game lost background, restart button, and exit button images, and the Scoreboard object.
     * The Scoreboard object is passed so that the final game values and scores + final time can be displayed
     * @param startListener The ActionListener to handle start button events.
     * @param exitListener The ActionListener to handle exit button events.
     * @param scoreboard The Scoreboard object to display the final score, values, and time on the screen.
     * @param ImagePaths Set the image paths for the screen to display
     */
    public GameLostScreen(ActionListener startListener, ActionListener exitListener, Scoreboard scoreboard) {
        //passes listeners, the image file paths, and the scoreboard object
        super(startListener, exitListener, new ImagePaths ("youlose.png", "restart.png", "exit.png"), scoreboard); 
    }
}