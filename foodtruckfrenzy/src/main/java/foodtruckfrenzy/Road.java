package foodtruckfrenzy;

import java.awt.Graphics2D;

public class Road extends BoardElement {

    private DrawableEnum _item;

    public Road(int row, int col, DrawableEnum item) {
        super(row, col, DrawableEnum.ROAD);
        _item = item;
    }

    @Override
    public void draw(Graphics2D g2d) {
        super.draw(g2d);

        if (_item != null)
            g2d.drawImage(SpriteLoader.getImage(_item), this.getCol() * Grid.CELL_SIZE, this.getRow() * Grid.CELL_SIZE, Grid.CELL_SIZE, Grid.CELL_SIZE, null);
    }
}
