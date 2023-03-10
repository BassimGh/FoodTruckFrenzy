package foodtruckfrenzy;

import java.awt.Color;

public class Obstruction extends Cell {

    public Obstruction(int row, int col) {
        super(row, col);
    }

    @Override
    public Color getGraphic() {
        return Color.BLACK;
    }
    
}
