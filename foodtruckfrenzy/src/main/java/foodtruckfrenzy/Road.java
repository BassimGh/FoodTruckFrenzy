package foodtruckfrenzy;

import java.awt.Color;

public class Road extends Cell {

    public Road(int row, int col, Grid grid) {
        super(row, col, grid);
    }

    @Override
    public Color getGraphic() {
        return Color.BLUE;
    }
    
}
