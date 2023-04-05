package foodtruckfrenzy.Drawable.Vehicle;

import java.util.ArrayList;

import foodtruckfrenzy.Drawable.DrawableEnum;
import foodtruckfrenzy.Drawable.Item.ScoreType;
import foodtruckfrenzy.Drawable.Item.ScoreValue;
import foodtruckfrenzy.GameFramework.Grid;
import foodtruckfrenzy.GameFramework.Scoreboard;

/**
 * Represents a Food Truck object that can move around a grid and interact with different score values on the grid.
 * Inherits from the Vehicle class and adds scoreboard attributes for damage, fines, and score, as well as attributes
 * for the number of ingredients and recipes found.
 */
public class FoodTruck extends Vehicle {

    private Scoreboard _scoreboard;
    private ArrayList<Cop> _cops = new ArrayList<Cop>();


    /**
     * Creates a new Food Truck object at the specified row and column of the grid.
     * @param row the row of the food truck's starting position.
     * @param col the column of the food truck's starting position.
     * @param grid the grid object that the food truck will be moving on.
     */
    public FoodTruck(int row, int col, Grid grid, Scoreboard scoreboard) {
        super(row, col, grid, DrawableEnum.FOODTRUCK_RIGHT);
        _scoreboard = scoreboard;
    }

    /**
     * Moves the Food Truck up one cell on the grid and updates its sprite accordingly.
     * @return true if the food truck was able to move up, false otherwise.
     */
    @Override
    public boolean moveUp() {
        boolean moved = super.moveUp();
        this.setType(DrawableEnum.FOODTRUCK_UP);

        if (moved) {
            interact();
            sendUpdate(Direction.UP);
        }

        return moved;
    }

    public Scoreboard getScoreboard() {
        return _scoreboard;
    }

    /**
     * Moves the Food Truck down one cell on the grid and updates its sprite accordingly.
     * @return true if the food truck was able to move down, false otherwise.
     */
    @Override
    public boolean moveDown() {
        boolean moved = super.moveDown();
        this.setType(DrawableEnum.FOODTRUCK_DOWN);

        if (moved) {
            interact();
            sendUpdate(Direction.DOWN);
        }

        return moved;
    }

    /**
     * Moves the Food Truck right one cell on the grid and updates its sprite accordingly.
     * @return true if the food truck was able to move right, false otherwise.
     */
    @Override
    public boolean moveRight() {
        boolean moved = super.moveRight();
        this.setType(DrawableEnum.FOODTRUCK_RIGHT);
        
        if (moved) {
            interact();
            sendUpdate(Direction.RIGHT);
        }

        return moved;
    }

    /**
     * Moves the Food Truck left one cell on the grid and updates its sprite accordingly.
     * @return true if the food truck was able to move left, false otherwise.
     */
    @Override
    public boolean moveLeft() {
        boolean moved = super.moveLeft();
        this.setType(DrawableEnum.FOODTRUCK_LEFT);

        if (moved) {
            interact();
            sendUpdate(Direction.LEFT);
        }

        return moved;
    }

    /**
     * Interacts with the current cell on the grid that the Food Truck is in, adding score and updating 
     * attributes as necessary.
     */
    public void interact() {
        ScoreValue scoreValue = this.getGrid().interact(this.getRow(), this.getCol());

        if (scoreValue == null) 
            return;

        int value = scoreValue.getValue();
        ScoreType scoreType = scoreValue.getScoreType();

        _scoreboard.addScore(value);

        switch(scoreType) {
            case FOOD:
                _scoreboard.addIngredientsFound();
                break;
            case DAMAGE:
                _scoreboard.addDamage(value);
                break;
            case SPEED:
                _scoreboard.addFines(value);
                break;
            case BONUS:
                _scoreboard.addRecipesFound();
                break;
            default:
                break;
        }

    }

    /**
     * Attaches instance of cop for observer pattern
     * @param cop is a cop instance to be added to the arrayList
     */
    public void attach(Cop cop) {
        _cops.add(cop);
    }

    /**
     * Returns an arrayList of cop objects for testing
     * @return an arrayList of cop objects
     */
    public ArrayList<Cop> getCops() {
        return _cops; 
    }

    /**
     * Appends to movements for each cop to follow by calling addDirections for each cop instance
     * @param direction is a enum for the direction the cop needs to move to
     */
    private void sendUpdate(Direction direction) {
        for (Cop cop : _cops) {
            cop.addDirection(direction);
        }
    }
}
