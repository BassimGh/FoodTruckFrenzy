package foodtruckfrenzy;

import java.awt.event.ActionListener;

public class TitleScreen extends Screen {

    public TitleScreen(ActionListener startListener, ActionListener exitListener) {
        super(startListener, exitListener, "/foodtruckfrenzy/background.png", "/foodtruckfrenzy/start.png", "/foodtruckfrenzy/exit.png");
    }
}
