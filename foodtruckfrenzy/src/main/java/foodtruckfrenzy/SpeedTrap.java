package foodtruckfrenzy;

import java.awt.Color;

public class SpeedTrap extends Obstacle {


    public SpeedTrap(int row, int col) {
        super(row, col);
    }

    @Override
    public Color getGraphic() {
        return Color.LIGHT_GRAY;
    }
    
}
