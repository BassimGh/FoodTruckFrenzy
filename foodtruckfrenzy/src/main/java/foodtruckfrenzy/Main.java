package foodtruckfrenzy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * The Main Class sets up and displays the initial window frame and event listeners for the Title Screen of the Food Truck Frenzy game.
 * It has the option to Start or Exit the Game
 * @param args arguments passed to the program
 */

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Food Truck Frenzy");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                ActionListener startListener = new ActionListener() {
                    /**
                     * Is invoked when the start button is clicked
                     * @param e is the action event that occurred
                     */
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Start button clicked");
                        Game game = new Game();
                        game.startTimer();
                        frame.dispose(); // close the TitleScreen window
                    }
                };

                ActionListener exitListener = new ActionListener() {
                    /**
                     * Is invoked when the exit button is clicked
                     * @param e is the action event that occurred
                     */
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Exit button clicked");
                        System.exit(0);
                    }
                };

                /**
                 * Creates a new instance of TitleScreen and initializes it with the given startListener and exitListener.
                 * @param startListener an ActionListener that will be called when the start button on the title screen is clicked
                 * @param exitListener an ActionListener that will be called when the exit button on the title screen is clicked
                 * @return a new instance of TitleScreen with the given action listeners
                 */

                Screen titleScreen = new TitleScreen(startListener, exitListener);

                frame.getContentPane().add(titleScreen);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

            }
        });
    }
}
