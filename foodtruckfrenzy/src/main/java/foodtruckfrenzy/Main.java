package foodtruckfrenzy;

import foodtruckfrenzy.SecondaryUI.Frame;
import foodtruckfrenzy.SecondaryUI.ScreenType;

/**
 * The Main Class creates a new Title Screen Frame object.
 */
public class Main {

    /**
     * Default Main constructor used to start the game.
     */
    public Main() {}
    /**
     * Main function of the program.
     * Creates and Displays the Title Screen on program startup
     * @param args arguments passed to the program
     */
    public static void main(String[] args) {
        new Frame(ScreenType.TITLE, null);
    }
}
