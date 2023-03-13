package foodtruckfrenzy;
import java.awt.event.ActionListener;

public class PauseScreen extends Screen {


    public PauseScreen(ActionListener startListener, ActionListener exitListener) {
        super(startListener, exitListener, "/foodtruckfrenzy/paused.png", "/foodtruckfrenzy/resume.png", "/foodtruckfrenzy/restart.png");
    }
}
