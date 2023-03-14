package foodtruckfrenzy;

import java.awt.event.ActionListener;

public class GameWonScreen extends GameOverScreen {
    public GameWonScreen(ActionListener startListener, ActionListener exitListener, Scoreboard scoreboard) {
        super(startListener, exitListener, "/foodtruckfrenzy/youwin.png", "/foodtruckfrenzy/restart.png", "/foodtruckfrenzy/exit.png", scoreboard);
    }
}