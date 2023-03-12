package foodtruckfrenzy;

public class SpeedTrap extends Trap {

    public SpeedTrap(int row, int col) {
        super(row, col, DrawableEnum.SPEED_TRAP, -196, ScoreType.SPEED);
    }
    
}
