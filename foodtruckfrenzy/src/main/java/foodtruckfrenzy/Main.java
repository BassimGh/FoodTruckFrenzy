package foodtruckfrenzy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Title Screen Test");
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

                TitleScreen titleScreen = new TitleScreen(startListener, exitListener);
                frame.getContentPane().add(titleScreen);

                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}
