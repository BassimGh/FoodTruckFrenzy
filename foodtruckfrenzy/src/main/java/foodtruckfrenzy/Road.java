package foodtruckfrenzy;

import java.awt.Color;

public class Road extends Cell {

    public Road(int row, int col) {
        super(row, col);
    }

    @Override
    public Color getGraphic() {
        return Color.BLUE;
    }
    
}
