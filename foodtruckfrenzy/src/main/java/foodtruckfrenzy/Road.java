package foodtruckfrenzy;

import java.awt.Graphics2D;

public class Road extends BoardElement {

    private Item _item;

    public Road(int row, int col, Item item, DrawableEnum drawable) {
        super(row, col, drawable);
        _item = item;
    }

    @Override
    public void draw(Graphics2D g2d) {
        super.draw(g2d);

        if (!(_item == null))
            _item.draw(g2d);
    }

    @Override
    public ScoreValue interact() {
        
        if (_item == null)
            return null;

        int value = _item.getValue();
        ScoreType scoreType = _item.getScoreType();

        System.out.println("Interacted with value of " + value);

        if (value>0) {
            _item = null;
        }

        return new ScoreValue(scoreType, value);
    }
}
