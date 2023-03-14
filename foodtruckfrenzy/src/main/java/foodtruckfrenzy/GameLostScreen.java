package foodtruckfrenzy;

import java.awt.event.ActionListener;

public class GameLostScreen extends GameOverScreen {
    public GameLostScreen(ActionListener startListener, ActionListener exitListener, Scoreboard scoreboard) {
        super(startListener, exitListener, "/foodtruckfrenzy/youlose.png", "/foodtruckfrenzy/restart.png", "/foodtruckfrenzy/exit.png", scoreboard);
    }
}