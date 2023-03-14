package foodtruckfrenzy;

import java.awt.Graphics2D;

public class Glitter extends Item {

    private int drawn = 0;

    public Glitter(int row, int col) {
        super(row, col, DrawableEnum.PICKUP_GLITTER, 0, ScoreType.NULL);
    } 

    @Override
    public void draw(Graphics2D g2d) {
        if (drawn < 20) {
            super.draw(g2d);
            drawn++;
        }
    }
}
