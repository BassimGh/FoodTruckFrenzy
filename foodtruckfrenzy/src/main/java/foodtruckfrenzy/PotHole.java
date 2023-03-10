package foodtruckfrenzy;

import java.awt.Color;

public class PotHole extends Obstacle {

    
    public PotHole(int row, int col, Grid grid) {
        super(row, col, grid);
    }

    @Override
    public Color getGraphic() {
        return Color.DARK_GRAY;
    }
    
}
