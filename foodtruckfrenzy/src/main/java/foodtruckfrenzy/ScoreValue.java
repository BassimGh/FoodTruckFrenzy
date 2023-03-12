package foodtruckfrenzy;

public class ScoreValue {
    private ScoreType _scoreType;
    private int _value;

    public ScoreValue(ScoreType scoreType, int value){
        _scoreType = scoreType;
        _value = value;
    }

    public ScoreType getScoreType() {
        return _scoreType;
    }

    public int getValue() {
        return _value;
    }
}
