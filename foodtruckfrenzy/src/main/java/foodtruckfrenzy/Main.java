package foodtruckfrenzy;

import foodtruckfrenzy.SecondaryUI.Frame;
import foodtruckfrenzy.SecondaryUI.ScreenType;

/**
 * The Main Class creates a new Title Screen Frame object.
 * @param args arguments passed to the program
 */

public class Main {

    public static void main(String[] args) {
        /**
         * Creates and Displays the Title Screen on program startup
         */
        new Frame(ScreenType.TITLE, null);
    }
}
