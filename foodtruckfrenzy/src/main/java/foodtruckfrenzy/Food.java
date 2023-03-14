package foodtruckfrenzy;

public class Food extends Item {

    private static int _count = 0;
    public Food(int row, int col) {
        super(row, col, DrawableEnum.FOOD, 200, ScoreType.FOOD);
        Food._count++;
    }

    public static int getCount() {
        return _count;
    }

    public static void resetCount() {
        _count = 0;
    }
    
}
