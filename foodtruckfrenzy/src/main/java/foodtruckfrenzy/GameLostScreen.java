package foodtruckfrenzy;

import java.awt.event.ActionListener;

public class GameLostScreen extends Screen {

    public GameLostScreen(ActionListener startListener, ActionListener exitListener) {
        super(startListener, exitListener, "youlose.png", "restart.png", "exit.png");
    }
}
