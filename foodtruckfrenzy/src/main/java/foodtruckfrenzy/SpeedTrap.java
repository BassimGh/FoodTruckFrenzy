package foodtruckfrenzy;

import java.awt.Color;

public class SpeedTrap extends Obstacle {

    public SpeedTrap() {
        super(-150);
    }

    @Override
    public Color getGraphic() {
        return Color.LIGHT_GRAY;
    }
    
}
