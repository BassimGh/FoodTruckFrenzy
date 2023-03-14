package foodtruckfrenzy;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;

public class Frame {
    private Screen _screen;
    private JFrame _frame;

    public Frame(ScreenType screenType, Scoreboard scoreboard) {
        
        ActionListener startGameListener = new ActionListener() {
            /**
             * Is invoked when the start button is clicked
             * @param e is the action event that occurred
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                Game game = new Game();
                game.startTimer();
                _frame.dispose(); // close the TitleScreen window
            }
        };

        ActionListener closeAppListener = new ActionListener() {
            /**
             * Is invoked when the exit button is clicked
             * @param e is the action event that occurred
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        };

        ActionListener restartListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.main(null);
                _frame.dispose();
            }
        };
        
        switch(screenType) {
            case GAME_WON:
                _screen = new GameWonScreen(restartListener, closeAppListener, scoreboard);
                _frame = new JFrame("Game Won!");
                break;
            
            case GAME_LOST:
                _screen = new GameLostScreen(restartListener, closeAppListener, scoreboard);
                _frame = new JFrame("Game Lost!");
                break;

            case TITLE:
                _screen = new TitleScreen(startGameListener, closeAppListener);
                _frame = new JFrame("Food Truck Frenzy");
                break;
        }

        _frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        _frame.getContentPane().add(_screen);
        _frame.pack();
        _frame.setLocationRelativeTo(null);
        _frame.setVisible(true);
    }
}

enum ScreenType {
    TITLE,
    GAME_WON,
    GAME_LOST
}
