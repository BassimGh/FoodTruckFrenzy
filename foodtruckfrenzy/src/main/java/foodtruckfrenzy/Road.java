package foodtruckfrenzy;

import java.awt.Graphics2D;

public class Road extends BoardElement {

    private Item _item;

    public Road(int row, int col, Item item) {
        super(row, col, DrawableEnum.ROAD);
        _item = item;
    }

    @Override
    public void draw(Graphics2D g2d) {
        super.draw(g2d);

        if (!(_item == null))
            _item.draw(g2d);
    }
}
