package foodtruckfrenzy.Drawable.Item;

import foodtruckfrenzy.Drawable.DrawableEnum;

/**
 * Recipie class extends Item class, representing a bonus item that can be collected
 * Recipies are created with a specified row and column, and their drawable type is set to RECIPIE
 * They have a BONUS positive score
 */
public class Recipe extends Item {
    /**
     * Constructs a new Recipe object with a specified row and column, drawable type, and bonus score value.
     * Increases the instance counter.
     * @param row the row of the Recipe on the game grid
     * @param col the column of the Recipe on the game grid
     */
    public Recipe(int row, int col) {
        super(row, col, DrawableEnum.RECIPE, 200, ScoreType.BONUS);
    }   
}
