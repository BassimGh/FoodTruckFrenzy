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

    @Override
    public int interact() {
        
        if (_item == null)
            return 0;

        int value = _item.getValue();

        System.out.println("Interacted with value of " + value);

        return value;
        
    }
}
