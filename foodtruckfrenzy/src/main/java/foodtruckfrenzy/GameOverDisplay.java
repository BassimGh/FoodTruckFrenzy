package foodtruckfrenzy;

import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class GameOverDisplay {
    private Screen screen;
    private JFrame frame;

    public GameOverDisplay(ScreenType screenType, ActionListener startListener, ActionListener exitListener, Scoreboard scoreboard) {
        if (screenType == ScreenType.GAME_WON) {
            screen = new GameWonScreen(startListener, exitListener, scoreboard);
            frame = new JFrame("Game Won!");
        } else if (screenType == ScreenType.GAME_LOST) {
            screen = new GameLostScreen(startListener, exitListener, scoreboard);
            frame = new JFrame("Game Lost!");
        } else {
            throw new IllegalArgumentException("Invalid ScreenType");
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(screen);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

enum ScreenType {
    GAME_WON,
    GAME_LOST
}
