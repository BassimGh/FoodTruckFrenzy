package foodtruckfrenzy;

import java.awt.event.ActionListener;

public class GameWonScreen extends Screen {

    public GameWonScreen(ActionListener startListener, ActionListener exitListener) {
        super(startListener, exitListener, "youwin.png", "restart.png", "exit.png");
    }
}
