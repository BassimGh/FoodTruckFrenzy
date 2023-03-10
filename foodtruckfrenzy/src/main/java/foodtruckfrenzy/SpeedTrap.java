package foodtruckfrenzy;

import java.awt.Color;

public class SpeedTrap extends Obstacle {


    public SpeedTrap(int row, int col, Grid grid) {
        super(row, col, grid);
    }

    @Override
    public Color getGraphic() {
        return Color.LIGHT_GRAY;
    }
    
}
