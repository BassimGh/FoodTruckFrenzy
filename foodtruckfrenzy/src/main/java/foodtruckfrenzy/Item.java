package foodtruckfrenzy;

public class Item extends Drawable {

    private int _value;
    private ScoreType _scoreType;

    public Item(int row, int col, DrawableEnum type, int value, ScoreType scoreType) {
        super(row, col, type);
        _value = value;
        _scoreType = scoreType;
    }
    
    public int getValue() {
        return _value;
    }
    
    public ScoreType getScoreType() {
        return _scoreType;
    }
}
