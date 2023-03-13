package foodtruckfrenzy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Food Truck Frenzy");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                ActionListener startListener = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Start button clicked");
                        Game game = new Game();
                        game.startTimer();
                        frame.dispose(); // close the TitleScreen window
                    }
                };

                ActionListener exitListener = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Exit button clicked");
                        System.exit(0);
                    }
                };

                Screen titleScreen = new TitleScreen(startListener, exitListener);

                frame.getContentPane().add(titleScreen);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                /* ADD THIS TO END GAME STATE TO DISPLAY WIN OR LOSS
                Screen gameLostScreen = new GameLostScreen(startListener, exitListener,1,2,3,4,5);

                // Add the GameLost screen object to the JFrame
                frame.getContentPane().add(gameLostScreen);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
        
                Screen gameWonScreen = new GameWonScreen(startListener, exitListener,1,2,3,4,5);
        
                // Add the GameLost screen object to the JFrame
                frame.getContentPane().add(gameWonScreen);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true); */

            }
        });
    }
}
