package foodtruckfrenzy.SecondaryUI;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;

import foodtruckfrenzy.GameFramework.Game;
import foodtruckfrenzy.GameFramework.Scoreboard;

/**
 * The Frame class sets up the JFrame for the TitleScreen, GameLostScreen, and GameWonScreen to be displayed
 * It creates the specific Screen object to be displayed depending on what is needed
 */

public class Frame extends JFrame {
    /**
     * Constructs a Frame object with specified screenType and Scoreboard object
     * @param screenType specifies the type of screen to be displayed on the JFrame
     * @param scoreboard the Scoreboard object used to display the final score, time, and values on the GameOverScreen objects
     */

    public Frame(ScreenType screenType, Scoreboard scoreboard) {
        
        ActionListener startGameListener = new ActionListener() {
            /**
             * Is invoked when the start button is clicked (starts the game)
             * @param e is the action event that occurred
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                Game game = new Game();
                game.startTimer();
                dispose();
            }
        };

        ActionListener closeAppListener = new ActionListener() {
            /**
             * Is invoked when the exit button is clicked (exits the game)
             * @param e is the action event that occurred
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        };


        /**
         * Sets up the JFrame and Screen object based on desired screenType
         * If the screenType is GAME_WON it will create a GameWonScreen object and set the JFrame title to "Game Won!"
         * If the screenType is GAME_LOST it will create a GameLostScreen object and set the JFrame title to "Game Lost!"
         * If the screenType is TITLE, it creates a TitleScreen object and set the JFrame title to "Food Truck Frenzy"
         * The Action listener objects handle events when buttons are clicked (depending on screenType: restart, start, and closeApp)
         * Sets the Frame's DefaultCloseOperation
         * Screen object is added to the JFrame content pane
         * The JFrame is packed using pack()
         * The JFrame is centred on the screen
         * The JFrame is set to visible and shown using the setVisible() method
         */
        
        Screen screen;
        
        switch(screenType) {
            case GAME_WON:
                screen = new GameWonScreen(startGameListener, closeAppListener, scoreboard);
                this.setTitle("Game Won!");
                break;
            
            case GAME_LOST:
                screen = new GameLostScreen(startGameListener, closeAppListener, scoreboard);
                this.setTitle("Game Lost!");
                break;

            case TITLE:
                screen = new TitleScreen(startGameListener, closeAppListener);
                this.setTitle("Food Truck Frenzy");
                break;
            default:
                System.err.print("Invalid Frame Type");
                throw new IllegalArgumentException();
        }

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().add(screen);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}

