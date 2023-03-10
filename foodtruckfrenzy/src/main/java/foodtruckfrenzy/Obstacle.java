package foodtruckfrenzy;

public abstract class Obstacle extends Item {

    public Obstacle(int row, int col, Grid grid, String imageName) {
        super(row, col, grid, imageName);
    }
}
