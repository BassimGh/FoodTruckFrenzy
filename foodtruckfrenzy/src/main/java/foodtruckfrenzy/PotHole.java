package foodtruckfrenzy;

import java.awt.Color;

public class PotHole extends Obstacle {

    public PotHole() {
        super(-100);
    }
    
    @Override
    public Color getGraphic() {
        return Color.DARK_GRAY;
    }
    
}
