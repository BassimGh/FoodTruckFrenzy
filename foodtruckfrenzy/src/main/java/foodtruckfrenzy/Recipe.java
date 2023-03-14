package foodtruckfrenzy;

public class Recipe extends Item {
    public static int _count = 0;
    public Recipe(int row, int col) {
        super(row, col, DrawableEnum.RECIPE, 400, ScoreType.BONUS);
        Recipe._count++;
    }

    public static int getCount() {
        return _count;
    }

    public static void resetCount() {
        _count = 0;
    }
    
}
