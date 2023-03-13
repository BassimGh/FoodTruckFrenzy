package foodtruckfrenzy;

public class Recipe extends Item {

    public Recipe(int row, int col) {
        super(row, col, DrawableEnum.RECIPE, 1000, ScoreType.BONUS);
    }
    
}
