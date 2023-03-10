package foodtruckfrenzy;

import java.awt.Color;

public class Obstruction extends Cell {

    public Obstruction(int row, int col, Grid grid) {
        super(row, col, grid);
    }

    @Override
    public Color getGraphic() {
        return Color.BLACK;
    }
    
}
