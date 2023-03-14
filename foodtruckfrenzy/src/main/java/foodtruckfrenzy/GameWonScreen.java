package foodtruckfrenzy;

import java.awt.event.ActionListener;

public class GameWonScreen extends GameOverScreen {
    public GameWonScreen(ActionListener startListener, ActionListener exitListener, Scoreboard scoreboard) {
        super(startListener, exitListener, "youwin.png", "restart.png", "exit.png", scoreboard);
    }
}